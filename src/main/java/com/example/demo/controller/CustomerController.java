package com.example.demo.controller;

import com.example.demo.global.GlobalData;
import com.example.demo.model.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "about";
    }

    @RequestMapping("/shop/{pageNum}")
    public String shop(Model model,
                       @PathVariable(name = "pageNum") int pageNum,
                       @Param("sortField") String sortField,
                       @Param("sortDir") String sortDir) {
        Page<Product> page = productService.getAllProduct(pageNum, sortField, sortDir);
        List<Product> listProducts = page.getContent();
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("products", listProducts);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        return "shop";
    }

    @RequestMapping({"/shop", "/"})
    public String shopHomePage(Model model) {
        return shop(model, 1, "name", "asc");
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable String id) {
        model.addAttribute("product", productService.getProductById(id).get());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "viewProduct";
    }
}
