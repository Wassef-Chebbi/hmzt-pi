package com.example.pi.service;


import com.example.pi.dto.RessourceDTO;
import com.example.pi.model.Ressource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RessourceService {

    Ressource save(Ressource ressource);

    Ressource findById(Long id);

    List<Ressource> findAll();

    Ressource update(RessourceDTO ressource);

    void deleteById(Long id);

    List<Ressource> getRessourcesByCategoryId(Long categoryId);
}
