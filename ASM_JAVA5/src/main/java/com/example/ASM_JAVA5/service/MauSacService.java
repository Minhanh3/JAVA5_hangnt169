package com.example.ASM_JAVA5.service;

import com.example.ASM_JAVA5.entity.MauSac;
import com.example.ASM_JAVA5.repository.MauSacRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacService {

    @Autowired
    private MauSacRepo mauSacRepo;

    public List<MauSac> getAllMauSac() {
        return mauSacRepo.findAll();
    }
}
