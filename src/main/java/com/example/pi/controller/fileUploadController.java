package com.example.pi.controller;


import com.example.pi.dto.FileDTO;
import com.example.pi.dto.newRessource;
import com.example.pi.exception.AzureBlobStorageException;
import com.example.pi.model.Ressource;
import com.example.pi.service.AzureBlobStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class fileUploadController {
    @Autowired
    private final AzureBlobStorageService azureBlobStorageService ;

    @PostMapping(value ="/upload")
    public String createRessource(
            @RequestParam(name = "path") String path,
            @RequestPart(name = "file") MultipartFile file) throws AzureBlobStorageException, IOException {


        FileDTO fb =  FileDTO.builder()
                .blob(file)
                .path(path)
                .build();

         return azureBlobStorageService.write(fb);
    }
}
