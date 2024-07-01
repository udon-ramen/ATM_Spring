package com.example.demo.Login.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Login.service.AccountUserDetails;

@Controller
public class LoginSuccessController {
	@GetMapping("/menu")
    public String menu(@AuthenticationPrincipal AccountUserDetails user) {
		System.out.println(user.getUsername());
        return "menu";
    }
}
