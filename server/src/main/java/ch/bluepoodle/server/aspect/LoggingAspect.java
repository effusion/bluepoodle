package ch.bluepoodle.server.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private static Logger LOGGER = LoggerFactory.getLogger("ServiceLogger");
	
	@Before("execution(public * ch.bluepoodle.service.impl.*.*(..))")
    public void profile(JoinPoint joinPoint){
        LOGGER.info(joinPoint.getSignature().getName());
    }
}
