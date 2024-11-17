package dev.harshit.productcatalog.thirdpartyclients.productservice;

import dev.harshit.productcatalog.dtos.GenericProductDto;
import dev.harshit.productcatalog.exceptions.NotFoundException;

import java.util.List;

public interface ThirdPartyProductServiceClient {

    public List<GenericProductDto> getAllProducts();

    public GenericProductDto getProductById(Long id) throws NotFoundException;

    public GenericProductDto deleteProductById(Long id);

    public GenericProductDto createProduct(GenericProductDto productDto);
    public GenericProductDto updateProductById(GenericProductDto productDto);

}
