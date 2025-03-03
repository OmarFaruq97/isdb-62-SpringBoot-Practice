package org.isdb_62_spring.practice.controller;


import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class DummyController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/bye")
    public String bye(){
        return "Good Bye";
    }

    @GetMapping("/square")
    public int square(@RequestParam int number){
        return number * number;
    }

    @GetMapping("/info")
    public String info(@RequestParam (name = "my_Name") String myName ,
                            @RequestParam (required = false) String fatherName,
                            @RequestParam (value = "age") int sonAge
    )  {
        return"My name is " + myName + " and my father name is: " + fatherName +  sonAge +" !" ;
    }
}
