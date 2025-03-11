package com.test.naren.base_app.service;

import com.test.naren.base_app.entity.Product;
import com.test.naren.base_app.exception.ProductNotFoundException;
import com.test.naren.base_app.repo.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
 
    @Autowired
    private ProductRepository repo;
     
    public List<Product> listAll() {
        return repo.findAll();
    }
     
    public void save(Product product) {
        repo.save(product);
    }

    public Product get(Integer id, String endpoint) {
        return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id, endpoint, id));
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}