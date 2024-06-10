package com.example.Assiment_java5;

import com.example.Assiment_java5.entity.DongSp;
import com.example.Assiment_java5.entity.MauSac;
import com.example.Assiment_java5.entity.Nsx;
import com.example.Assiment_java5.entity.SanPham;
import com.example.Assiment_java5.repository.DongSpRepo;
import com.example.Assiment_java5.repository.MauSacRepo;
import com.example.Assiment_java5.repository.NSXRepo;
import com.example.Assiment_java5.repository.SanPhamRepo;
import com.example.Assiment_java5.service.DongSpService;
import com.example.Assiment_java5.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssimentJava5Application implements CommandLineRunner {
    @Autowired
    private SanPhamRepo sanPhamRepo;
    @Autowired
    private NSXRepo nsxRepo;
    @Autowired
    private DongSpRepo dongSpRepo;
    @Autowired
    private MauSacRepo mauSacRepo;

    public static void main(String[] args) {

        SpringApplication.run(AssimentJava5Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

    }
}
