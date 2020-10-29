package top.wlz922.annoboot;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eddie
 */
@EnableWebMvc
@ComponentScan(value = {"top.wlz922.controller","top.wlz922.interceptor"}
//		, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}
//		, useDefaultFilters = true
)
@EnableAspectJAutoProxy
public class WebConfig implements WebMvcConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);
	@Autowired(required = false)
	private List<HandlerInterceptor> interceptors;

	/**
	 * 配置springmvc视图
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		logger.info("============jsp解析器开始加载===============");
//        registry.jsp();
		registry.jsp("/WEB-INF/views/", ".jsp");

		logger.info("============jsp解析器开始成功，开始渲染把===============");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		ArrayList<MediaType> list = new ArrayList<>();
		list.add(MediaType.APPLICATION_JSON);
		list.add(MediaType.TEXT_PLAIN);
		FastJsonHttpMessageConverter c = new FastJsonHttpMessageConverter();
		c.setSupportedMediaTypes(list);
		converters.add(c);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		if (interceptors != null) {
			for (HandlerInterceptor interceptor : interceptors) {
				registry.addInterceptor(interceptor);
			}
		}
	}

	//	@Bean
//	public LogAopConfig logAopConfig(){
//		return new LogAopConfig();
//	}
}
