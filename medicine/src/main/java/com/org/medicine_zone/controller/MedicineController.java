package com.org.medicine_zone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @RequestMapping("/")
    public String greet(){
        return "Hello world";
    }
}
