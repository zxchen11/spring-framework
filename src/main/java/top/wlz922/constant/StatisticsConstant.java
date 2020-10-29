package top.wlz922.constant;

import org.springframework.util.StopWatch;

/**
 * @author Eddie
 */
public interface StatisticsConstant {
	ThreadLocal<StopWatch> THREAD_LOCAL_STOP_WATCH = ThreadLocal.withInitial(StopWatch::new);

	default void snapshot() {

	}
}
