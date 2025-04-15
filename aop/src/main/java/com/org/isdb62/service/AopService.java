package com.org.isdb62.service;

import org.springframework.stereotype.Service;

@Service
public class AopService {

    public void sellMedicine(String name){
        System.out.println("Selling medicine to: " +name);
    }

    public int calculateBill(int qty, int pricePerUnit){
        return qty * pricePerUnit;
    }
}
