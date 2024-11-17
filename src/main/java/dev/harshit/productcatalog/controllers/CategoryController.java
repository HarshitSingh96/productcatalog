package dev.harshit.productcatalog.controllers;

import dev.harshit.productcatalog.dtos.CategoryResponse;
import dev.harshit.productcatalog.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/categories")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{uuid}")
    public CategoryResponse getCategoryById(@PathVariable("uuid") String uuid) {
        return categoryService.getCategoryById(uuid);
    }
}
