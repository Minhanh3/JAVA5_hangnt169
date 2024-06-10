package com.example.Assiment_java5.service;

import com.example.Assiment_java5.entity.DongSp;
import com.example.Assiment_java5.repository.DongSpRepo;
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
