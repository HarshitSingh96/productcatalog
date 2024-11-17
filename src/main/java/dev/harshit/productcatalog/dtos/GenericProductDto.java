package dev.harshit.productcatalog.dtos;

import dev.harshit.productcatalog.models.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericProductDto {
    private long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
