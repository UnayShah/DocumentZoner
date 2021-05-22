package com.unayshah.documentzoner.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
public class UserTest {

    DocumentProperties documentProperties;

    @Mock
    Zone zone;

    @Mock
    User user;

    Integer zoneCount = 1 + new Random().nextInt(10);
    Integer documentPropertiesCount = 1 + new Random().nextInt(3);
    String folderPathname = "src/main/resources/static/";
    String incorrectFilePathname = "src/main/resources/static/IncorrectFileName.abc";
    String pdfPathname = "src/main/resources/static/testPDF.pdf";
    String customName = "Custom Name";
    String pdfExtension = "pdf";
    String username = "testUsername";
    String password = "testPassword";

    @BeforeAll
    public static void beforeZoneTest() {
        System.err.println("Performing Document Properties test");
    }

    @AfterAll
    public static void afterZoneTest() {
        System.err.println("Document Properties test completed");
    }

    @Test
    public void userTest() {
        user = new User(username, password);
        for (int i = 0; i < documentPropertiesCount; i++) {
            try {
                MockMultipartFile mockMultipartFile = new MockMultipartFile(
                        pdfPathname.split("/")[pdfPathname.split("/").length - 1],
                        pdfPathname.split("/")[pdfPathname.split("/").length - 1], "multipart/form-data",
                        Files.readAllBytes(new File(pdfPathname).toPath()));
                documentProperties = new DocumentProperties(customName, mockMultipartFile);
                for (int j = 0; j < zoneCount; documentProperties.addZone(zone), j++)
                    ;
                user.addDocumentProperties(documentProperties);
            } catch (IOException e) {
                fail();
            }
        }
        assertEquals(user.getListDocumentProperties().size(), documentPropertiesCount);
        for (DocumentProperties documentProperties : user.getListDocumentProperties()) {
            assertNotNull(documentProperties);
            assertEquals(documentProperties.getZones().size(), zoneCount);
            assertEquals(documentProperties.getDocument().getActualDocumentName(),
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1]);
            assertEquals(documentProperties.getDocument().getDocumentName(), customName);
        }
    }

}
