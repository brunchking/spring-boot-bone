package com.taiwan.soul.evolution.core;

public enum URlName {
	SIGNUP("signup");
	
	private String urlName;
	
	URlName(String urlName) {
		this.urlName = urlName;
	}

	public String getUrlName() {
		return urlName;
	}
}
