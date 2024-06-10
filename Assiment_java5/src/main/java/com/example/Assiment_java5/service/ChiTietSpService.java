package com.example.Assiment_java5.service;

import com.example.Assiment_java5.entity.ChiTietSp;
import com.example.Assiment_java5.repository.ChiTietSpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietSpService {

    @Autowired
    private ChiTietSpRepo chiTietSpRepo;

    public List<ChiTietSp> getAllChiTietSp() {
        return chiTietSpRepo.findAll();
    }

}
