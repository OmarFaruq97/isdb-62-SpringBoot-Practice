package com.org.isdb62;

import com.org.isdb62.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AopController {

    @Autowired
    private AopService aopService;

    @PostMapping("/sell")
    public String sellMedicine(@RequestParam String name){
        aopService.sellMedicine(name);
        return "Medicine sold to: "+ name;
    }

    @GetMapping("/bill")
    public String calculateBill(@RequestParam String name, @RequestParam int qty, @RequestParam int price) {
        int total = aopService.calculateBill(qty, price);
        return "Name:" + name + "\nTotal Bill: " + total + " BDT";
    }
}
