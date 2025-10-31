package com.example.HospitalMgmtSys.controlller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/health")
    public String health(){
        return "health is ok... :)";
    }



}
