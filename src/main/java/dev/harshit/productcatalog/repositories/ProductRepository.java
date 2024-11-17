package dev.harshit.productcatalog.repositories;

import dev.harshit.productcatalog.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // To learn how to make query using method names and @Query annotation
    // https://docs.spring.io/spring-data/jpa/reference/repositories/query-methods-details.html


//    Product findByTitleEquals (String title);
//
//
//    Product findByTitleEqualsAndPrice_Price(String title, double price);
//
//
//    List<Product> findAllByPrice_Currency(String currency);



    @Override
    Product save(Product product);

    @Override
    List<Product> findAll();

    @Override
    Product getById(Long uuid);

    @Override
    void deleteById(Long aLong);




}

