package dev.harshit.productcatalog.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CategoryResponse {
    private String name;

    private List<ProductResponse> products;
}
