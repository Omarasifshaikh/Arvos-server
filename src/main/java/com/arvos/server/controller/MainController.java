package com.arvos.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MainController {

    @RequestMapping("/")
    public @ResponseBody String index() {
        return "Welcome to the Arvos Server.";
    }
}
