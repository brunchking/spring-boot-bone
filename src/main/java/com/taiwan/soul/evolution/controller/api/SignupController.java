package com.taiwan.soul.evolution.controller.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.xml.bind.v2.runtime.output.XMLStreamWriterOutput;
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

	public static String reverseString(String str) {
		if (str.isEmpty())
			return str;
		// Calling Function Recursively
		return reverseString(str.substring(1)) + str.charAt(0);

	}

	public static int palindromeIndex(String s) {
		// Write your code here
		/*
		 * aaab baa aaa
		 */
		int index = 0;

//		for (int i = 0; i < s.length(); i++) {
		for (int j = 0; j < s.length(); j++) {
			StringBuilder sb = new StringBuilder();
			if (j == 0) {
				sb.append(s.substring(1));
				String str = sb.toString();
				if ((sb.reverse().toString()).equals(str)) {
					return 0;
				}
			} else {
				String left = String.valueOf(s.substring(0, j));
				String right = "";
				if ((j + 1) < s.length()) {
					right = String.valueOf(s.substring(j + 1));
//						System.out.println(j+1);
				}
				System.out.println(left + " " + right);
				sb.append(left).append(right);
				String str = sb.toString();
//					System.out.println(str);
				if ((sb.reverse().toString()).equals(str)) {
					return j;
				}
			}
		}
//		}
		return -1;
	}

	public static void swap(List<List<String>> list, int i, int j) {
		List<String> temp = list.get(i);
		list.add(i, list.get(j));
//		System.out.println(list);
		list.remove(j + 1);
		System.out.println(list);
		list.add(j + 1, temp);
		list.remove(i + 1);

	}

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
