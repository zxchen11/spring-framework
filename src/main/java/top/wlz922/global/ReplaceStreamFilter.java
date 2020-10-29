package top.wlz922.global;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Eddie
 */
@WebFilter(filterName = "ReplaceStreamFilter",urlPatterns = "/*")
@Slf4j
public class ReplaceStreamFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("ReplaceStreamFilter.init() execute...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.debug("重置ServletRequest.inputStream() ...");
		chain.doFilter(new RequestWrapper((HttpServletRequest)request), response);
	}

	@Override
	public void destroy() {
		log.debug("ReplaceStreamFilter.destroy() execute...");
	}
}
