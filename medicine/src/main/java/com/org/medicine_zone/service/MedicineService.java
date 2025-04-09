package com.org.medicine_zone.service;

import com.org.medicine_zone.model.Medicine;
import com.org.medicine_zone.repository.MedicineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository repository;

    public List<Medicine> getAllMedicines() {
        return repository.findAll();
    }

    public List<Medicine> getMedByName(String name) {
        List<Medicine> name1 = repository.findByName(name);
        return name1;
    }
}