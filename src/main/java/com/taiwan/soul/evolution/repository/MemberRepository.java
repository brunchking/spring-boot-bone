package com.taiwan.soul.evolution.repository;

import org.springframework.data.repository.CrudRepository;
import com.taiwan.soul.evolution.model.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
}
