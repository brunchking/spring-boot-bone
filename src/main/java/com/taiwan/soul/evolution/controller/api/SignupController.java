package com.taiwan.soul.evolution.controller.api;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taiwan.soul.evolution.model.Member;





@RestController
@RequestMapping("/api")
public class SignupController {
	private static final Logger logger = LoggerFactory.getLogger(SignupController.class);
	
	
	
	@PostMapping("/signup")
	public void singnUp(@RequestBody Map<String, String> map) {
		logger.info("/signup in");
		Member member = new Member();
		String email = map.get("email");
		String password = map.get("password");
		String firstName = map.get("firstName");
		String lastName = map.get("lastName");
		Date now = new Date();
		member.setEmail(email);
		member.setPassword(password);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setCreateTime(now);
		member.setUpdateTime(now);
		
	} 
}
