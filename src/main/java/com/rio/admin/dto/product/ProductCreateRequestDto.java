package com.rio.admin.dto.product;

import lombok.Getter;

@Getter
public class ProductCreateRequestDto {

    private String name; //1. 상품이름
    private int price; // 2. 상품 가격
    private Long adminId; // 3. 관리자 id
}
