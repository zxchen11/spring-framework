package top.wlz922.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
}
