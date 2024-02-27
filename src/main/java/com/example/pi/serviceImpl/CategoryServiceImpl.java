package com.example.pi.serviceImpl;


import com.example.pi.model.Category;
import com.example.pi.model.Ressource;
import com.example.pi.repository.CategoryRepository;
import com.example.pi.repository.RessourceRepository;
import com.example.pi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Category category) {
        Category existingCategory = categoryRepository.findById(category.getCategoryId()).orElse(null);
        if (existingCategory != null) {
            // Update relevant fields and save
            existingCategory.setNom(category.getNom());
            existingCategory.setDescription(category.getDescription());
            return categoryRepository.save(existingCategory);
        } else {
            throw new RuntimeException("Category with ID " + category.getCategoryId() + " not found!");
        }
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);

    }
}
