package dev.harshit.productcatalog.services;

import dev.harshit.productcatalog.dtos.GenericProductDto;
import dev.harshit.productcatalog.exceptions.NotFoundException;
import dev.harshit.productcatalog.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {
    public List<GenericProductDto> getAllProducts();

    public GenericProductDto getProductById(Long id) throws NotFoundException;

    public void deleteProductById(Long id);

    public GenericProductDto createProduct(GenericProductDto productDto);
    public GenericProductDto updateProductById(GenericProductDto productDto);

}
