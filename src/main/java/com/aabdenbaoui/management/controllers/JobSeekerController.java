package com.aabdenbaoui.management.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aabdenbaoui.management.entity.company.Company;
import com.aabdenbaoui.management.entity.jobpost.JobPost;
import com.aabdenbaoui.management.entity.managingusers.UserDetail;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.EducationDetail;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.ExperienceDetail;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.TimeLine;
import com.aabdenbaoui.management.service.JobPostService;
import com.aabdenbaoui.management.service.JobSeekerService;

@Controller
@RequestMapping("/jobseeker")
public class JobSeekerController {
	@Autowired
	JobSeekerService jobSeekerService;
	
	@Autowired
	JobPostService jobPostService;
	
	@GetMapping("/home")
	public String getJobSeekerHome(Model model) {
		model.addAttribute("timeLine", new TimeLine());
		return "/jobseeker/jobseeker-home";
	}

	@GetMapping("/personal-information")
	public String getPersonalInfotmation(Model model) {
	   if (!model.containsAttribute("userDetail")) {
			 model.addAttribute("userDetail", new UserDetail());
	   }
		
		return "jobseeker/jobseeker-personal-information-form";
	}
	
	@PostMapping("/save")
	public String saveJobSeekerDetails(@Valid @ModelAttribute("userDetail") UserDetail userDetail, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			  redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userDetail", result);
			  redirectAttributes.addFlashAttribute("userDetail", userDetail);
			  redirectAttributes.addFlashAttribute("error", "error");

              System.out.println("The controller has errors");
              return "redirect:/jobseeker/personal-information";
    	}
		  jobSeekerService.saveUserDetails(userDetail);
		  return "redirect:/jobseeker/home";
	}
	@GetMapping("/jobPosts")
	public String getToJobs(Model model) {
		model.addAttribute("jobPosts", jobPostService.getAllActiveJobPosts());
	        return "jobseeker/list-jobs";
	}

	@GetMapping("/experiences")
	public String getToExperiences(Model model) {
			 model.addAttribute("experiences", jobSeekerService.getAllExperiences());
	        return "jobseeker/list-experiences";
	}
	@GetMapping("/educations")
	public String getToEducations(Model model) {
			 model.addAttribute("educations", jobSeekerService.getAllEducations());
	        return "jobseeker/list-educations";
	}
	@GetMapping("/addexperience")
	public String getAddExperience(Model model) {
		 if(!model.containsAttribute("experience")) {
			    model.addAttribute("experience", new ExperienceDetail());
		    }		return "jobseeker/add-experience";
	}
	@GetMapping("/addeducation")
	public String getAddEducation(Model model) {
		 if(!model.containsAttribute("education")) {
			    model.addAttribute("education", new EducationDetail());
		    }		return "jobseeker/add-education";
	}
	@GetMapping("/saveJobPost")
	public String saveJobePostMethod(@RequestParam(name = "jobpostid") Long jobpostId, Model model, HttpServletResponse response) throws IOException {
		  jobSeekerService.saveJobPost(jobpostId);
		  
		  return "redirect:/jobseeker/jobPosts";
	}
	@PostMapping("/saveExperience")
	public String saveExperiencePostMethod(@Valid @ModelAttribute("experience") ExperienceDetail experience,  BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			  redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.experience", result);
			  redirectAttributes.addFlashAttribute("experience", experience);
			  redirectAttributes.addFlashAttribute("error", "error");
    		  return "redirect:/jobseeker/addexperience";
  	}
		jobSeekerService.saveExperience(experience);
		  return "redirect:/jobseeker/experiences";
	}
	@PostMapping("/saveEducation")
	public String saveEducationPostMethod(@Valid @ModelAttribute("education") EducationDetail education,  BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			  redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.education", result);
			  redirectAttributes.addFlashAttribute("education", education);
			  redirectAttributes.addFlashAttribute("error", "error");
    		  return "redirect:/jobseeker/addeducation";
		}
		jobSeekerService.saveEducation(education);
		  return "redirect:/jobseeker/educations";
  	}
	@PostMapping("/deleteEducation")
    public String deleteEducationPostMethod(@RequestParam(name = "educationid") Long educationId, Model model, HttpServletResponse response) throws IOException {
		jobSeekerService.deleteEducation(educationId);
		  return "redirect:/jobseeker/educations";
	}
	@PostMapping("/deleteExperience")
    public String deleteJob(@RequestParam(name = "experienceid") Long experienceID, Model model, HttpServletResponse response) throws IOException {
		jobSeekerService.deleteExperience(experienceID);
		System.out.println(experienceID);
		  return "redirect:/jobseeker/experiences";
	}   
	@GetMapping("/editEducation")
    public String editEducationPostMethod(@RequestParam(name = "educationid") Long educationId, Model model, HttpServletResponse response) throws IOException {
		  model.addAttribute("education", jobSeekerService.getEducationDetail(educationId) );
		  return "jobseeker/add-education";
	}
	@GetMapping("/editExperience")
    public String editExperiencePostMethod(@RequestParam(name = "experienceid") Long experienceID, Model model, HttpServletResponse response) throws IOException {
		  model.addAttribute("experience", jobSeekerService.getExperienceDetail(experienceID));
		  return "jobseeker/add-experience";
	}
}

