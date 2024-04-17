package com.example.pi.serviceImpl;


import com.example.pi.dto.RessourceDTO;
import com.example.pi.model.Ressource;
import com.example.pi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.pi.repository.RessourceRepository;
import com.example.pi.service.RessourceService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RessourceServiceImpl implements RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;
    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public Ressource save(Ressource newRessource) {
        Ressource ressource = Ressource.builder()
                .nom(newRessource.getNom())
                .description(newRessource.getDescription())
                .category(newRessource.getCategory())
                .fileURL(newRessource.getFileURL())
                .filePath(newRessource.getFilePath())
                .imageURL(newRessource.getImageURL())
                .imagePath(newRessource.getImagePath())

                .build();


        return ressourceRepository.save(ressource);
    }

    @Override
    public Ressource findById(Long id) {
        return ressourceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ressource> findAll() {
        return ressourceRepository.findAll();
    }

    @Override
    public Ressource update(RessourceDTO ressource) {
        Ressource existingRessource = ressourceRepository.findById(ressource.getRessourceId()).orElse(null);
        if (existingRessource != null) {
            existingRessource.setNom(ressource.getNom());
            existingRessource.setDescription(ressource.getDescription());
            existingRessource.setCategory(categoryRepository.findById(ressource.categoryId).get());
            existingRessource.setFilePath(ressource.getFilePath());
            existingRessource.setFileURL(ressource.getFileURL());
            existingRessource.setImagePath(ressource.getImagePath());
            existingRessource.setImageURL(ressource.getImageURL());
            return ressourceRepository.save(existingRessource);
        } else {
            throw new RuntimeException("Category with ID " + ressource.getRessourceId() + " not found!");
        }
    }

    @Override
    public void deleteById(Long id) {
        ressourceRepository.deleteById(id);
    }

    @Override
    public List<Ressource> getRessourcesByCategoryId(Long categoryId) {
        return ressourceRepository.findAllByCategoryId(categoryId);
    }
}
