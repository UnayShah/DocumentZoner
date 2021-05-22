package com.unayshah.documentzoner.controller;

import java.io.IOException;
import java.util.List;

import com.unayshah.documentzoner.dao.DocumentProperties;
import com.unayshah.documentzoner.service.DocumentPropertiesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DocumentPropertiesController {

    @Autowired
    DocumentPropertiesService documentPropertiesService;

    @GetMapping("/")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Document Zoner is here.", HttpStatus.ACCEPTED);
    }

    @PostMapping("/saveFile")
    public ResponseEntity<DocumentProperties> saveFile(@RequestPart(name = "file", required = true) MultipartFile file)
            throws IOException {
        return new ResponseEntity<>(documentPropertiesService.saveFile(file), HttpStatus.ACCEPTED);
    }

    @PostMapping("/saveFileCustomName")
    public ResponseEntity<DocumentProperties> saveFile(@RequestPart(name = "file", required = true) MultipartFile file,
            @RequestParam(name = "name", required = true) String name) throws IOException {
        return new ResponseEntity<>(documentPropertiesService.saveFile(name, file), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findFile")
    public ResponseEntity<DocumentProperties> findFile(@RequestParam(name = "id", required = true) String id) {
        DocumentProperties documentProperties = documentPropertiesService.findFile(id);
        if (documentProperties != null)
            return new ResponseEntity<>(documentProperties, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(new DocumentProperties(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findAllFiles")
    public ResponseEntity<List<DocumentProperties>> findAllFiles() {
        return new ResponseEntity<>(documentPropertiesService.findAllFiles(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateFile")
    public ResponseEntity<DocumentProperties> updateFile(
            @RequestParam(name = "DocumentProperties") DocumentProperties documentProperties) {
        try {
            return new ResponseEntity<>(documentPropertiesService.updateFile(documentProperties), HttpStatus.ACCEPTED);
        } catch (IOException e) {
            return new ResponseEntity<>(new DocumentProperties(), HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/deleteFile")
    public ResponseEntity<Boolean> deleteFile(@RequestParam(name = "id") String id) {
        return new ResponseEntity<>(documentPropertiesService.deleteFile(id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteAllFiles")
    public ResponseEntity<Boolean> deleteAllFiles() {
        return new ResponseEntity<>(documentPropertiesService.deleteAllFiles(), HttpStatus.ACCEPTED);
    }
}
