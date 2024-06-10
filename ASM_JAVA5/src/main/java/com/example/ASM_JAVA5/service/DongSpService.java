package com.example.ASM_JAVA5.service;

import com.example.ASM_JAVA5.entity.DongSp;
import com.example.ASM_JAVA5.entity.Nsx;
import com.example.ASM_JAVA5.repository.DongSpRepo;
import com.example.ASM_JAVA5.repository.NSXRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DongSpService {

    @Autowired
    private DongSpRepo dongSpRepo;

    public List<DongSp> getAllDongSp() {
        return dongSpRepo.findAll();
    }
}
