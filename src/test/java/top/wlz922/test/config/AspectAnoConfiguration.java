package top.wlz922.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author Eddie
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"top.wlz922.aspect", "top.wlz922.service","top.wlz922.bean"})
@Import(A.class)
public class AspectAnoConfiguration {
}
