package com.unayshah.documentzoner.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    public void documentPathnameImagePNGConstructor() {
        try {
            document = new Document(imagePNGPathname);
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(document.getDocument().getName(),
                imagePNGPathname.split("/")[imagePNGPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), pngImageExtension);
    }

    @Test
    public void documentFileImagePNGConstructor() {
        File file = new File(imagePNGPathname);
        try {
            document = new Document(file);
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(document.getDocument(), file);
        assertEquals(document.getExtension(), pngImageExtension);
    }

    @Test
    public void documentPathnameImageJPGConstructor() {
        try {
            document = new Document(imageJPGPathname);
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(document.getDocument().getName(),
                imageJPGPathname.split("/")[imageJPGPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), jpgImageExtension);
    }

    @Test
    public void documentFileImageJPGConstructor() {
        File file = new File(imageJPGPathname);
        try {
            document = new Document(file);
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(document.getDocument(), file);
        assertEquals(document.getExtension(), jpgImageExtension);
    }

    @Test
    public void documentPathnameImageBMPConstructor() {
        try {
            document = new Document(imageBMPPathname);
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(document.getDocument().getName(),
                imageBMPPathname.split("/")[imageBMPPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), bmpImageExtension);
    }

    @Test
    public void documentFileImageBMPConstructor() {
        File file = new File(imageBMPPathname);
        try {
            document = new Document(file);
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(document.getDocument(), file);
        assertEquals(document.getExtension(), bmpImageExtension);
    }

    @Test
    public void documentPathnameImageTIFConstructor() {
        try {
            document = new Document(imageTIFPathname);
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(document.getDocument().getName(),
                imageTIFPathname.split("/")[imageTIFPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), tifImageExtension);
    }

    @Test
    public void documentFileImageTIFConstructor() {
        File file = new File(imageTIFPathname);
        try {
            document = new Document(file);
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(document.getDocument(), file);
        assertEquals(document.getExtension(), tifImageExtension);
    }

    @Test
    public void documentPathnamePDFConstructor() {
        try {
            document = new Document(pdfPathname);
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(document.getDocument().getName(), pdfPathname.split("/")[pdfPathname.split("/").length - 1]);
        assertEquals(document.getExtension(), pdfExtension);
    }

    @Test
    public void documentFilePDFConstructor() {
        File file = new File(pdfPathname);
        try {
            document = new Document(file);
        } catch (FileNotFoundException e) {
            fail();
        }
        assertEquals(document.getDocument(), file);
        assertEquals(document.getExtension(), pdfExtension);
    }

    @Test
    public void folderFoundTest() {
        assertThrows(FileNotFoundException.class, () -> {
            document = new Document(folderPathname);
        });
    }

    @Test
    public void fileNotFoundTest() {
        assertThrows(FileNotFoundException.class, () -> {
            document = new Document(incorrectFilePathname);
        });
    }
}
