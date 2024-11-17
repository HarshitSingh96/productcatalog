package dev.harshit.productcatalog.dtos;

import dev.harshit.productcatalog.models.Category;
import dev.harshit.productcatalog.models.Price;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductResponse {

    private String title;
    private String description;
    private String image;
    private Price price;
}
