package com.example.three;

import org.springframework.web.bind.annotation.*;

@RestController
public class Mathservice {
    @RequestMapping(value = "/add/{num1}/{num2}", method = RequestMethod.GET)
    public double add(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        return num1 + num2;
    }
    @RequestMapping(value = "/minus/{num1}/{num2}")
    public double minus(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        return num1 - num2;
    }
    @RequestMapping(value = "/multiply")
    public double multiply(@RequestParam("num1") double num1, @RequestParam("num2") double num2){
        return num1 * num2;
    }
    @RequestMapping(value = "/divide")
    public double divide(@RequestParam("num1") double num1, @RequestParam("num2") double num2){
        return num1 / num2;
    }

}
