package com.taiwan.soul.evolution.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class SynchronizedExample {

	public static void main(String[] args) {

		String[] names = { "McDonald's", "Yun.Ma", "Samuel.L.Jackson" };
		int[] arr = new int[] {1, 2, 3, 4,5 ,6, 7, 8, 9, 10};
//		Comparator.comparing(null)
		Arrays.stream(names).fore
		//		int i = Arrays.stream(arr).max(element -> element > 9)
//		System.out.println(i);
		Optional<Integer> i = Optional.of(10);
		i.ifPresent(e -> System.out.println(e));
		System.out.println(s); // SAMUEL.L.JACKSON

	}

	static boolean modify(boolean flag) {

		try {
			if (flag) {
				throw new RuntimeException("error");
			}
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			flag = true;
			System.exit(0);
			return flag; // warning:finally block does not complete normally

		}

	}

}