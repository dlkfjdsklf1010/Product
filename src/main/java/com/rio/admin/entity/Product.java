package com.rio.admin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 1. 상품 id
    private String name; // 2. 상품 이름
    private int price; // 3. 상품 가격

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id") // 4. FK 설정
    private Admin admin;

    // 5. 상품 생성자
    public Product(String name, int price, Admin admin) {
        this.name = name;
        this.price = price;
        this.admin = admin;
    }

    // 상품 수정 메서드
    public void updateProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // 관리자 변경 메서드
    public void changeAdmin(Admin admin) {
        this.admin = admin;
    }
}
