package com.example.pi.controller;


import com.example.pi.dto.FileDTO;
import com.example.pi.dto.Resp;
import com.example.pi.exception.AzureBlobStorageException;
import com.example.pi.service.AzureBlobStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Resp> addFile(
            @RequestParam(name = "path") String path,
            @RequestParam(name = "name") String name,
            @RequestPart(name = "file") MultipartFile file) throws AzureBlobStorageException, IOException {


        FileDTO fb =  FileDTO.builder()
                .blob(file)
                .name(name)
                .path(path)
                .build();

         var st =  azureBlobStorageService.write(fb);
         return new ResponseEntity<>(st, HttpStatus.OK);
    }

    @PostMapping(value ="/update")
    public ResponseEntity<Resp> updateFile(
            @RequestParam(name = "path") String path,
            @RequestPart(name = "file") MultipartFile file) throws AzureBlobStorageException, IOException {


        FileDTO fb =  FileDTO.builder()
                .blob(file)
                .path(path)
                .build();

        var st = azureBlobStorageService.update(fb);
        return new ResponseEntity<>(st, HttpStatus.OK);
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
