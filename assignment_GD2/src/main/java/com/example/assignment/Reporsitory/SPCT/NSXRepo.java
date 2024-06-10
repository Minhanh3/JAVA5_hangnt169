package com.example.assignment.Reporsitory.SPCT;

import com.example.assignment.Entity.SPCT.Nsx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NSXRepo extends JpaRepository<Nsx, Integer> {
    boolean existsByMa(String ma);
}
