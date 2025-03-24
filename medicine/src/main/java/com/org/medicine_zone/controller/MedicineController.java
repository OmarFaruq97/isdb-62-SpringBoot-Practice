package com.org.medicine_zone.controller;

import com.org.medicine_zone.model.Medicine;
import com.org.medicine_zone.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService service;


    @RequestMapping("/")
    public String greet(){
        return "Hello world";
    }

    @GetMapping("/medicines")
    public List<Medicine> getAllMedicines(){
        return service.getAllMedicines();
    }
}
