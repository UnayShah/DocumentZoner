package com.unayshah.documentzoner.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;

public class DocumentProperties {
    @Id
    private UUID id;
    private Document document;
    private List<Zone> zones;

    public DocumentProperties(String pathname) throws FileNotFoundException {
        this(pathname, new ArrayList<>());
    }

    public DocumentProperties(File document) throws FileNotFoundException {
        this(document, new ArrayList<>());
    }

    public DocumentProperties(Document document) throws FileNotFoundException {
        this(document, new ArrayList<>());
    }
    
    public DocumentProperties(String pathname, List<Zone> zones) throws FileNotFoundException {
        this(new Document(pathname), zones);
    }

    public DocumentProperties(File document, List<Zone> zones) throws FileNotFoundException {
        this(new Document(document), zones);
    }

    public DocumentProperties(Document document, List<Zone> zones) {
        this.id = UUID.randomUUID();;
        this.document = document;
        this.zones = zones;
    }

    public UUID getId(){
        return id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(File document) throws FileNotFoundException {
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
}
