package com.example.pi.controller;


import com.example.pi.dto.newRessource;
import com.example.pi.exception.AzureBlobStorageException;
import com.example.pi.repository.CategoryRepository;
import com.example.pi.service.AzureBlobStorageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import lombok.RequiredArgsConstructor;
import com.example.pi.model.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.pi.service.RessourceService;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/ressource")
public class RessourceController {

    @Autowired
    private final RessourceService ressourceService;
    @Autowired
    private final AzureBlobStorageService azureBlobStorageService;
    @Autowired
    private CategoryRepository categoryRepository;


    @PostMapping(value ="/ressources")
    public Ressource createRessource(
                                     @RequestParam String nom,
                                     @RequestParam String description,
                                     @RequestParam(required = false) List<Long> categoriesIds, // Assuming a list of category IDs
                                     @RequestParam String path,
                                     @RequestParam String fileName,
                                     @RequestPart MultipartFile file) throws AzureBlobStorageException, IOException {







        InputStream inputStream = file.getInputStream();
        Ressource res = Ressource.builder()
                .nom(nom)
                .description(description)
                .fileName(fileName)
                .path(path)
                .categories(categoryRepository.findAllById(categoriesIds.stream().toList()).stream().collect(Collectors.toSet()))
                .inputStream(inputStream)
                .build();


        azureBlobStorageService.write(res);
        return ressourceService.save(res);
    }

    @GetMapping("/ressources/{id}")
    public Ressource getRessourceById(@PathVariable Long id) {
        return ressourceService.findById(id);
    }

    @GetMapping("/ressources")
    public List<Ressource> getAllRessources() {
        return ressourceService.findAll();
    }

    @PutMapping("/ressources")
    public Ressource updateRessource(@RequestBody newRessource product) {
        return ressourceService.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRessource(@PathVariable Long id) {
        ressourceService.deleteById(id);
    }


}
