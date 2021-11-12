package com.taiwan.soul.evolution.controller.api;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taiwan.soul.evolution.model.Member;
import com.taiwan.soul.evolution.model.Response;
import com.taiwan.soul.evolution.service.IMemberService;
import com.taiwan.soul.evolution.utils.CipherUtils;

@RestController
@RequestMapping("/api")
public class SignupController {
	private static final Logger logger = LoggerFactory.getLogger(SignupController.class);

	@Autowired
	private IMemberService memberService;

	@PostMapping("/signup")
	public void singnUp(@RequestBody Map<String, String> map, HttpServletRequest request) {
		Member member = new Member();
		String mid = UUID.randomUUID().toString();
		String email = map.get("email");
		String password = CipherUtils.encodeMD5(map.get("password"));
		String firstName = map.get("firstName");
		String lastName = map.get("lastName");
		Date now = new Date();
		member.setMid(mid);
		member.setEmail(email);
		member.setPassword(password);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setCreateTime(now);
		member.setUpdateTime(now);
		memberService.insert(member);
	}
}
