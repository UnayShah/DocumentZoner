package com.unayshah.documentzoner.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

@ExtendWith(MockitoExtension.class)
public class DocumentTest {

    @Mock
    Document document;

    String folderPathname = "src/main/resources/static/";
    String incorrectFilePathname = "src/main/resources/static/IncorrectFileName.abc";
    String imagePNGPathname = "src/main/resources/static/testImage.png";
    String imageJPGPathname = "src/main/resources/static/testImage.jpg";
    String imageBMPPathname = "src/main/resources/static/testImage.bmp";
    String imageTIFPathname = "src/main/resources/static/testImage.tif";
    String pdfPathname = "src/main/resources/static/testPDF.pdf";
    String customDocumentName = "Custom Name";
    String customDocumentName2 = "Custom Name 2";
    String pngImageExtension = "png";
    String jpgImageExtension = "jpg";
    String bmpImageExtension = "bmp";
    String tifImageExtension = "tif";
    String pdfExtension = "pdf";

    @BeforeAll
    public static void beforeZoneTest() {
        System.err.println("Performing Document test");
    }

    @AfterAll
    public static void afterZoneTest() {
        System.err.println("Document test completed");
    }

    @Test
    public void emptyDocumentConstructor() {
        document = new Document();
        assertNotNull(document);
        assertNull(document.getActualDocumentName());
        assertNull(document.getDocumentName());
        assertNull(document.getFileContent());
        assertNull(document.getExtension());
    }

    @Test
    public void documentCustomNamePNGConstructor() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    imagePNGPathname.split("/")[imagePNGPathname.split("/").length - 1],
                    imagePNGPathname.split("/")[imagePNGPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(imagePNGPathname).toPath()));
            document = new Document(customDocumentName, mockMultipartFile);
        } catch (IOException e) {
            fail();
        }
        assertEquals(document.getDocumentName(), customDocumentName);
        assertEquals(document.getExtension(), pngImageExtension);
    }

    @Test
    public void documentPNGConstructor() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    imagePNGPathname.split("/")[imagePNGPathname.split("/").length - 1],
                    imagePNGPathname.split("/")[imagePNGPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(imagePNGPathname).toPath()));
            document = new Document(mockMultipartFile);
        } catch (IOException e) {
            fail();
        }
        assertEquals(document.getDocumentName(), imagePNGPathname.split("/")[imagePNGPathname.split("/").length - 1]);
        assertEquals(document.getActualDocumentName(),
                imagePNGPathname.split("/")[imagePNGPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), pngImageExtension);
    }

    @Test
    public void documentCustomNameJPGConstructor() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    imageJPGPathname.split("/")[imageJPGPathname.split("/").length - 1],
                    imageJPGPathname.split("/")[imageJPGPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(imageJPGPathname).toPath()));
            document = new Document(customDocumentName, mockMultipartFile);
        } catch (IOException e) {
            fail();
        }
        assertEquals(document.getDocumentName(), customDocumentName);
        assertEquals(document.getActualDocumentName(),
                imageJPGPathname.split("/")[imageJPGPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), jpgImageExtension);
    }

    @Test
    public void documentJPGConstructor() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    imageJPGPathname.split("/")[imageJPGPathname.split("/").length - 1],
                    imageJPGPathname.split("/")[imageJPGPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(imageJPGPathname).toPath()));
            document = new Document(mockMultipartFile);
        } catch (IOException e) {
            fail();
        }
        assertEquals(document.getDocumentName(), imageJPGPathname.split("/")[imageJPGPathname.split("/").length - 1]);
        assertEquals(document.getActualDocumentName(),
                imageJPGPathname.split("/")[imageJPGPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), jpgImageExtension);
    }

    @Test
    public void documentCustomNameBMPConstructor() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    imageBMPPathname.split("/")[imageBMPPathname.split("/").length - 1],
                    imageBMPPathname.split("/")[imageBMPPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(imageBMPPathname).toPath()));
            document = new Document(customDocumentName, mockMultipartFile);
        } catch (IOException e) {
            fail();
        }
        assertEquals(document.getDocumentName(), customDocumentName);
        assertEquals(document.getActualDocumentName(),
                imageBMPPathname.split("/")[imageBMPPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), bmpImageExtension);
    }

    @Test
    public void documentBMPConstructor() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    imageBMPPathname.split("/")[imageBMPPathname.split("/").length - 1],
                    imageBMPPathname.split("/")[imageBMPPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(imageBMPPathname).toPath()));
            document = new Document(mockMultipartFile);
        } catch (IOException e) {
            fail();
        }
        assertEquals(document.getDocumentName(), imageBMPPathname.split("/")[imageBMPPathname.split("/").length - 1]);
        assertEquals(document.getActualDocumentName(),
                imageBMPPathname.split("/")[imageBMPPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), bmpImageExtension);
    }

    @Test
    public void documentCustomNameTIFConstructor() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    imageTIFPathname.split("/")[imageTIFPathname.split("/").length - 1],
                    imageTIFPathname.split("/")[imageTIFPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(imageTIFPathname).toPath()));
            document = new Document(customDocumentName, mockMultipartFile);
        } catch (IOException e) {
            fail();
        }
        assertEquals(document.getDocumentName(), customDocumentName);
        assertEquals(document.getActualDocumentName(),
                imageTIFPathname.split("/")[imageTIFPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), tifImageExtension);
    }

    @Test
    public void documentTIFConstructor() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    imageTIFPathname.split("/")[imageTIFPathname.split("/").length - 1],
                    imageTIFPathname.split("/")[imageTIFPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(imageTIFPathname).toPath()));
            document = new Document(mockMultipartFile);
        } catch (IOException e) {
            fail();
        }
        assertEquals(document.getDocumentName(), imageTIFPathname.split("/")[imageTIFPathname.split("/").length - 1]);
        assertEquals(document.getActualDocumentName(),
                imageTIFPathname.split("/")[imageTIFPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), tifImageExtension);
    }

    @Test
    public void documentCustomNamePDFConstructor() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1],
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(pdfPathname).toPath()));
            document = new Document(customDocumentName, mockMultipartFile);
        } catch (IOException e) {
            fail();
        }
        assertEquals(document.getDocumentName(), customDocumentName);
        assertEquals(document.getActualDocumentName(), pdfPathname.split("/")[pdfPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), pdfExtension);
    }

    @Test
    public void documentFilePDFConstructor() {
        try {
            MockMultipartFile mockMultipartFile = new MockMultipartFile(
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1],
                    pdfPathname.split("/")[pdfPathname.split("/").length - 1], "multipart/form-data",
                    Files.readAllBytes(new File(pdfPathname).toPath()));
            document = new Document(mockMultipartFile);
        } catch (IOException e) {
            fail();
        }
        assertEquals(document.getActualDocumentName(), pdfPathname.split("/")[pdfPathname.split("/").length - 1]);
        assertEquals(document.getDocumentName(), pdfPathname.split("/")[pdfPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), pdfExtension);
    }
}
