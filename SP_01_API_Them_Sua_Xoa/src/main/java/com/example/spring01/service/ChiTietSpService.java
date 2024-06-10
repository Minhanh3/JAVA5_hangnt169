package com.example.spring01.service;

import com.example.spring01.entity.ChiTietSp;
import com.example.spring01.repository.ChiTietSpRepo;
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
