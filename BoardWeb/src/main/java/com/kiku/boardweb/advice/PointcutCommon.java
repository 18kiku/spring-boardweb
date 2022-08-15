package com.kiku.boardweb.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class PointcutCommon {
	
	
	@Pointcut("execution(* com.kiku.boardweb..*Impl.*(..))")
	public void allPointcut(){}
	
	@Pointcut("execution(* com.kiku.boardweb..*Impl.get*(..))")
	public void getPointcut(){}
	
}
