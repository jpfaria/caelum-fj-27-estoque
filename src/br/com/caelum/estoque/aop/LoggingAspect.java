package br.com.caelum.estoque.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//Log4j
	private Logger logger = Logger.getLogger(LoggingAspect.class);
	
	@Before("metodosDeServico()")
	public void logaNoComeco(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		String typeName = joinPoint.getSignature().getDeclaringTypeName();
		
		logger.info("Executando antes do metodo: " + methodName + " da classe: " + typeName);
		
	}
	
	/*
	@After("metodosQueEuQuero()")
	public void logaNoFinal(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		String typeName = joinPoint.getSignature().getDeclaringTypeName();
		
		logger.info("Executando depois do metodo: " + methodName + " da classe: " + typeName);
		
	}
	*/
	
	@Pointcut("execution(* br.com.caelum.estoque.service..*.*(..))")
	public void metodosDeServico() {}
	
	@Pointcut("execution(* br.com.caelum.estoque.dao..*.*(..))")
	public void metodosDeDao() {}
	
	@Pointcut("metodosDeServico() && metodosDeDao()")
	public void metodosQueEuQuero() {}
	
	
	/*
	@Around("execution(* br.com.caelum.estoque.dao..*.*(..))")
	public Object metodosDeDao(ProceedingJoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		String typeName = joinPoint.getSignature().getDeclaringTypeName();
		logger.info("Executando antes do metodo: " + methodName + " da classe: " + typeName);
		
		Object obj = null;
		
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			logger.info("Exception: " + e.getMessage());
		}
		
		logger.info("Executando depois do metodo: " + methodName + " da classe: " + typeName);
		
		return obj;
		
	}
	*/

}
