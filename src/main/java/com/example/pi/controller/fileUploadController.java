package com.example.pi.controller;


import com.example.pi.dto.FileDTO;
import com.example.pi.exception.AzureBlobStorageException;
import com.example.pi.service.AzureBlobStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/file")
public class fileUploadController {
    @Autowired
    private final AzureBlobStorageService azureBlobStorageService ;

    @PostMapping(value ="/upload")
    public String addFile(
            @RequestParam(name = "path") String path,
            @RequestParam(name = "name") String name,
            @RequestPart(name = "file") MultipartFile file) throws AzureBlobStorageException, IOException {


        FileDTO fb =  FileDTO.builder()
                .blob(file)
                .name(name)
                .path(path)
                .build();

         return azureBlobStorageService.write(fb);
    }

    @PostMapping(value ="/update")
    public String updateFile(
            @RequestParam(name = "path") String path,
            @RequestPart(name = "file") MultipartFile file) throws AzureBlobStorageException, IOException {


        FileDTO fb =  FileDTO.builder()
                .blob(file)
                .path(path)
                .build();

        return azureBlobStorageService.update(fb);
    }

    @DeleteMapping(value ="/delete")
    public void deleteFile(
            @RequestParam(name = "path") String path,
            //@RequestParam(name = "name") String name,
            @RequestPart(name = "file") MultipartFile file) throws AzureBlobStorageException, IOException {


        FileDTO fb =  FileDTO.builder()
                .blob(file)
                //.name(name)
                .path(path)
                .build();

        azureBlobStorageService.delete(fb);
    }
}
