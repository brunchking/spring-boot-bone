package com.taiwan.soul.evolution.controller.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taiwan.soul.evolution.model.Member;

@RestController
@RequestMapping("/api")
public class MemberController {

	@GetMapping("/members")
	public List<Member> member() {
		List<Member> list = new ArrayList<Member>();
		Member member = new Member();
		member.setMid(new UUID(0, 1).toString());
		member.setEmail("ricard69420@gmail.com");
		member.setPassword("test1234");
		member.setFirstName("Ricardo");
		member.setLastName("Millos");
		member.setCreateTime(new Date());
		member.setUpdateTime(new Date());
		list.add(member);
		return list;
	}
}
