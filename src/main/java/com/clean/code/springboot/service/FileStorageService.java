package com.clean.code.springboot.service;

import com.clean.code.springboot.domain.FileStorage;
import com.clean.code.springboot.domain.FileStorageStatus;
import com.clean.code.springboot.repository.FileStorageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.hashids.Hashids;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class FileStorageService {
    private final FileStorageRepository fileStorageRepository;

    @Value("${upload.folder}")
    private String uploadFolder;

    private final Hashids hashids;

    public FileStorageService(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
        this.hashids = new Hashids(getClass().getName(), 6);
    }

    public void save(MultipartFile multipartFile) {
        FileStorage fileStorage = new FileStorage();
        fileStorage.setName(multipartFile.getOriginalFilename());
        fileStorage.setExtension(getExtension(multipartFile.getOriginalFilename()));
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorage.setFileStorageStatus(FileStorageStatus.DRAFT);
        fileStorageRepository.save(fileStorage);

        Date now = new Date();
        // generating folder based on year month and date
        File uploadFolder = new File(String.format("%s/upload_files/%d%d%d/",
                this.uploadFolder,
                1900 + now.getYear(),
                1 + now.getMonth(),
                +now.getDate()));
        if (!uploadFolder.exists() && uploadFolder.mkdirs()) {
            System.out.println("Folder successfully created");
        }
        fileStorage.setHashId(hashids.encode(fileStorage.getId()));
        // generating uploadPath
        fileStorage.setUploadPath(String.format("upload_files/%d%d%d/%s.%s", // s => for lowercase S => for uppercase
                1900 + now.getYear(),
                1 + now.getMonth(),
                now.getDate(),
                fileStorage.getHashId(),
                fileStorage.getExtension()));
        fileStorageRepository.save(fileStorage);

        // save file to folder
        uploadFolder = uploadFolder.getAbsoluteFile();
        File file = new File(uploadFolder, String.format("%s.%s", fileStorage.getHashId(), fileStorage.getExtension()));
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
@Transactional(readOnly = true) // faqat oqib berdigan qilish uchun
public FileStorage  findByHashId(String hashId) {
        return  fileStorageRepository.findByHashId(hashId);
}


public void delete(String hashId) {
        FileStorage fileStorage =  findByHashId(hashId);
        File file = new File(String.format("%s/%s", this.uploadFolder, fileStorage.getUploadPath()));
        if (file.delete()) {
            fileStorageRepository.delete(fileStorage);
        }

}

@Scheduled(cron = "30 16 22 * * *")
public void deleteAllDraft() {
    List<FileStorage> fileStorageList = fileStorageRepository.findAllByFileStorageStatus(FileStorageStatus.DRAFT);
    for (FileStorage fileStorage: fileStorageList) {
        delete(fileStorage.getHashId());
    }
// or by this method
//    fileStorageList.forEach(fileStorage -> {
//        delete(fileStorage.getHashId());
//    });
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
