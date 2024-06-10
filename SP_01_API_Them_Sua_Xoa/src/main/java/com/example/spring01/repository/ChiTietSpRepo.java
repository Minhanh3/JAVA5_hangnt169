package com.example.spring01.repository;

import com.example.spring01.entity.ChiTietSp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietSpRepo extends JpaRepository<ChiTietSp, Integer> {

}
