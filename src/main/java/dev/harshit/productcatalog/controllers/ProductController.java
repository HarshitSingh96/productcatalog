package dev.harshit.productcatalog.controllers;

import dev.harshit.productcatalog.dtos.ExceptionDto;
import dev.harshit.productcatalog.dtos.GenericProductDto;
import dev.harshit.productcatalog.exceptions.NotFoundException;
import dev.harshit.productcatalog.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
        ResponseEntity<GenericProductDto> response = new ResponseEntity<>(
                HttpStatus.OK
        );
        return response;
    }

    @PostMapping("/")
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public GenericProductDto updateProductById(@RequestBody GenericProductDto productDto) {
        return productService.updateProductById(productDto);
    }
}
