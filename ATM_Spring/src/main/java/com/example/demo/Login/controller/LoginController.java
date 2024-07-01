package com.example.demo.Login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/loginPage")
    String login() {
        return "login";
    }
}
