package com.taiwan.soul.evolution.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taiwan.soul.evolution.model.Member;

@Repository
public interface IMemberRepository extends CrudRepository<Member, String>{
}
