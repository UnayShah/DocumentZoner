package com.unayshah.documentzoner.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

@org.springframework.data.mongodb.core.mapping.Document(collection = "User")
public class User {

    @Id
    private String username;
    private String password;
    private List<DocumentProperties> listDocumentProperties;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        listDocumentProperties = new ArrayList<>();
    }

    public void addDocumentProperties(DocumentProperties documentProperties) {
        listDocumentProperties.add(documentProperties);
    }

    public boolean deleteDocumentProperties(DocumentProperties documentProperties) {
        return listDocumentProperties.remove(documentProperties);
    }

    public List<DocumentProperties> getListDocumentProperties() {
        return this.listDocumentProperties;
    }
}
