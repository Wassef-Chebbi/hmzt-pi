package com.example.pi.service;


import com.example.pi.model.Category;
import com.example.pi.model.Ressource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    Category save(Category category);

    Category findById(Long id);

    List<Category> findAll();

    Category update(Category category);

    void delete(Long id);

    Ressource addResourceToCategory(Long categoryId, Ressource resource);



}
