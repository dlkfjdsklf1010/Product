package com.rio.admin.service;

import com.rio.admin.dto.product.*;
import com.rio.admin.entity.Admin;
import com.rio.admin.entity.Product;
import com.rio.admin.repository.AdminRepository;
import com.rio.admin.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final AdminRepository adminRepository;

    @Transactional
    public ProductCreateResponseDto createProduct(ProductCreateRequestDto requestDto) {

        // 1. 관리자 조회
        Admin admin = adminRepository.findById(requestDto.getAdminId())
                .orElseThrow(() -> new IllegalArgumentException("관리자가 존재하지 않습니다."));

        // 2. 상품 엔티티 생성
        Product product = new Product(requestDto.getName(), requestDto.getPrice(), admin);

        // 3. 저장
        Product saveProduct = productRepository.save(product);

        // 4. 응답 DTO 생성
        return new ProductCreateResponseDto(saveProduct);
    }

    @Transactional
    public List<ProductListResponseDto> getProducts() {

        // 1. 전체 상품 조회
        List<Product> products = productRepository.findAll();

        // 2. Entity -> DTO 변환
        return products.stream()
                .map(ProductListResponseDto::new)
                .toList();
    }

    @Transactional
   public ProductResponseDto getProduct(Long id) {

       // 1. 상품 조회
       Product product = productRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

       // 2. ResponseDto 반환
      return new ProductResponseDto(product);
   }

   @Transactional
   public ProductUpdateResponseDto updateResponseDto(Long productId, ProductUpdateRequestDto requestDto) {

        // 1. 상품 조회
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        // 2. 새 관리자 조회
        Admin admin = adminRepository.findById(requestDto.getAdminId()).orElseThrow(() -> new IllegalArgumentException("관리자가 존재하지 않습니다."));

        // 3. 상품 정보 수정
        product.updateProduct(requestDto.getName(), requestDto.getPrice());

        // 4. 관리자 변경
        product.changeAdmin(admin);

        // 5. 응답 DTO 반환
        return new ProductUpdateResponseDto(product);
    }
}
