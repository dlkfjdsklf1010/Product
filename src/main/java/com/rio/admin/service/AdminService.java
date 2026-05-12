package com.rio.admin.service;

import com.rio.admin.dto.admin.AdminCreateRequestDto;
import com.rio.admin.dto.admin.AdminCreateResponseDto;
import com.rio.admin.entity.Admin;
import com.rio.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    // 1. 레포지토리 연결
    private final AdminRepository adminRepository;

    // 2. 관리자 생성
    public AdminCreateResponseDto createAdmin(AdminCreateRequestDto requestDto) {

        // 엔티티 생성
        Admin admin = new Admin(requestDto.getName(), requestDto.getPassword());

        // 저장
        Admin saveAdmin = adminRepository.save(admin);

        // 응답 DTO 반환
        return new AdminCreateResponseDto(saveAdmin);
    }

    public void deleteAdmin(Long id) {

        // 1. 관리자 조회
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("관리자가 존재하지 않습니다."));

        // 2. soft delete
        admin.delete();
    }
}
