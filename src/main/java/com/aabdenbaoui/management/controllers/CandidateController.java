package com.aabdenbaoui.management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
	
//	@Autowired
//	CandidateService candidateService;
//	
//	@GetMapping("/new")
//	public String diplayNewCandidateForm(Model model) {
////		if (!model.containsAttribute("candidate")) {
////			 model.addAttribute("candidate", new Candidate());
////	   }
////		model.addAttribute("candidate", new Candidate());
////		model.addAttribute("address", new Address());
////		model.addAttribute("states", State.values());
//		return "candidate/signup";
//	}
//	
//	@PostMapping("/save")
//	public String saveCandidate(@Valid @ModelAttribute("candidate") Candidate candidate, BindingResult result, RedirectAttributes redirectAttributes) {
//		if(result.hasErrors()) {
//			  redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.candidate", result);
//			  redirectAttributes.addFlashAttribute("candidate", candidate);
//              System.out.println("The controller has errors");
//		      return "redirect:/candidates/new";
//		}
//			
////		if(candidate  != null) {
////			if(candidateService.findByEmail(candidate.getEmail()) ==  null) {
////				System.out.println("Candidate not found");
////			}else {
////				return "redirect:/candidates/new";
////		    }
////		}
//		candidateService.saveCandidate(candidate);
//		System.out.println(candidate);
//		  redirectAttributes.addFlashAttribute("success","success");
//		return "redirect:/candidates/new";
//	}
//	@GetMapping("/login")
//    public String result(Model model, Candidate candidate) {
//		model.addAttribute("candidate", candidate);
//		return "candidate/login";
//	}
//	@PostMapping("/login")
//    public String login(Model model, Candidate candidate) {
//		model.addAttribute("candidate", candidate);
//		return "home";
//	}
}
