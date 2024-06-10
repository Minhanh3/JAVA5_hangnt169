package com.example.spring01.repository;

import com.example.spring01.entity.DongSp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DongSpRepo extends JpaRepository<DongSp, Integer> {

}
