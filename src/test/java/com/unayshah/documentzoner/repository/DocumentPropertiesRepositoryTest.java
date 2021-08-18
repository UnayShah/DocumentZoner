package com.unayshah.documentzoner.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
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

    static Integer zoneCount;
    String pdfPathname = "src/main/resources/static/testPDF.pdf";
    String pdfExtension = "pdf";
    String customDocumentName = "Custom Name";
    static String id;

    @BeforeAll
    public static void beforeZoneTest() {
        zoneCount = 1 + new Random().nextInt(9);
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
            documentProperties = new DocumentProperties(mockMultipartFile);
            for (int i = 0; i < zoneCount; documentProperties.addZone(new Zone()), i++)
                ;
            id = documentProperties.getId();
        } catch (IOException e) {
            fail();
        }
        assertTrue(documentPropertiesRepository.save(documentProperties).equals(documentProperties));
        documentPropertiesRepository.deleteById(id);
    }

    @Test
    @Order(2)
    public void saveCustomNameDocumentProperties() {
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
    @Order(3)
    public void findDocumentProperties() {
        documentProperties = documentPropertiesRepository.findById(id).get();
        assertNotNull(documentProperties);
        assertNotNull(documentProperties.getZones());
        assertEquals(documentProperties.getZones().size(), zoneCount);
        assertNotNull(documentProperties.getDocument());
        assertNotNull(documentProperties.getDocument().getActualDocumentName());
        assertNotNull(documentProperties.getDocument().getDocumentName());
        assertNotNull(documentProperties.getDocument().getExtension());
        assertNotNull(documentProperties.getDocument().getFileContent());
        assertNotNull(documentProperties.getId());
        assertTrue(documentProperties.getId().equals(id));
    }

    @Test
    @Order(4)
    public void findAllDocumentProperties() {
        List<DocumentProperties> listDocumentProperties = documentPropertiesRepository.findAll();
        assertEquals(listDocumentProperties.size(), 2);
        for (DocumentProperties documentProperties : listDocumentProperties) {
            assertNotNull(documentProperties);
            assertNotNull(documentProperties.getDocument());
            assertNotNull(documentProperties.getZones());
            assertEquals(documentProperties.getZones().size(), zoneCount);
            assertNotNull(documentProperties.getDocument().getActualDocumentName());
            assertNotNull(documentProperties.getDocument().getDocumentName());
            assertNotNull(documentProperties.getDocument().getExtension());
            assertNotNull(documentProperties.getDocument().getFileContent());
            assertNotNull(documentProperties.getId());
        }
    }

    @Test
    @Order(3)
    public void findShortDocumentProperties() {
        documentProperties = documentPropertiesRepository.findByIdShort(id).get();
        assertNotNull(documentProperties);
        assertNotNull(documentProperties.getDocument());
        assertNotNull(documentProperties.getZones());
        assertEquals(documentProperties.getZones().size(), 0);
        assertNotNull(documentProperties.getDocument().getActualDocumentName());
        assertNotNull(documentProperties.getDocument().getDocumentName());
        assertNotNull(documentProperties.getDocument().getExtension());
        assertNull(documentProperties.getDocument().getFileContent());
        assertNotNull(documentProperties.getId());
        assertTrue(documentProperties.getId().equals(id));
    }

    @Test
    @Order(4)
    public void findAllShortDocumentProperties() {
        List<DocumentProperties> listDocumentProperties = documentPropertiesRepository.findAllShort();
        assertEquals(listDocumentProperties.size(), 2);
        for (DocumentProperties documentProperties : listDocumentProperties) {
            assertNotNull(documentProperties);
            assertNotNull(documentProperties.getDocument());
            assertNotNull(documentProperties.getZones());
            assertEquals(documentProperties.getZones().size(), 0);
            assertNotNull(documentProperties.getDocument().getActualDocumentName());
            assertNotNull(documentProperties.getDocument().getDocumentName());
            assertNotNull(documentProperties.getDocument().getExtension());
            assertNull(documentProperties.getDocument().getFileContent());
            assertNotNull(documentProperties.getId());
        }

    }

    @Test
    @Order(5)
    public void deleteDocumentProperties() {
        assertTrue(documentPropertiesRepository.findById(id).isPresent());
        documentPropertiesRepository.deleteById(id);
        assertFalse(documentPropertiesRepository.findById(id).isPresent());

    }

    // @Test
    // @Order(6)
    // public void deleteAllDocumentProperties() {
    //     assertNotEquals(documentPropertiesRepository.findAll().size(), 0);
    //     documentPropertiesRepository.deleteAll();
    //     assertEquals(documentPropertiesRepository.findAll().size(), 0);
    // }

}
