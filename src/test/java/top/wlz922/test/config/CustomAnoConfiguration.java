package top.wlz922.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.wlz922.customano.CustomAno;

@Configuration
@ComponentScan(basePackages = "top.wlz922.customano",
		includeFilters = {@ComponentScan.Filter(value = CustomAno.class)})
public class CustomAnoConfiguration {
}
