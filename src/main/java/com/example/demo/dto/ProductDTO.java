package com.example.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private String id;
    private String name;
    private String categoryId;
    private String invoiceId;
    private BigDecimal price;
    private String description;
    private String image;
}
