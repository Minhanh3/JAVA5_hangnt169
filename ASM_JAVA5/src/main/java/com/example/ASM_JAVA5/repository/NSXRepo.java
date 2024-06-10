package com.example.ASM_JAVA5.repository;

import com.example.ASM_JAVA5.entity.Nsx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NSXRepo extends JpaRepository<Nsx, Integer> {

}
