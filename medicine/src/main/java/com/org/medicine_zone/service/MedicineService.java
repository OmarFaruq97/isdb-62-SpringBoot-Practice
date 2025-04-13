package com.org.medicine_zone.service;

import com.org.medicine_zone.model.Medicine;
import com.org.medicine_zone.repository.MedicineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public List<Medicine> getMedByName(String name) {
        return medicineRepository.findByMedicineName(name);
    }

    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }
}