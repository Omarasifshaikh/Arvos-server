package com.arvos.server.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AugmentController {

    @RequestMapping("/")
    public String index() {
        return "Welcome to the Arvos Server.";
    }

}