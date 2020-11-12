package top.wlz922.interceptor;

/**
 * @author Eddie
 */
public interface HaldlerInterceptorPathPattern {
	default String[] getPathPatterns() {
		return new String[]{"/**"};
	}
}
