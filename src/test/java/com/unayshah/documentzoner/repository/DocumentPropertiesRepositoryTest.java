package com.unayshah.documentzoner.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

import com.unayshah.documentzoner.dao.DocumentProperties;
import com.unayshah.documentzoner.dao.Zone;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class DocumentPropertiesRepositoryTest {

    @Mock
    DocumentProperties documentProperties;

    @Autowired
    private DocumentPropertiesRepository documentPropertiesRepository;

    Integer zoneCount = 1 + new Random().nextInt(10);
    String pdfPathname = "src/main/resources/static/testPDF.pdf";
    String pdfExtension = "pdf";
    String customDocumentName = "Custom Name";
    static String id;

    @BeforeAll
    public static void beforeZoneTest() {
        System.err.println("Performing Document Properties Repository test");
    }

    @AfterAll
    public static void afterZoneTest() {
        System.err.println("Document Properties Repository test completed");
    }

    @Test
    @Order(1)
    public void saveDocumentProperties() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1],
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(pdfPathname).toPath()));
            documentProperties = new DocumentProperties(customDocumentName, mockMultipartFile);
            for (int i = 0; i < zoneCount; documentProperties.addZone(new Zone()), i++)
                ;
            id = documentProperties.getId();
        } catch (IOException e) {
            fail();
        }
        assertTrue(documentPropertiesRepository.save(documentProperties).equals(documentProperties));
    }

    @Test
    @Order(2)
    public void findDocumentProperties() {
        documentPropertiesRepository.findById(id).get();
    }

    @Test
    @Order(3)
    public void deleteDocumentProperties() {
        assertTrue(documentPropertiesRepository.findById(id).isPresent());
        documentPropertiesRepository.deleteById(id);
        assertFalse(documentPropertiesRepository.findById(id).isPresent());

    }

}
