package dev.harshit.productcatalog.thirdpartyclients.productservice;

import dev.harshit.productcatalog.dtos.FakeStoreProductDto;
import dev.harshit.productcatalog.dtos.GenericProductDto;
import dev.harshit.productcatalog.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class FakeStoreProductServiceClient implements ThirdPartyProductServiceClient {
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreDomain;
    private String productUrl = "";

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String fakeStoreDomain) {
        this.restTemplateBuilder = restTemplateBuilder;
        productUrl = fakeStoreDomain + "products/";
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> genericProductDtoList = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : Arrays.stream(response.getBody()).toList()) {
            genericProductDtoList.add(mapFakeStoreObjectToGeneric(fakeStoreProductDto));
        }
        return genericProductDtoList;
    }

    public GenericProductDto mapFakeStoreObjectToGeneric(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());

        return genericProductDto;
    }


    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(productUrl + "{id}", FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if (fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id: " + id + " does not exist");
        }
        return mapFakeStoreObjectToGeneric(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(productUrl + "{id}", HttpMethod.DELETE, null, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return mapFakeStoreObjectToGeneric(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(productUrl, productDto, GenericProductDto.class);
        return response.getBody();
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(productUrl, productDto, GenericProductDto.class);
        return response.getBody();
    }
}
