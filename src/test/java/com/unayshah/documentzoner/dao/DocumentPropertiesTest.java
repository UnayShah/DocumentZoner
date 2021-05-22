package com.unayshah.documentzoner.dao;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

@ExtendWith(MockitoExtension.class)
public class DocumentPropertiesTest {

    DocumentProperties documentProperties;

    @Mock
    Zone zone;

    Integer zoneCount = new Random().nextInt(10);
    String folderPathname = "src/main/resources/static/";
    String incorrectFilePathname = "src/main/resources/static/IncorrectFileName.abc";
    String pdfPathname = "src/main/resources/static/testPDF.pdf";
    String customName = "Custom Name";
    String pdfExtension = "pdf";

    @BeforeAll
    public static void beforeZoneTest() {
        System.err.println("Performing Document Properties test");
    }

    @AfterAll
    public static void afterZoneTest() {
        System.err.println("Document Properties test completed");
    }

    @Test
    public void emptyDocumentPropertiesConstructor() {
        documentProperties = new DocumentProperties();
        assertNotNull(documentProperties);
        assertNotNull(documentProperties.getDocument());
        assertNotNull(documentProperties.getId());
        assertNotNull(documentProperties.getZones());
        assertEquals(documentProperties.getZones().size(), 0);
        assertNull(documentProperties.getDocument().getFileContent());
        assertNull(documentProperties.getDocument().getExtension());
    }

    @Test
    public void fileTest() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1],
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(pdfPathname).toPath()));
            documentProperties = new DocumentProperties(mockMultipartFile);
            assertArrayEquals(documentProperties.getDocument().getFileContent(),
                    Files.readAllBytes(new File(pdfPathname).toPath()));
        } catch (IOException e) {
            fail();
        }
        assertEquals(documentProperties.getDocument().getExtension(), pdfExtension);
        assertNotNull(documentProperties.getId());
    }

    @Test
    public void fileCustomNameTest() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1],
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(pdfPathname).toPath()));
            documentProperties = new DocumentProperties(customName, mockMultipartFile);
            assertArrayEquals(documentProperties.getDocument().getFileContent(),
                    Files.readAllBytes(new File(pdfPathname).toPath()));
        } catch (IOException e) {
            fail();
        }
        assertEquals(documentProperties.getDocument().getDocumentName(), customName);
        assertEquals(documentProperties.getDocument().getExtension(), pdfExtension);
        assertNotNull(documentProperties.getId());
    }

    @Test
    public void documentCustomNameTest() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1],
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(pdfPathname).toPath()));
            documentProperties = new DocumentProperties(new Document(customName, mockMultipartFile));
            assertArrayEquals(documentProperties.getDocument().getFileContent(),
                    Files.readAllBytes(new File(pdfPathname).toPath()));
        } catch (IOException e) {
            fail();
        }
        assertEquals(documentProperties.getDocument().getDocumentName(), customName);
        assertEquals(documentProperties.getDocument().getExtension(), pdfExtension);
        assertNotNull(documentProperties.getId());
    }

    @Test
    public void zoneTest() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1],
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(pdfPathname).toPath()));
            documentProperties = new DocumentProperties(new Document(customName, mockMultipartFile));
            for (int i = 0; i < zoneCount; documentProperties.addZone(zone), i++)
                ;
        } catch (IOException e) {
            fail();
        }
        assertEquals(documentProperties.getZones().size(), zoneCount);
        for (int i = 0; i < zoneCount; assertEquals(documentProperties.getZones().get(i), zone), i++)
            ;
    }
}
