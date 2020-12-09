package top.wlz922.annoboot;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Eddie
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	//根容器 父容器
	@Override
	protected Class<?>[] getRootConfigClasses() {
		logger.info("===========spring根容器加载成功============");
		return new Class[]{RootConfig.class};
	}

	//web容器 子容器
	@Override
	protected Class<?>[] getServletConfigClasses() {
		logger.info("===========springweb子容器加载成功============");
		return new Class[]{WebConfig.class};
	}

	//获取前端控制器映射信息 dispatcherServlet
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}

//public class MyWebAppInitializer {
//
//}
