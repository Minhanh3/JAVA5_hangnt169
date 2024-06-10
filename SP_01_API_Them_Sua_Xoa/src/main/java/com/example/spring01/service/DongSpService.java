package com.example.spring01.service;

import com.example.spring01.entity.DongSp;
import com.example.spring01.repository.DongSpRepo;
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

    public void save(DongSp dongSp){
        dongSpRepo.save(dongSp);
    };
}
