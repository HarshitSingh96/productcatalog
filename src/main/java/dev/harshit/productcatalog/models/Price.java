package dev.harshit.productcatalog.models;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Price extends BaseModel {
    private String currency;
    private double price;
}
