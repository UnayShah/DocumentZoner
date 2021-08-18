package com.unayshah.documentzoner.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

import com.unayshah.documentzoner.dao.DocumentProperties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class DocumentPropertiesServiceTest {

    @Autowired
    DocumentPropertiesService documentPropertiesService;

    Integer zoneCount = 1 + new Random().nextInt(10);
    String pdfPathname = "src/main/resources/static/testPDF.pdf";
    String pdfExtension = "pdf";
    String customDocumentName = "Custom Name";
    static String id1;
    static String id2;

    @BeforeAll
    public static void beforeZoneTest() {
        System.err.println("Performing Document Properties Service test");
    }

    @AfterAll
    public static void afterZoneTest() {
        System.err.println("Document Properties Service test completed");
    }

    // @Test
    // @Order(0)
    // public void deleteAllBefore() {
    //     documentPropertiesService.deleteAllFiles();
    // }

    @Test
    @Order(1)
    public void saveDocumentProperties() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile("file",
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(pdfPathname).toPath()));
            id1 = documentPropertiesService.saveFile(mockMultipartFile).getId();
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    @Order(2)
    public void saveDocumentCustomNameProperties() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile("file",
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(pdfPathname).toPath()));
            id2 = documentPropertiesService.saveFile(customDocumentName, mockMultipartFile).getId();
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    @Order(3)
    public void findDocumentProperties() {
        assertDoesNotThrow(() -> {
            assertArrayEquals(documentPropertiesService.findFile(id1).getDocument().getFileContent(),
                    Files.readAllBytes(new File(pdfPathname).toPath()));
        });
        assertDoesNotThrow(() -> {
            assertArrayEquals(documentPropertiesService.findFile(id2).getDocument().getFileContent(),
                    Files.readAllBytes(new File(pdfPathname).toPath()));
            assertEquals(documentPropertiesService.findFile(id2).getDocument().getDocumentName(), customDocumentName);
        });
    }

    @Test
    @Order(4)
    public void findAllDocumentProperties() {
        assertTrue(documentPropertiesService.findAllFiles().size() >= 2);
        for (DocumentProperties documentProperties : documentPropertiesService.findAllFiles())
            assertNotNull(documentProperties);
    }

    @Test
    @Order(5)
    public void deleteDocumentProperties() {
        assertDoesNotThrow(() -> {
            assertArrayEquals(documentPropertiesService.findFile(id1).getDocument().getFileContent(),
                    Files.readAllBytes(new File(pdfPathname).toPath()));
        });
        assertTrue(documentPropertiesService.deleteFile(id1));
        assertDoesNotThrow(() -> {
            assertArrayEquals(documentPropertiesService.findFile(id2).getDocument().getFileContent(),
                    Files.readAllBytes(new File(pdfPathname).toPath()));
        });
        assertTrue(documentPropertiesService.deleteFile(id2));
    }

    // @Test
    // @Order(6)
    // public void deleteAllAfter() {
    //     documentPropertiesService.deleteAllFiles();
    // }
}
