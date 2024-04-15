package com.example.pi.controller;


import com.example.pi.dto.RessourceDTO;
import com.example.pi.exception.AzureBlobStorageException;
import com.example.pi.repository.CategoryRepository;
import com.example.pi.service.AzureBlobStorageService;
import lombok.RequiredArgsConstructor;
import com.example.pi.model.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pi.service.RessourceService;

import java.io.IOException;
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

            @RequestBody RessourceDTO RessourceDTO
                                     ) throws AzureBlobStorageException, IOException {

        Ressource res = Ressource.builder()
                .nom(RessourceDTO.getNom())
                .description(RessourceDTO.getDescription())
                .categories(categoryRepository.findAllById(RessourceDTO.getCategoriesIds()).stream().collect(Collectors.toSet()))
                .fileURL(RessourceDTO.getURL())
                .build();

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
    public Ressource updateRessource(@RequestBody RessourceDTO product) {
        return ressourceService.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRessource(@PathVariable Long id) {
        ressourceService.deleteById(id);
    }


}
