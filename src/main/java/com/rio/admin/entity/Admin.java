package com.rio.admin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class Admin {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   private boolean deleted = false;

   @OneToMany(mappedBy = "admin")
    private List<Product> products = new ArrayList<>();
}
