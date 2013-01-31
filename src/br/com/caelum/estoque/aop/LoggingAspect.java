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
		
		logger.info("Executando metodo: " + methodName + " da classe: " + typeName);
		
	}
	
	
	@Pointcut("execution(* br.com.caelum.estoque.service..*.*(..))")
	public void metodosDeServico() {}

}
