package com.example.pi.service;


import com.example.pi.dto.addRessource;
import com.example.pi.model.Ressource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface RessourceService {

    Ressource save(addRessource ressource);

    Ressource findById(Long id);

    List<Ressource> findAll();

    Ressource update(addRessource ressource);

    void deleteById(Long id);
}
