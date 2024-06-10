package com.example.Buoi8_DB_jpa.repository;

import com.example.Buoi8_DB_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
