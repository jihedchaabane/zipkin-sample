package com.chj.gr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Client1Controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/client1")
    public String client1() {
        String response = restTemplate.getForObject("http://container-ms2:1112/client2", String.class);
        return "Client1 -> " + response;
    }
}
