package com.example.assignment;

import com.example.assignment.Entity.SPCT.DongSp;
import com.example.assignment.Entity.SPCT.MauSac;
import com.example.assignment.Entity.SPCT.Nsx;
import com.example.assignment.Entity.SPCT.SanPham;
import com.example.assignment.Reporsitory.SPCT.DongSpRepo;
import com.example.assignment.Reporsitory.SPCT.MauSacRepo;
import com.example.assignment.Reporsitory.SPCT.NSXRepo;
import com.example.assignment.Reporsitory.SPCT.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner {
    @Autowired
    private SanPhamRepo sanPhamRepo;
    @Autowired
    private NSXRepo nsxRepo;
    @Autowired
    private DongSpRepo dongSpRepo;
    @Autowired
    private MauSacRepo mauSacRepo;

    @Override
    public void run(String... args) throws Exception {

    }

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
    }

}
