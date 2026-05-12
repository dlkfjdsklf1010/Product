package com.rio.admin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "admins")
public class Admin{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id; // 1. 관리자 id
   private String name; // 2. 관리자 이름
   private String password; // 3. 관리자 비밀번호
   private boolean deleted = false; // soft delete 여부

   // 4. 관리자 생성자
   public Admin(String name, String password) {
      this.name = name;
      this.password = password;
   }

   // soft delete 메서드
   public void delete() {
      this.deleted = true;
   }


}
