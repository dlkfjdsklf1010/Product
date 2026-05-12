package com.rio.admin.dto.product;

import com.rio.admin.entity.Product;
import lombok.Getter;

@Getter
public class ProductCreateResponseDto {

    private Long id; // 1. 상품 id
    private String name; // 2. 상품 이름
    private int price; // 3. 상품 가격
    private String adminName; // 4. 관리자 이름
    private Long adminId;

    // 5. Entity -> DTO 변환
    public ProductCreateResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.adminName = product.getAdmin().getName();
        this.adminId = product.getAdmin().getId();
    }
}
