package com.example.ketnoi.service;

import com.example.ketnoi.model.Product;
import com.example.ketnoi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServie implements IProductService{

        @Autowired
        private ProductRepository productRepository;

        @Override
        public List<Product> findAll() {
            return productRepository.findAll();
        }

        @Override
        public Optional<Product> findById(int id) {
            return productRepository.findById(id);
        }

        @Override
        public Product save(Product product) {
            return   productRepository.save(product);
        }

        @Override
        public void remove(int id) {
            productRepository.deleteById(id);
        }
    }
