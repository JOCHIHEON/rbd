package net.javajs.rbd.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Service
@Slf4j
public class LogAdvice {

	@Around("execution(* com.example.demo..*Controller.*(..))")
	public Object controllerLog(ProceedingJoinPoint pjp) throws Throwable {

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object result = pjp.proceed();
		stopWatch.stop();

		StringBuffer logMessage = new StringBuffer();
		logMessage.append(pjp.getTarget().getClass().getName());
		logMessage.append(".");
		logMessage.append(pjp.getSignature().getName());
		logMessage.append("(");
		Object[] args = pjp.getArgs();
		for (int i = 0; i < args.length; i++) {
			logMessage.append(args[i]).append(",");
		}
		if (args.length > 0) {
			logMessage.deleteCharAt(logMessage.length() - 1);
		}
		logMessage.append(")");
		logMessage.append(" execution time: ");
		logMessage.append(stopWatch.getTotalTimeMillis());
		logMessage.append(" ms");
		log.info(logMessage.toString());
		return result;
	}
}
