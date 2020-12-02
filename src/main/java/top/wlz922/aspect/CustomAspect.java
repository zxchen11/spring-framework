package top.wlz922.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class CustomAspect {
	@Pointcut("execution(* top.wlz922.aspect.*.*(..))")
	public void pointCut(){}

	@Before("pointCut()")
	public void before(){
		log.info("CustomAspect.before execute...");
	}


	@After("pointCut()")
	public void after(){
		log.info("CustomAspect.after execute...");
	}

	@AfterReturning("pointCut()")
	public void afterReturning() {
		log.info("CustomAspect.afterReturning execute...");
	}

	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		log.info("CustomAspect.afterThrowing execute...");
	}

	@Around(value = "pointCut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		log.info("CustomAspect.around before execute...");
		Object obj = pjp.proceed();
		log.info("CustomAspect.around after execute...");
		return obj;
	}
}
