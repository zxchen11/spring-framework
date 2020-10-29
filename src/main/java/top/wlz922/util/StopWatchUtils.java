package top.wlz922.util;

import org.springframework.util.StopWatch;

/**
 * @author Eddie
 */
public class StopWatchUtils {
	static final String STOP_WATCH_DELIMITER = " -> ";

	public static void snapshot(StopWatch stopWatch, String newTaskInfoName) {
		String lastTaskName = "START";
		if (stopWatch.isRunning()) {
			stopWatch.stop();
			String ltn = stopWatch.getLastTaskName();
			lastTaskName = ltn.substring(ltn.lastIndexOf(STOP_WATCH_DELIMITER));
		}
		stopWatch.start(lastTaskName + STOP_WATCH_DELIMITER + newTaskInfoName);
	}
}
