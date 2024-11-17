package dev.harshit.productcatalog.services;

import dev.harshit.productcatalog.dtos.CategoryResponse;
import dev.harshit.productcatalog.dtos.ProductResponse;
import dev.harshit.productcatalog.models.Category;
import dev.harshit.productcatalog.models.Product;
import dev.harshit.productcatalog.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public CategoryResponse getCategoryById(@PathVariable String uuid) {
        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));
        if(categoryOptional.isEmpty()) return null;
        Category category = categoryOptional.get();

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setName(category.getName());

        List<ProductResponse> productResponses = new ArrayList<>();
        for(Product product : category.getProducts()) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setTitle(product.getTitle());
            productResponse.setDescription(product.getDescription());
            productResponse.setImage(product.getImage());
            productResponse.setPrice(product.getPrice());
            productResponses.add(productResponse);
        }
        categoryResponse.setProducts(productResponses);
        return categoryResponse;
    }
}
