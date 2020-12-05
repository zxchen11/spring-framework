package top.wlz922.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Eddie
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@ComponentScan(basePackages = {"top.wlz922.aspect", "top.wlz922.service","top.wlz922.bean"})
public class AspectAnoConfiguration {
}
