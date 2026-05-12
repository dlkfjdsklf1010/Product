package com.rio.admin.dto.admin;

import com.rio.admin.entity.Admin;
import lombok.Getter;

@Getter
public class AdminResponseDto {

    private Long id; // 1. 관리자 id
    private String name; // 2. 관리자 이름

    // 3. Entity -> DTO 변환
    public AdminResponseDto(Admin admin) {
        this.id = admin.getId();
        this.name = admin.getName();
    }
}
