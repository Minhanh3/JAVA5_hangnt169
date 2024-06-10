package com.example.ASM_JAVA5.service;

import com.example.ASM_JAVA5.entity.MauSac;
import com.example.ASM_JAVA5.entity.Nsx;
import com.example.ASM_JAVA5.repository.MauSacRepo;
import com.example.ASM_JAVA5.repository.NSXRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NsxService {

    @Autowired
    private NSXRepo nsxRepo;

    public List<Nsx> getAllNsx() {
        return nsxRepo.findAll();
    }
}
