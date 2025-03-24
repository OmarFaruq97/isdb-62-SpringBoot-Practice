package com.org.medicine_zone.controller;

import com.org.medicine_zone.model.Medicine;
import com.org.medicine_zone.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService service;

    public MedicineController(MedicineService service){
        this.service = service;
    }

    @PostMapping
    public Medicine saveMed(@RequestBody Medicine medicine){
        Medicine savedMed = service.saveMedicine(medicine);
        return savedMed;
    }

    @GetMapping("/{id}")
    public Medicine getMedById(@PathVariable int id){
        Medicine medById = service.getMedById(id);
        return medById;
    }

    @GetMapping("/medicines")
    public List<Medicine> getAllMedicines(){
        return service.getAllMedicine();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Medicine updateMed(@PathVariable int id, @RequestBody Medicine medicine){
        Medicine updated = service.updateMed(id, medicine);
        return updated;
    }

    @GetMapping("search/{name}")
    public List<Medicine> getMedByName(@PathVariable String name){
        List <Medicine> name = service.getMedByName(name);
        return name;
    }
}
