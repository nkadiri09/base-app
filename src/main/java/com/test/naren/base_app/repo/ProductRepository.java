package com.test.naren.base_app.repo;

import com.test.naren.base_app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
 
}