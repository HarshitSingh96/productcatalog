package dev.harshit.productcatalog.controllers;

import dev.harshit.productcatalog.dtos.GenericProductDto;
import dev.harshit.productcatalog.exceptions.NotFoundException;
import dev.harshit.productcatalog.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    ProductController productController;

    @MockBean
    ProductService productService;

    @Test
    void returnsNullWhenProductDoesntExistTest() throws NotFoundException {
        GenericProductDto productDto = productController.getProductById(110L);


    }
}
