package com.rio.admin.dto.admin;

import com.rio.admin.entity.Admin;
import lombok.Getter;

@Getter
public class AdminUpdateResponseDto {

    private Long id;
    private String name;

    public AdminUpdateResponseDto(Admin admin) {
        this.id = admin.getId();
        this.name = admin.getName();
    }
}
