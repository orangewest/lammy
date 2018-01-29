package com.peng.lammy.base.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class ControllerAop {

	@Pointcut("execution(public com.peng.lammy.base.response.Response *(..))")
	public void pointReponse() {

	}

	@Around("pointReponse()")
	public Object methodReponseHandler(ProceedingJoinPoint pjp) throws Throwable {
		return methodHandler(pjp);
	}

	private Object methodHandler(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		log.info("URL : " + request.getRequestURL().toString());
		log.info("HTTP_METHOD : " + request.getMethod());
		log.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
		log.info("ARGS : " + Arrays.toString(pjp.getArgs()));
		Object result;
		result = pjp.proceed();
		log.info(pjp.getSignature() + " use time:" + (System.currentTimeMillis() - startTime) + "ms");
		return result;
	}
}
