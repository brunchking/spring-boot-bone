package com.taiwan.soul.evolution.aop;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAspect {
	private static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

	@Autowired
	private HttpServletRequest request;

	@Pointcut("execution(* com.taiwan.soul.evolution.controller..*(..))")
	public void pointcut() {
	}
	
	@Around("pointcut()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("ControllerAspect Around start");
		logger.info("Current URI is [" + request.getRequestURI() + "]");
		joinPoint.proceed();
		logger.info("ControllerAspect Around end");
	} 
}
