package com.chj.gr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Client2Controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/client2")
    public String client2() {
        String response = restTemplate.getForObject("http://localhost:1113/client3", String.class);
        return "Client2 -> " + response;
    }
}