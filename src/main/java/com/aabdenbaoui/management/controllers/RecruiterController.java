package com.aabdenbaoui.management.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.aabdenbaoui.management.entity.jobpost.JobDetails;
import com.aabdenbaoui.management.entity.jobpost.JobLocation;
import com.aabdenbaoui.management.entity.jobpost.JobPost;
import com.aabdenbaoui.management.entity.managingusers.User;
import com.aabdenbaoui.management.service.JobPostService;
import com.aabdenbaoui.management.service.JobSeekerService;
import com.aabdenbaoui.management.service.UsersService;

@Controller
@RequestMapping("/recruiter")
public class RecruiterController {
	List<User> jobSeekerUsers;
	@Autowired
	JobPostService jobPostService;
	@Autowired
	JobSeekerService jobSeekerService;
	
	@Autowired
	RecruiterService recruiterService;
	@GetMapping("home")
	public String getRecruiteHomePage(Model model, String firName) {
		if(jobSeekerUsers == null) {
		   
		}else {
	    	model.addAttribute("jobSeekerUsers", jobSeekerUsers);
		}
    	List<JobPost> jobPosts =  jobPostService.getAllActiveJobPosts();
    	List<JobPost> disabledJobPosts =  jobPostService.getAllDisabledJobPosts();
//        List<User> recruiterUsers = usersService.getAllRecruiters();

    	model.addAttribute("jobPost", new JobPost());
    	model.addAttribute("jobAddress", new JobLocation());
    	model.addAttribute("jobDetails", new JobDetails());
    	model.addAttribute("jobActivePosts", jobPosts);
    	model.addAttribute("jobSeeker", new User());
    	model.addAttribute("jobDisabledPosts", disabledJobPosts);
//    	model.addAttribute("recruiterUsers", recruiterUsers);


		return "recruiter/recruiter-home";
	}
	
	@GetMapping("jobseekers")
	public String getJobSeekersHomePage(Model model) {
		model.addAttribute("jobSeekerList", recruiterService.getAllJobSeekers());
		 return "recruiter/list-jobseekers";
	}
	
	
    @PostMapping("/createNewJobPost")
    public String  saveNewJobPost(@ModelAttribute("jobPost") JobPost jobPost, BindingResult result, RedirectAttributes redirectAttributes) {
    	jobPost.setIsActive(true);
    	System.out.println(jobPost);
    	jobPostService.createNewJobPos(jobPost);
	    return "redirect:/recruiter/home";
    }
    @PostMapping("/deleteJobPost")
    public void deleteJobPost(@RequestParam(name = "jobPostid") Long jobPostid, Model model, HttpServletResponse response) throws IOException {
    	jobPostService.deleteJobPostService(jobPostid);
		response.sendRedirect("/recruiter/home");
    }
//    
//    @PostMapping("/editJobPost")
//  
    @PostMapping("/disableJobPost")
    public void disableJobPost(@RequestParam(name = "jobPostid") Long jobPostid, Model model, HttpServletResponse response) throws IOException {
    	jobPostService.disableJobPostService(jobPostid);
		response.sendRedirect("/recruiter/home");
    }
    @PostMapping("/enableJobPost")
    public void enableJobPost(@RequestParam(name = "jobPostid") Long jobPostid, Model model, HttpServletResponse response) throws IOException {
    	jobPostService.enableJobPostService(jobPostid);
		response.sendRedirect("/recruiter/home");
   }
   
	
	
	  public void searchForJobSeeker(@RequestParam(name = "lastName") String lastName, Model model){ 
//		  jobSeekerUsers = usersService.findUsersByLastName(lastName);
//		  for(User user: jobSeekerUsers) {
//			  System.out.println(user);
//         }
//		    List<JobPost> jobPosts =  jobPostService.getAllActiveJobPosts();
//	    	List<JobPost> disabledJobPosts =  jobPostService.getAllDisabledJobPosts();
//	        List<User> recruiterUsers = usersService.getAllRecruiters();
//
//	    	model.addAttribute("jobPost", new JobPost());
//	    	model.addAttribute("jobAddress", new JobLocation());
//	    	model.addAttribute("jobDetails", new JobDetails());
//	    	model.addAttribute("jobActivePosts", jobPosts);
//	    	model.addAttribute("jobSeeker", new User());
//	    	model.addAttribute("jobDisabledPosts", disabledJobPosts);
//	    	model.addAttribute("recruiterUsers", recruiterUsers);
//
////		  System.out.println(usersService.findUsersByFirstName(firstName));
//		  model.addAttribute("jobSeekerUsers", jobSeekerUsers);
//			return "recruiter/recruiter-home";
	  }
	 
}
