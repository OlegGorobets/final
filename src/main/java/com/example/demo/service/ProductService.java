package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Page<Product> getAllProduct(int pageNum, String sortField, String sortDir) {
        int pageSize = 2;
        Sort sort = sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        return productRepository.findAll(pageable);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void removeProduct(String id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProductsByCategoryId(String id) {
        return productRepository.findAllByCategoryId(id);
    }

    public void removeProductById(String id) {
        productRepository.deleteById(id);
    }
}
