package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {
    List<Product> findAllByCategoryId(String id);
}
