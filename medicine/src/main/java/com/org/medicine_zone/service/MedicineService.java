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

    public boolean deleteMedicineById(int id) {
        if (medicineRepository.existsById(id)) {
            medicineRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Medicine updateMedicine(Integer id, Medicine updateMedicine) {
        Medicine existing = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found with ID: " + id));

        //update fields
        existing.setMedicineName(updateMedicine.getMedicineName());
        existing.setMg(updateMedicine.getMg());
        existing.setGeneric(updateMedicine.getGeneric());
        existing.setType(updateMedicine.getType());
        existing.setCompany(updateMedicine.getCompany());
        existing.setQuantity(updateMedicine.getQuantity());
        existing.setPrice(updateMedicine.getPrice());
        existing.setAvailable(updateMedicine.isAvailable());
        existing.setManDate(updateMedicine.getManDate());
        existing.setExpDate(updateMedicine.getExpDate());

        return medicineRepository.save(existing);
    }
}