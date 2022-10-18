package com.aabdenbaoui.management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aabdenbaoui.management.entity.managingusers.User;

@Controller

public class LoginPageController {
       @GetMapping("/login")
	   public String displayLoginPage(Model model) {
		   model.addAttribute("user", new User());
		   return "user/login";
	   }
	
}
