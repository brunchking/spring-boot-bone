package com.taiwan.soul.evolution.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taiwan.soul.evolution.dao.MemberRepository;
import com.taiwan.soul.evolution.model.Member;
import com.taiwan.soul.evolution.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService{
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public void insert(Member member) {
		memberRepository.save(member);
	}
}
