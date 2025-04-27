package com.chj.gr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Client3Controller {

    @GetMapping("/client3")
    public String client3() {

        return "Client3 is CALLED SUCCESSFULLY ..";
    }
}