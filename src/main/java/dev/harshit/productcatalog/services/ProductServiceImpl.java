package dev.harshit.productcatalog.services;

import dev.harshit.productcatalog.dtos.GenericProductDto;
import dev.harshit.productcatalog.exceptions.NotFoundException;
import dev.harshit.productcatalog.models.Price;
import dev.harshit.productcatalog.models.Product;
import dev.harshit.productcatalog.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(Product product : products) {
            genericProductDtos.add(convertProductToProductDto(product));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        Product product = productRepository.getById(id);
        return convertProductToProductDto(product);
    }

    @Override
    public void deleteProductById(Long id) {
         productRepository.deleteById(id);
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        productRepository.save(product);
        return productDto;
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto productDto) {
        Product product = convertGenericProductDtoToProduct(productDto);
        return convertProductToProductDto(productRepository.save(product));
    }

    private Product convertGenericProductDtoToProduct(GenericProductDto productDto) {
        Price price = new Price();
        price.setPrice(productDto.getPrice());
        return Product.builder()
                .title(productDto.getTitle())
                .image(productDto.getImage())
                .description(productDto.getDescription())
                .price(price)
                .build();
    }

    GenericProductDto convertProductToProductDto(Product product) {
        return GenericProductDto.builder()
                .title(product.getTitle())
                .description(product.getDescription())
                .image(product.getImage())
//                .price(product.getPrice().getPrice())
                .category(product.getCategory().getName())
                .build();
    }
}
