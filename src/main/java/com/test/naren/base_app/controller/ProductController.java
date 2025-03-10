package com.test.naren.base_app.controller;

import com.test.naren.base_app.entity.Product;
import com.test.naren.base_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> list() {
        return service.listAll();
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        service.save(product);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        product.setId(id);
        service.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        service.delete(id);
    }


}
