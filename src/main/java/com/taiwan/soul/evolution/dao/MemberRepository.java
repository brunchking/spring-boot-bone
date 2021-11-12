package com.taiwan.soul.evolution.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taiwan.soul.evolution.model.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
}
