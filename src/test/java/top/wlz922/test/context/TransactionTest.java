package top.wlz922.test.context;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.wlz922.bean.TRole;
import top.wlz922.service.RoleService;
import top.wlz922.test.config.AspectAnoConfiguration;
import top.wlz922.test.config.GlobalTransactionConfig;

public class TransactionTest {
	@Test
	public void testTx(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GlobalTransactionConfig.class, AspectAnoConfiguration.class);
		RoleService roleService = context.getBean(RoleService.class);
		TRole role = new TRole();
		role.setNote("hello");
		role.setRoleName("world");
		roleService.addRole(role);
	}
}
