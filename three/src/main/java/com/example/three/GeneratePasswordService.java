package com.example.three;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GeneratePasswordService {
    @RequestMapping(value = "/{name:[a-z]+}.generate")
    public String generate(@PathVariable("name") String name){
        return "Hi, " + name + '\n' + "Your new password is " +  (int) (Math.random()*(1000000000)) + '.';
    }
}
