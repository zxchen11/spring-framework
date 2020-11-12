package top.wlz922.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Eddie
 */
@Slf4j
@ControllerAdvice("top.wlz922.controller")
public class ControllerExceptionResolver {

	@ExceptionHandler(RuntimeException.class)
	public Object handleException(RuntimeException e) {
		log.warn(e.getMessage(), e);
		return null;
	}
}
