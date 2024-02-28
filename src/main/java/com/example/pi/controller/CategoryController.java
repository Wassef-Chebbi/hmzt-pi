package com.example.pi.controller;


import com.example.pi.model.Category;
import com.example.pi.model.Ressource;
import com.example.pi.service.CategoryService;
import com.example.pi.service.RessourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {


    @Autowired
    private final CategoryService categoryService;

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PutMapping("/categories")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
