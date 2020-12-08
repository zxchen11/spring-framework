package top.wlz922.test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.wlz922.annoboot.GlobalTransactionConfig;
import top.wlz922.bean.PropagationUser;
import top.wlz922.service.TransactionSourceExtentionService;
import top.wlz922.test.config.AspectAnoForTransactionConfiguration;
import top.wlz922.test.config.TransactionSourceExtentionServiceConfiguration;

public class TransactionSourceExtentionServiceTest {
	private TransactionSourceExtentionService service;

	@Before
	public void before() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				GlobalTransactionConfig.class, AspectAnoForTransactionConfiguration.class,
				TransactionSourceExtentionServiceConfiguration.class);
		service = context.getBean(TransactionSourceExtentionService.class);
	}

	@Test
	public void addUserRequiredWithTransactionSynchronizationTest() {
		service.addUserRequiredWithTransactionSynchronization(new PropagationUser("Eddie"));
	}

	@Test
	public void addUserRequiredWithApplicationEventPublisherTest() {
		service.addUserRequiredWithApplicationEventPublisher(new PropagationUser("Eddie"));
	}

	@Test
	public void addUserRequiredWithApplicationEventPublisher2Test() {
		service.addUserRequiredWithApplicationEventPublisher2(new PropagationUser("Eddie"));
	}
}
