package dev.harshit.productcatalog.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Setter
@Getter
@ToString
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue()
//    @GenericGenerator(name = "harshit", strategy = "uuid2")
    @Column(name = "id")
    private UUID uuid;
}
