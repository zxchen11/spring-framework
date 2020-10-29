package top.wlz922.annoboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Eddie
 */
@ComponentScan(value = "top.wlz922",excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class RootConfig {
}
