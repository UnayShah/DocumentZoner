package com.unayshah.documentzoner.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.unayshah.documentzoner.dao.DocumentProperties;
import com.unayshah.documentzoner.repository.DocumentPropertiesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentPropertiesService {

    @Autowired
    DocumentPropertiesRepository documentPropertiesRepository;

    public DocumentProperties saveFile(MultipartFile file) throws IOException {
        return saveFile(file.getOriginalFilename(), file);
    }

    public DocumentProperties saveFile(String name, MultipartFile file) throws IOException {
        return saveFile(new DocumentProperties(name, file));
    }

    public DocumentProperties saveFile(DocumentProperties documentProperties) throws IOException {
        return documentPropertiesRepository.save(documentProperties);
    }

    public DocumentProperties findFile(String id) {
        Optional<DocumentProperties> result = documentPropertiesRepository.findById(id);
        if (result.isPresent())
            return result.get();
        return null;
    }

    public DocumentProperties updateFile(DocumentProperties documentProperties) throws IOException {
        return saveFile(documentProperties);
    }

    public boolean deleteFile(String id) {
        if (findFile(id) != null) {
            documentPropertiesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<DocumentProperties> findAllFiles() {
        return documentPropertiesRepository.findAll();
    }

    public boolean deleteAllFiles() {
        documentPropertiesRepository.deleteAll();
        return true;
    }
}
