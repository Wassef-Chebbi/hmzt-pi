package com.example.pi.serviceImpl;


import com.example.pi.model.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.pi.repository.RessourceRepository;
import com.example.pi.service.RessourceService;

import java.util.List;

@Component
public class RessourceServiceImpl implements RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;



    @Override
    public Ressource save(Ressource ressource) {
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
        // Check if product exists before updating
        Ressource existingRessource = ressourceRepository.findById(ressource.getRessourceId()).orElse(null);
        if (existingRessource != null) {
            // Update relevant fields and save
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
