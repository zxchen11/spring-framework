package top.wlz922.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.wlz922.util.StopWatchUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static top.wlz922.constant.StatisticsConstant.THREAD_LOCAL_STOP_WATCH;

/**
 * @author Eddie
 */
@Component
@Slf4j
@Order(2)
public class CustomHandlerInterceptor2 implements HandlerInterceptor {
	final String CLASS_NAME = CustomHandlerInterceptor2.class.getSimpleName();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		StopWatchUtils.snapshot(THREAD_LOCAL_STOP_WATCH.get(), CLASS_NAME + ".preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		log.info("CustomHandlerInterceptor2.postHandle() execute...");
		StopWatchUtils.snapshot(THREAD_LOCAL_STOP_WATCH.get(), CLASS_NAME + ".preHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		log.info("CustomHandlerInterceptor2.afterCompletion() execute...");
		StopWatchUtils.snapshot(THREAD_LOCAL_STOP_WATCH.get(), CLASS_NAME + ".preHandle");
	}
}
