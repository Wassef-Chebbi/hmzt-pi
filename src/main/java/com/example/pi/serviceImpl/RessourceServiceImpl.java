package com.example.pi.serviceImpl;


import com.example.pi.dto.addRessource;
import com.example.pi.model.Ressource;
import com.example.pi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.pi.repository.RessourceRepository;
import com.example.pi.service.RessourceService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RessourceServiceImpl implements RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;
    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public Ressource save(addRessource newRessource) {
        Ressource ressource = Ressource.builder()
                .nom(newRessource.getNom())
                .description(newRessource.getDescription())
                .categories(categoryRepository.findAllById(newRessource.categoriesIds)
                        .stream().collect(Collectors.toSet()))
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
    public Ressource update(Ressource ressource) {
        Ressource existingRessource = ressourceRepository.findById(ressource.getRessourceId()).orElse(null);
        if (existingRessource != null) {
            existingRessource.setNom(ressource.getNom());
            existingRessource.setDescription(ressource.getDescription());
            return ressourceRepository.save(existingRessource);
        } else {
            throw new RuntimeException("Category with ID " + ressource.getRessourceId() + " not found!");
        }
    }

    @Override
    public void deleteById(Long id) {
        ressourceRepository.deleteById(id);
    }
}
