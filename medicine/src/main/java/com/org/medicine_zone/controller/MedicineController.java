package com.org.medicine_zone.controller;

import com.org.medicine_zone.model.Medicine;
import com.org.medicine_zone.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/all")
    public List<Medicine> getAllMedicines(){
        return medicineService.getAllMedicines();
    }

    @GetMapping("search/{name}")
    public List <Medicine> getMedByName(@PathVariable String name){

        return medicineService.getMedByName(name);
    }

    @PostMapping("/add")
    public Medicine addMedicine(@RequestBody Medicine medicine) {

        return medicineService.saveMedicine(medicine);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMedicineById(@PathVariable int id){
        medicineService.deleteMedicineById(id);

            return ResponseEntity.ok("Medicine with ID " + id + " was deleted successfully.");

    }

    @PutMapping ("/update/{id}")
    public Medicine updateMedicine(@PathVariable Integer id, @RequestBody Medicine updateMedicine){
        return medicineService.updateMedicine(id, updateMedicine);
    }


}