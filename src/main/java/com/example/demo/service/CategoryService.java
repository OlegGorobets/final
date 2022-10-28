package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Page<Category> getAllCategory(int pageNum, String sortField, String sortDir) {
        int pageSize = 5;
        Sort sort = sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        return categoryRepository.findAll(pageable);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void removeCategoryById(String id) {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> getCategoryById(String id) {
        return categoryRepository.findById(id);
    }
}
