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

    @GetMapping("/medicines")
    public List<Medicine> getAllMedicines(){
        return service.getAllMedicines();
    }

    @GetMapping("search/{name}")
    public List <Medicine> getMedByName(@PathVariable String name){
        List <Medicine> name1 = service.getMedByName(name);
        return name1;
    }
}