package com.wander.covid.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    //@PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/login")
    public String securedHello(){
        return "login";
    }

}
