package com.example.pi.controller;


import com.example.pi.dto.addRessource;
import lombok.RequiredArgsConstructor;
import com.example.pi.model.Ressource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pi.service.RessourceService;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/ressource")
public class RessourceController {

    @Autowired
    private final RessourceService ressourceService;


    @PostMapping("/ressources")
    public Ressource createRessource(@RequestBody addRessource newRessource) {
        return ressourceService.save(newRessource);
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
    public Ressource updateRessource(@RequestBody addRessource product) {
        return ressourceService.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRessource(@PathVariable Long id) {
        ressourceService.deleteById(id);
    }


}
