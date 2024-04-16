package com.example.pi.controller;


import com.example.pi.dto.CategoryDTO;
import com.example.pi.model.Category;
import com.example.pi.model.Ressource;
import com.example.pi.service.CategoryService;
import com.example.pi.service.RessourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {


    @Autowired
    private final CategoryService categoryService;

    @PostMapping("/add")
    public Category createCategory(@RequestBody CategoryDTO newCategory) {

        Category category = Category.builder()
                .nom(newCategory.getNom())
                .description(newCategory.getDescription())
                .imagePath(newCategory.getImagePath())
                .imageURL(newCategory.getImageURL())
                .build();


        return categoryService.save(category);
    }

    @GetMapping("/getById/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PutMapping("/update")
    public Category updateCategory(@RequestBody CategoryDTO category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
