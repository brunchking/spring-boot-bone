package com.taiwan.soul.evolution.controller;

import com.taiwan.soul.evolution.model.Son;

public class Singleton extends Son{
	private static Singleton instance = null;


	
	public static boolean test() {
		boolean flag = true;
		try {
			throw new Exception();
		} catch(Exception e) {
			flag = false;
			return flag;
		} finally {
			flag = true;
		}
	}
	public static void main(String[] args) {
		String string = "3";
		String number = 2 + string;
		
	}
}
