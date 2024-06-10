package com.example.hello.repository;

import com.example.hello.entity.DatPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatPhongRepo extends JpaRepository<DatPhong, Integer> {

}
