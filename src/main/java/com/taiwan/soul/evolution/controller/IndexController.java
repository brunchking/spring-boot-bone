package com.taiwan.soul.evolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.taiwan.soul.evolution.repository.IMemberRepository;

@Controller
public class IndexController {
	
	@Autowired
	private IMemberRepository memberRepository;
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping(value = "/thymeleaf-test")
	public String thymeleafTest(Model model, @RequestParam("name") String name) {
		model.addAttribute("name", name);
		return "test/thymeleaf-test";
	}
}