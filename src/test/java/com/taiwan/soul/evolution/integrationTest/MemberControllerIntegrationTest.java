package com.taiwan.soul.evolution.integrationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.taiwan.soul.evolution.controller.api.MemberController;

@SpringBootTest
public class MemberControllerIntegrationTest {
	@Autowired
	MemberController memberController;

	private static int TEST_GOAL = 3000000;
	private static int MIN = 10000000;
	private static int MAX = 99999999;
	
	@Test
	public void integrationTest() {
		long currentTime = memberController.getCurrentTime();
		int randomNum = memberController.getRandomNum(MIN, MAX);
		
		for (int i = 0; i < TEST_GOAL; i++) {
			String dynamicBarcode = memberController.genDynamicBarcode(currentTime, randomNum);
			assertTrue(dynamicBarcode.length() == 21);
		}
	}
	
	@Test
	public void pressureTest() {
		long currentTime = memberController.getCurrentTime();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < TEST_GOAL; i++) {
			int randomNum = memberController.getRandomNum(MIN, MAX);
			String dynamicBarcode = memberController.genDynamicBarcode(currentTime + i, randomNum);
			set.add(dynamicBarcode);
		}
		assertEquals(set.size(), TEST_GOAL);
	}
}
