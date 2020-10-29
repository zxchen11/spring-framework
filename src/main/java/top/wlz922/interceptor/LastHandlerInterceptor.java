package top.wlz922.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static top.wlz922.constant.StatisticsConstant.THREAD_LOCAL_STOP_WATCH;

/**
 * @author Eddie
 */
@Component
@Slf4j
@Order(2)
public class LastHandlerInterceptor implements HandlerInterceptor {
	final String CLASS_NAME = CustomHandlerInterceptor2.class.getName();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		log.info("LastHandlerInterceptor.afterCompletion() execute...");
		printExecuteTime();
	}

	private void printExecuteTime() {
		StopWatch stopWatch = THREAD_LOCAL_STOP_WATCH.get();
		stopWatch.stop();
		THREAD_LOCAL_STOP_WATCH.remove();
		StopWatch.TaskInfo[] taskInfo = stopWatch.getTaskInfo();
		for (StopWatch.TaskInfo info : taskInfo) {
			log.debug("taskName : {}, {}ms, {}s", info.getTaskName(), info.getTimeMillis(), info.getTimeSeconds());
		}
		log.debug("总时长:{}ms, {}s", stopWatch.getTotalTimeMillis(), stopWatch.getTotalTimeMillis());
	}
}
