package com.rio.admin.dto.product;

import com.rio.admin.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponseDto {

    private Long id;
    private String name;
    private int price;
    private String adminName;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.adminName = product.getAdmin().getName();
    }


}
