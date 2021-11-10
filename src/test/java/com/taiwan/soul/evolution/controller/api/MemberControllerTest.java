package com.taiwan.soul.evolution.controller.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberControllerTest {
	@Autowired
	MemberController memberController;

	private static int TEST_GOAL = 3000000;
	private static int MIN = 10000000;
	private static int MAX = 99999999;

	@Test
	public void testGetRandPositionAt() {
		for (int i = 0; i < TEST_GOAL; i++) {
			int randomNum = memberController.getRandomNum(MIN, MAX);
			assertTrue(randomNum <= MAX);
		}
	}

	@Test
	public void testCurrentTime() {
		for (int i = 0; i < TEST_GOAL; i++) {
			Long randomNum = memberController.getCurrentTime();
			int digitsLength = String.valueOf(randomNum).length();
			assertTrue(digitsLength <= 10);
			assertFalse(digitsLength > 10);
		}
	}

	@Test
	public void getMod() {
		String dynamicBarcode = "GID631012015966443092";
		int target = (3 + 2 + 1 + 6) % 8;
		int mod = memberController.getMod(dynamicBarcode);
		assertEquals(mod, target);
	}
}
