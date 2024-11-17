package dev.harshit.productcatalog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;

    @OneToMany
    private List<Product> products;
}
