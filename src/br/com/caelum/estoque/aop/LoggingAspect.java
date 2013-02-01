package br.com.caelum.estoque.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//Log4j
	private Logger logger = Logger.getLogger(LoggingAspect.class);
	
	/*
	@Before("metodosDeServico()")
	public void logaNoComeco(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		String typeName = joinPoint.getSignature().getDeclaringTypeName();
		
		logger.info("Executando metodo: " + methodName + " da classe: " + typeName);
		
	}
	
	@Pointcut("execution(* br.com.caelum.estoque.service..*.*(..))")
	public void metodosDeServico() {}
	*/
	
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

}
