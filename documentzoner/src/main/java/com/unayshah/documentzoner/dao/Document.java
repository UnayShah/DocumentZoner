package com.unayshah.documentzoner.dao;

import java.io.File;
import java.io.FileNotFoundException;

public class Document {
    private File document;
    private String extension;

    public Document(File document) throws FileNotFoundException {
        if (!document.exists() || !document.isFile())
            throw new FileNotFoundException();
        this.document = document;
        setExtension();
    }

    public Document(String pathname) throws FileNotFoundException {
        this(new File(pathname));
    }

    @Override
    public String toString() {
        return "Document [document=" + document.toString() + ", extension=" + extension + "]";
    }

    public File getDocument() {
        return document;
    }

    public void setDocument(File document) {
        this.document = document;
        setExtension();
    }

    public String getExtension() {
        return extension;
    }

    private void setExtension() {
        this.extension = document.getName().split("\\.")[document.getName().split("\\.").length - 1];
    }

}
