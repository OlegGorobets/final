package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    private static final String UPLOADDIR = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/admin/categories/{pageNum}")
    public String categories(Model model,
                             @PathVariable(name = "pageNum") int pageNum,
                             @Param("sortField") String sortField,
                             @Param("sortDir") String sortDir) {
        Page<Category> page = categoryService.getAllCategory(pageNum, sortField, sortDir);
        model.addAttribute("categories", categoryService.getAllCategory(pageNum, sortField, sortDir));
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        return "categories";
    }

    @RequestMapping("/admin/categories")
    public String categoriesHomePage(Model model) {
        return categories(model, 1, "name", "asc");
    }

    @GetMapping("/admin/categories/add")
    public String getCategoryAdd(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCategoryAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        LOGGER.info("Category added.");
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable String id) {
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable String id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        } else {
            return "404"; //
        }
    }

    @RequestMapping("/admin/products/{pageNum}")
    public String getProductsAdd(Model model,
                                 @PathVariable(name = "pageNum") int pageNum,
                                 @Param("sortField") String sortField,
                                 @Param("sortDir") String sortDir) {
        Page<Product> page = productService.getAllProduct(pageNum, sortField, sortDir);
        List<Product> listProducts = page.getContent();
        model.addAttribute("products", listProducts);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        return "products";
    }

    @RequestMapping("/admin/products")
    public String getProductsAddHomePage(Model model) {
        return getProductsAdd(model, 1, "name", "asc");
    }

    @GetMapping("/admin/products/add")
    public String getProduct(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String postProduct(@ModelAttribute("productDTO") ProductDTO productDTO,
                              @RequestParam("productImage") MultipartFile multipartFile,
                              @RequestParam("imgName") String imgName) throws IOException {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        String imageUUID;
        if (!multipartFile.isEmpty()) {
            imageUUID = multipartFile.getOriginalFilename();
            Path path = Paths.get(UPLOADDIR, imageUUID);
            Files.write(path, multipartFile.getBytes());
        } else {
            imageUUID = imgName;
        }
        product.setImage(imageUUID);
        productService.addProduct(product);
        LOGGER.info("Product added.");
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProduct(@PathVariable String id, Model model) {
        Product product = productService.getProductById(id).get();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setImage(product.getImage());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("productDTO", productDTO);
        return "productsAdd";
    }
}

