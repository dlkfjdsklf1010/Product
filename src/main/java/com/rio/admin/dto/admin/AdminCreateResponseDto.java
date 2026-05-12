package com.rio.admin.dto.admin;

import com.rio.admin.entity.Admin;
import lombok.Getter;

@Getter
public class AdminCreateResponseDto {

    private Long id;
    private String name;

    public AdminCreateResponseDto(Admin admin) {
        this.id = admin.getId();
        this.name = admin.getName();
    }
}
