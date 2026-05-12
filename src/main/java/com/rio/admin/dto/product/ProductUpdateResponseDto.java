package com.rio.admin.dto.product;

import com.rio.admin.entity.Product;
import lombok.Getter;

@Getter
public class ProductUpdateResponseDto {

    private Long id;
    private String name;
    private int price;
    private String adminName;
    private Long adminId;

    public ProductUpdateResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.adminName = product.getAdmin().getName();
        this.adminId = product.getAdmin().getId();
    }
}
