package org.isdb_62_spring.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
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

    @GetMapping("/myfriend")
    public String getFriend(@RequestParam String myName, @RequestParam String friendName) {
        return"My name is " + myName + " and " + friendName + " is my best friends!";
    }

}
