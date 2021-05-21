package com.unayshah.documentzoner.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Document {

    private String documentName;
    private String actualDocumentName;
    private String extension;
    private byte[] fileContent;

    public Document(String documentName, MultipartFile document) throws IOException {
        if (document == null || document.getSize() == 0)
            throw new FileNotFoundException("File does not exist");

        setActualDocumentName(document.getOriginalFilename());
        this.documentName = documentName;
        setFileContent(document);
        setExtension(document.getName());
    }

    public Document(MultipartFile document) throws IOException {
        this(document.getOriginalFilename(), document);
    }

    public Document() {
        this.documentName = null;
        this.actualDocumentName = null;
        this.fileContent = null;
        this.extension = null;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getActualDocumentName() {
        return actualDocumentName;
    }

    private void setActualDocumentName(String actualDocumentName) {
        this.actualDocumentName = actualDocumentName;
    }

    public void setDocument(MultipartFile document) throws IOException {
        setFileContent(document);
        setExtension(document.getOriginalFilename());
    }

    public String getExtension() {
        return extension;
    }

    private void setExtension(String filename) {
        this.extension = filename.split("\\.")[filename.split("\\.").length - 1];
    }

    public byte[] getFileContent() {
        return this.fileContent;
    }

    private void setFileContent(MultipartFile document) throws IOException {
        this.fileContent = document.getBytes();
    }

    @Override
    public String toString() {
        return "Document [actualDocumentName=" + actualDocumentName + ", documentName=" + documentName + ", extension="
                + extension + ", fileContentLength=" + fileContent.length + "]";
    }

}
