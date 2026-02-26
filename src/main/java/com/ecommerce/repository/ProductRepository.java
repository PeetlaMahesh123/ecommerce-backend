package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find product by name
    Optional<Product> findByName(String name);

    // Find products by price less than given value
    List<Product> findByPriceLessThan(double price);

    // Find products by quantity greater than given value
    List<Product> findByQuantityGreaterThan(int quantity);

}