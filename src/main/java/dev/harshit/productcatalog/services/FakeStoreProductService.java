package dev.harshit.productcatalog.services;

import dev.harshit.productcatalog.dtos.FakeStoreProductDto;
import dev.harshit.productcatalog.dtos.GenericProductDto;
import dev.harshit.productcatalog.exceptions.NotFoundException;
import dev.harshit.productcatalog.models.Product;
import dev.harshit.productcatalog.thirdpartyclients.productservice.ThirdPartyProductServiceClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    ThirdPartyProductServiceClient thirdPartyProductServiceClient;
    public FakeStoreProductService(ThirdPartyProductServiceClient thirdPartyProductServiceClient) {
        this.thirdPartyProductServiceClient = thirdPartyProductServiceClient;
    }
    @Override
    public List<GenericProductDto> getAllProducts() {
        return thirdPartyProductServiceClient.getAllProducts();
    }
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return thirdPartyProductServiceClient.getProductById(id);
    }

    @Override
    public void deleteProductById(Long id) {
        thirdPartyProductServiceClient.deleteProductById(id);
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto productDto) {
        return thirdPartyProductServiceClient.createProduct(productDto);
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto productDto) {
        return thirdPartyProductServiceClient.updateProductById(productDto);
    }
}
