package org.zerock.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {
	
	private static final Logger log = LoggerFactory.getLogger(LogAdvice.class);

	@Before("excution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("===============");
	}
}