package com.unayshah.documentzoner.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DocumentPropertiesTest {

    DocumentProperties documentProperties;

    @Mock
    Zone zone;

    Integer zoneCount = new Random().nextInt(10);
    String folderPathname = "src/main/resources/static/";
    String incorrectFilePathname = "src/main/resources/static/IncorrectFileName.abc";
    String pdfPathname = "src/main/resources/static/testPDF.pdf";
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
    public void pathnameTest() {
        try {
            documentProperties = new DocumentProperties(pdfPathname);
        } catch (FileNotFoundException e) {
            fail();
        }
        try {
            assertEquals(documentProperties.getDocument().getDocument().getTotalSpace(),
                    new Document(pdfPathname).getDocument().getTotalSpace());
            assertEquals(documentProperties.getDocument().getExtension(), new Document(pdfPathname).getExtension());
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(documentProperties.getDocument().getExtension(), pdfExtension);
        assertNotNull(documentProperties.getId());
    }

    @Test
    public void fileTest() {
        try {
            documentProperties = new DocumentProperties(new File(pdfPathname));
        } catch (FileNotFoundException e) {
            fail();
        }
        try {
            assertEquals(documentProperties.getDocument().getDocument().getTotalSpace(),
                    new Document(pdfPathname).getDocument().getTotalSpace());
            assertEquals(documentProperties.getDocument().getExtension(), new Document(pdfPathname).getExtension());
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(documentProperties.getDocument().getExtension(), pdfExtension);
        assertNotNull(documentProperties.getId());
    }

    @Test
    public void documentTest() {
        try {
            documentProperties = new DocumentProperties(new Document(pdfPathname));
        } catch (FileNotFoundException e) {
            fail();
        }
        try {
            assertEquals(documentProperties.getDocument().getDocument().getTotalSpace(),
                    new Document(pdfPathname).getDocument().getTotalSpace());
            assertEquals(documentProperties.getDocument().getExtension(), new Document(pdfPathname).getExtension());
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(documentProperties.getDocument().getExtension(), pdfExtension);
        assertNotNull(documentProperties.getId());
    }

    @Test
    public void zoneTest() {
        try {
            documentProperties = new DocumentProperties(pdfPathname);
            for (int i = 0; i < zoneCount; documentProperties.addZone(zone), i++)
                ;
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(documentProperties.getZones().size(), zoneCount);
        for (int i = 0; i < zoneCount; assertEquals(documentProperties.getZones().get(i), zone), i++)
            ;
    }

    @Test
    public void pathnameZoneTest() {
        try {
            documentProperties = new DocumentProperties(pdfPathname);
            for (int i = 0; i < zoneCount; documentProperties.addZone(zone), i++)
                ;
        } catch (FileNotFoundException e) {
            fail();
        }
        try {
            assertEquals(documentProperties.getDocument().getDocument().getTotalSpace(),
                    new Document(pdfPathname).getDocument().getTotalSpace());
            assertEquals(documentProperties.getDocument().getExtension(), new Document(pdfPathname).getExtension());
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(documentProperties.getDocument().getExtension(), pdfExtension);
        assertNotNull(documentProperties.getId());
        for (int i = 0; i < zoneCount; assertEquals(documentProperties.getZones().get(i), zone), i++)
            ;
    }

    @Test
    public void fileZoneTest() {
        try {
            documentProperties = new DocumentProperties(new File(pdfPathname));
            for (int i = 0; i < zoneCount; documentProperties.addZone(zone), i++)
                ;
        } catch (FileNotFoundException e) {
            fail();
        }
        try {
            assertEquals(documentProperties.getDocument().getDocument().getTotalSpace(),
                    new Document(pdfPathname).getDocument().getTotalSpace());
            assertEquals(documentProperties.getDocument().getExtension(), new Document(pdfPathname).getExtension());
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(documentProperties.getDocument().getExtension(), pdfExtension);
        assertNotNull(documentProperties.getId());
        for (int i = 0; i < zoneCount; assertEquals(documentProperties.getZones().get(i), zone), i++)
            ;
    }

    @Test
    public void documentZoneTest() {
        try {
            documentProperties = new DocumentProperties(new Document(pdfPathname));
            for (int i = 0; i < zoneCount; documentProperties.addZone(zone), i++)
                ;
        } catch (FileNotFoundException e) {
            fail();
        }
        try {
            assertEquals(documentProperties.getDocument().getDocument().getTotalSpace(),
                    new Document(pdfPathname).getDocument().getTotalSpace());
            assertEquals(documentProperties.getDocument().getExtension(), new Document(pdfPathname).getExtension());
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(documentProperties.getDocument().getExtension(), pdfExtension);
        assertNotNull(documentProperties.getId());
        for (int i = 0; i < zoneCount; assertEquals(documentProperties.getZones().get(i), zone), i++)
            ;
    }

    @Test
    public void fileNotFoundTest() {
        assertThrows(FileNotFoundException.class, () -> {
            documentProperties = new DocumentProperties(incorrectFilePathname);
        });
    }
}
