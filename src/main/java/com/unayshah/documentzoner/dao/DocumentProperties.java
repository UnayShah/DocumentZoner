package com.unayshah.documentzoner.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

@org.springframework.data.mongodb.core.mapping.Document(collection = "DocumentProperties")
public class DocumentProperties {
    @Id
    private String id;
    private Document document;
    private List<Zone> zones;

    public DocumentProperties(MultipartFile document) throws IOException {
        this(document, new ArrayList<>());
    }

    public DocumentProperties(String documentName, MultipartFile document) throws IOException {
        this(documentName, document, new ArrayList<>());
    }

    public DocumentProperties(Document document) throws IOException {
        this(document, new ArrayList<>());
    }

    public DocumentProperties(MultipartFile document, List<Zone> zones) throws IOException {
        this(new Document(document), zones);
    }

    public DocumentProperties(String documentName, MultipartFile document, List<Zone> zones) throws IOException {
        this(new Document(documentName, document), zones);
    }

    public DocumentProperties(Document document, List<Zone> zones) {
        this.id = UUID.randomUUID().toString();
        this.document = document;
        this.zones = zones;
    }

    public DocumentProperties(){
        this.id = "";
        this.document = new Document();
        this.zones = new ArrayList<>();
    }

    public String getId(){
        return id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(MultipartFile document) throws IOException {
        this.document = new Document(document);
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public void addZone(Zone zone) {
        zones.add(zone);
    }

    public void removeZone(int index) {
        zones.remove(index);
    }

    public void removeZone(Zone zone) {
        zones.remove(zone);
    }

    @Override
    public String toString() {
        return "DocumentProperties [document=" + document + ", id=" + id + ", zones=" + zones + "]";
    }

}
