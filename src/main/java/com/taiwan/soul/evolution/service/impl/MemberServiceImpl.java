package com.taiwan.soul.evolution.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taiwan.soul.evolution.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService{
	
	@Autowired
	MemberDao memberDao;
	
	public void insert() {
		
	}
}
