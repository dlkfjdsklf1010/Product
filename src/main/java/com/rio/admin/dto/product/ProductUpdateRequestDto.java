package com.rio.admin.dto.product;

import lombok.Getter;

@Getter
public class ProductUpdateRequestDto {

    private String name;
    private int price;
    private Long adminId;
}
