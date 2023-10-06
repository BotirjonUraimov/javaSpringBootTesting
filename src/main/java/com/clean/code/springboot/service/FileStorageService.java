package com.clean.code.springboot.service;

import com.clean.code.springboot.domain.FileStorage;
import com.clean.code.springboot.domain.FileStorageStatus;
import com.clean.code.springboot.repository.FileStorageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
    private final FileStorageRepository fileStorageRepository;

    public FileStorageService(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }

    public void save(MultipartFile multipartFile) {
        FileStorage fileStorage = new FileStorage();
        fileStorage.setName(multipartFile.getOriginalFilename());
        fileStorage.setExtension(getExtension(multipartFile.getOriginalFilename()));
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorage.setFileStorageStatus(FileStorageStatus.DRAFT);
        fileStorageRepository.save(fileStorage);


    }



    private String getExtension(String filename) {
        String extension = null;
        if(filename != null && !filename.isEmpty()) {
            int dot = filename.lastIndexOf('.');
            if (dot > 0 && dot <= filename.length() -2) {
                extension = filename.substring(dot + 1);
            }
        }
        return extension;
    }


}
