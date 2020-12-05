package top.wlz922.test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.wlz922.annoboot.GlobalTransactionConfig;
import top.wlz922.service.TransactionPropagationService;
import top.wlz922.test.config.AspectAnoForTransactionConfiguration;

public class TransactionPropagationServiceTest {
	private TransactionPropagationService service;

	@Before
	public void before() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				GlobalTransactionConfig.class, AspectAnoForTransactionConfiguration.class);
		service = context.getBean(TransactionPropagationService.class);
	}

	// 外围方法未开启事务
	@Test
	public void noTransactionExceptionRequiredRequiredTest() {
		service.noTransactionExceptionRequiredRequired();
	}

	@Test
	public void noTransactionRequiredRequiredExceptionTest() {
		service.noTransactionRequiredRequiredException();
	}

	// 外围方法开启事务
	@Test
	public void transactionExceptionRequiredRequiredTest() {
		service.transactionExceptionRequiredRequired();
	}

	@Test
	public void transactionRequiredRequiredExceptionTest() {
		service.transactionRequiredRequiredException();
	}

	@Test
	public void transactionRequiredRequiredCatchExceptionTest() {
		service.transactionRequiredRequiredCatchException();
	}
}
