package com.example.spring01.repository;

import com.example.spring01.entity.Nsx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NSXRepo extends JpaRepository<Nsx, Integer> {

}
