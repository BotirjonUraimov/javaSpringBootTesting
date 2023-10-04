package com.clean.code.springboot.web.res;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class studentResource {

//    @GetMapping("/students")
//    public String hello () {
//        return "Hello Spring boot";
//    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String hello () {
        return "Hello Spring boot";
    }
}
