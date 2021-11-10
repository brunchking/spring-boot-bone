package com.taiwan.soul.evolution.controller.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.catalina.filters.ExpiresFilter.XServletOutputStream;
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

	////////////////////////
	private int[] timeIndex = new int[] { 11, 14, 18, -1, 12, 16, 20, 6, 8, 4 };
	private int[] randIndex = new int[] { 5, 7, 9, 10, 13, 15, 17, 19 };
	private int[] modIndex = new int[] { 5, 9, 11, 15 };
	private int DYNAMIC_BARCODE_LENGTH = 21;
	private static int TEST_GOAL = 3000000;
	private static int MIN = 10000000;
	private static int MAX = 99999999;

	public static void main(String[] args) {
		MemberController mc = new MemberController();
		int randomNum = mc.getRandomNum(MIN, MAX);
		long currentTime = mc.getCurrentTime();
//		String dynamicBarcode = mc.genDynamicBarcode(currentTime, randomNum);
//		System.out.println("currentTime = [" + currentTime + "], size = [" + String.valueOf(currentTime).length() + "]");
//		System.out.println("randomNum = [" + randomNum + "], size = [" + String.valueOf(randomNum).length() + "]");
//		System.out.println("dynamicBarcode = [" + dynamicBarcode + "], size = [" + String.valueOf(dynamicBarcode).length() + "]");
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < TEST_GOAL; i++) {
			String dynamicBarcode = mc.genDynamicBarcode(currentTime + i, mc.getRandomNum(MIN, MAX));
			set.add(dynamicBarcode);
		}
		System.out.println(set);
		System.out.println("size = [" + set.size() + "]"); // 99999999
	}

	public int getRandomNum(int min, int max) {
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}

	public long getCurrentTime() {
		long currentTime = System.currentTimeMillis() / 1000;
		return currentTime;
	}

	public String genDynamicBarcode(long time, int num) {
		String currentTime = String.valueOf(time);
		String randomNum = String.valueOf(num);
		StringBuilder sb = new StringBuilder("DB2");
		for (int i = 0; i < DYNAMIC_BARCODE_LENGTH; i++) {
			for (int j = 0; j < timeIndex.length; j++) {
				if (i == timeIndex[j]) {
					sb.append(currentTime.charAt(j));
				}
			}
			for (int k = 0; k < randIndex.length; k++) {
				if (i == randIndex[k]) {
					sb.append(randomNum.charAt(k));
				}
			}
		}
		int mod = getMod(sb.toString());
		sb.append(String.valueOf(mod));
		return sb.toString();
	}

	public int getMod(String dynamicBarcode) {
		int mod = 0;
		for (int i = 0; i < modIndex.length; i++) {
			int num = dynamicBarcode.charAt(modIndex[i] - 1) - '0';
			mod += num;
		}
		return mod % 8;
	}

}
