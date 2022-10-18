package com.aabdenbaoui.management.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aabdenbaoui.management.entity.enums.UserTypeEnum;
import com.aabdenbaoui.management.entity.managingusers.AccountType;
import com.aabdenbaoui.management.entity.managingusers.User;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.SeekerProfile;
import com.aabdenbaoui.management.service.JobSeekerService;
import com.aabdenbaoui.management.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	   @Autowired
	   UsersService usersService;
	  
	   @Autowired
	   JobSeekerService jobSeekerService;
      
       
       @PostMapping("/finishSetup")
       public String directToFinishSetup(Model model, @ModelAttribute("user") User user) {
    	   System.out.print(user);
    	   if(user.getAccountType().getUserType() == UserTypeEnum.JOB_SEEKER) {
    		   return  "jobseeker/jobseeker-personal-information-form";
    	   }else {
    		   return "recruiter/recruiter-personal-information-form";
    	   }
       }
	
}
 