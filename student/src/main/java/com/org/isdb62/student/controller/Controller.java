package com.org.isdb62.student.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "*")
public class Controller {
	@GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
	
	@GetMapping("/omar")
	public static String getdata(@RequestParam int num1, @RequestParam int num2) {
		int sum= num1+num2;
		return "Result"+ sum;
	}	
	
	@PostMapping("/subs")
	public static String getdata2  (@RequestParam int num1, @RequestParam int num2) {
		int substract = num1-num2;
		return "Result=" + substract;
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
        return"My name is " + myName + " and my father name is: " + fatherName +"My age is"+  sonAge +" !" ;
    }

}
