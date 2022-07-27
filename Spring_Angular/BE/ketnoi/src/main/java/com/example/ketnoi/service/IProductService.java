package com.example.ketnoi.service;

import com.example.ketnoi.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(int id);
    Product save(Product product);
    void remove(int id);
}
