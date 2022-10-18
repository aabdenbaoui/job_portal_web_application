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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aabdenbaoui.management.entity.enums.UserTypeEnum;
import com.aabdenbaoui.management.entity.managingusers.AccountType;
import com.aabdenbaoui.management.entity.managingusers.User;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.SeekerProfile;
import com.aabdenbaoui.management.service.JobSeekerService;
import com.aabdenbaoui.management.service.UsersService;

@Controller
public class RegisterationController {

	@Autowired
	UsersService usersService;

	@Autowired
	JobSeekerService jobSeekerService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String displaySignupForm(Model model) {
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());
		}

		if (!model.containsAttribute("accountType")) {
			model.addAttribute("accountType", new AccountType());
		}
		if (!model.containsAttribute("accountType")) {
			model.addAttribute("accountType", new AccountType());
		}
		return "user/signup";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {
		System.out.println("USer: " + user.getEmail());
       System.out.println("Is found?: " + usersService.isFound(user.getEmail()));
		
 	       if(result.hasErrors() && usersService.isFound(user.getEmail())){
		  redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
		  redirectAttributes.addFlashAttribute("user", user);
		  redirectAttributes.addFlashAttribute("error","error"); //
		  redirectAttributes.addFlashAttribute("emailError","emailError"); 
    	  return  "redirect:/register";
		   } else if(usersService.isFound(user.getEmail())) {
			    redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
		        redirectAttributes.addFlashAttribute("user", user);
		        redirectAttributes.addFlashAttribute("emailError", "emailError"); 
		        return "redirect:/register"; 
		  }else if(result.hasErrors()) {
			  redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
			  redirectAttributes.addFlashAttribute("user", user);
			  redirectAttributes.addFlashAttribute("error","error"); //
			  redirectAttributes.addFlashAttribute("passCode","emailError"); 
        	  return  "redirect:/register";
			  
			  
		
		  }
		  System.out.println(user);
		 
    	   redirectAttributes.addFlashAttribute("success","success");
    	   if(user.getAccountType().getUserType() == UserTypeEnum.JOB_SEEKER) {
    		   SeekerProfile seekerProfile = new SeekerProfile(user.getFirstName(), user.getLastName(), usersService.createUserWithHasshedPassword(user));
    		   jobSeekerService.createJobSeekerProfile(seekerProfile);
    	   }else {
               usersService.saveUser(user);
    	   }
    	    model.addAttribute("user", user);
		return "redirect:/register";
	}

}
