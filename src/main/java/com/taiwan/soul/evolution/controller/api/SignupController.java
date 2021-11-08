package com.taiwan.soul.evolution.controller.api;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.taiwan.soul.evolution.model.Response;

@RestController
@RequestMapping("/api")
public class SignupController {
	@PostMapping("/signup")
	public Response member() {
	
		return null;
	}
}
