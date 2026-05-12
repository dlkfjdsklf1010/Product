package com.rio.admin.dto.admin;

import com.rio.admin.entity.Admin;
import lombok.Getter;

@Getter
public class AdminDetailResponseDto {

    private Long id;
    private String name;

    public AdminDetailResponseDto(Admin admin) {

        this.id = admin.getId();
        this.name = admin.getName();
    }
}
