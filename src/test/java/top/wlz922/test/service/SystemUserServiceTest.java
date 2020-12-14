package top.wlz922.test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.wlz922.annoboot.GlobalTransactionConfig;
import top.wlz922.bean.SystemUserCardVo;
import top.wlz922.service.SystemUserService;
import top.wlz922.test.config.AspectAnoForTransactionConfiguration;

import java.util.List;

public class SystemUserServiceTest {
	private SystemUserService service;

	@Before
	public void before() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				GlobalTransactionConfig.class, AspectAnoForTransactionConfiguration.class);
		service = context.getBean(SystemUserService.class);
	}

	@Test
	public void getUserCardVoTest(){
		SystemUserCardVo userCardVo = service.getUserCardVo(1);
		System.out.println(userCardVo);
	}

	@Test
	public void listUserCardVo() {
		List<SystemUserCardVo> list = service.listUserCardVo();
		System.out.println(list);
	}
}
