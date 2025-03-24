package com.org.medicine_zone.service;

import com.org.medicine_zone.model.Medicine;
import com.org.medicine_zone.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    
    private MedicineRepository repository;
    public List<Medicine> getAllMedicine() {
        return repository.findAll();
    }


    public Medicine saveMedicine(Medicine medicine) {
    }

    public Medicine getMedById(int id) {
    }

    public void deleteById(int id) {
    }
}
