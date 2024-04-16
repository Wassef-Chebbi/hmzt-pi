package com.example.pi.service;


import com.example.pi.dto.CategoryDTO;
import com.example.pi.model.Category;
import com.example.pi.model.Ressource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    Category save(Category category);

    Category findById(Long id);

    List<Category> findAll();

    Category update(CategoryDTO category);

    void delete(Long id);

    Ressource addResourceToCategory(Long categoryId, Ressource resource);



}
