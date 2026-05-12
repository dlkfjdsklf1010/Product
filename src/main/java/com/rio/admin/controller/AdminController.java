package com.rio.admin.controller;

import com.rio.admin.dto.admin.AdminCreateRequestDto;
import com.rio.admin.dto.admin.AdminCreateResponseDto;
import com.rio.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {

    // 1. 서비스 연결
    private final AdminService adminService;

  @PostMapping("/signup")
    public AdminCreateResponseDto createAdmin(@RequestBody AdminCreateRequestDto requestDto) {

      // 2. 반환
      return adminService.createAdmin(requestDto);
  }

  @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
      adminService.deleteAdmin(id);
      return "관리자 삭제 완료";
  }
}
