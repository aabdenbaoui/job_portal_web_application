package com.aabdenbaoui.management.controllers;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aabdenbaoui.management.entity.enums.UserTypeEnum;
import com.aabdenbaoui.management.entity.managingusers.User;
import com.aabdenbaoui.management.service.UsersService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	UsersService usersService;
	
	@GetMapping("/home")
	public String directToHome(Model model) {
		if(usersService.getUserType() == UserTypeEnum.JOB_SEEKER) {
			return "redirect:/jobseeker/home";
		}else {
			return "redirect:/recruiter/home";
		}
	}

}
