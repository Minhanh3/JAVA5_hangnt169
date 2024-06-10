package com.example.Assiment_java5.repository;

import com.example.Assiment_java5.entity.DongSp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DongSpRepo extends JpaRepository<DongSp, Integer> {

}
