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


}
