package mooon.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author Administrator
 * @date 2019/11/8.
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {

	@Around("execution(* mooon..*(..)))")
	public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
		//Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		final StopWatch stopWatch = new StopWatch();

		//Measure method execution time
		stopWatch.start();
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();

		//Log method execution time
		log.info("Execution time of " + className + "." + methodName + " "
				+ ":: " + stopWatch.getTotalTimeMillis() + " ms");

		return result;
	}
}
