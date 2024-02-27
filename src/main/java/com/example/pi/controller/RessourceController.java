package com.example.pi.controller;


import lombok.RequiredArgsConstructor;
import com.example.pi.model.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pi.service.RessourceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/ressource")
public class RessourceController {

    @Autowired
    private final RessourceService ressourceService;

    @PostMapping("/ressources")
    public Ressource createRessource(@RequestBody Ressource ressource) {
        return ressourceService.save(ressource);
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
    public Ressource updateRessource(@RequestBody Ressource product) {
        return ressourceService.update(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteRessource(@PathVariable Long id) {
        ressourceService.deleteById(id);
    }


}
