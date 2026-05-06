package com.rio.admin.controller;

import com.rio.admin.dto.ProductResponse;
import com.rio.admin.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void create(@RequestParam Long adminId, @RequestParam String name, @RequestParam int price) {
        productService.createProduct(adminId, name, price);
    }

    @GetMapping("/{id}")
    public ProductResponse get(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PutMapping("/{id}")
    public void changeAdmin(@PathVariable Long id, @RequestParam Long adminId) {
        productService.changeAdmin(id, adminId);
    }

}
