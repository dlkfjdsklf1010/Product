package com.rio.admin.controller;

import com.rio.admin.dto.product.*;
import com.rio.admin.dto.product.ProductResponseDto;
import com.rio.admin.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    // 1.ProductService 연결
    private final ProductService productService;

    // 2. 상품 등록
    @PostMapping
    public ProductCreateResponseDto createProduct(@RequestBody ProductCreateRequestDto requestDto) {

        return productService.createProduct(requestDto);
    }

    // 상품 다건 조회
    @GetMapping
    public List<ProductListResponseDto> getProducts() {

        return productService.getProducts();
    }

    // 상품 단건 조회
    @GetMapping("{id}")
    public ProductResponseDto getProduct(@PathVariable Long id) {

        return productService.getProduct(id);
    }

    // 상품 수정
    @PutMapping("/{id}")
    public ProductUpdateResponseDto updateResponseDto(@PathVariable Long id, @RequestBody ProductUpdateRequestDto requestDto) {

        return productService.updateResponseDto(id,requestDto);
    }
}
