package com.rio.admin.service;

import com.rio.admin.entity.Admin;
import com.rio.admin.entity.Product;
import com.rio.admin.repository.AdminRepository;
import com.rio.admin.dto.ProductResponse;
import com.rio.admin.repository.ProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final AdminRepository adminRepository;

    public void createProduct(Long adminId, String name, int price) {

        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("관리자 없음"));

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setAdmin(admin);

        productRepository.save(product);
    }

    public ProductResponse getProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("상품 없음"));

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getAdmin().getName()
        );
    }

    @Transactional
    public void changeAdmin(Long productId, Long adminId) {

        Product product = productRepository.findById(productId)
                .orElseThrow();

        Admin admin = adminRepository.findById(adminId)
                .orElseThrow();

        product.setAdmin(admin);
    }

    @Transactional
    public void deleteAdmin(Long adminId) {

        Admin admin = adminRepository.findById(adminId)
                .orElseThrow();

        admin.setDeleted(true);
    }
}
