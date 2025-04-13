package com.org.medicine_zone.repository;

import com.org.medicine_zone.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

    List<Medicine> findByMedicineName(String medicineName);

}
