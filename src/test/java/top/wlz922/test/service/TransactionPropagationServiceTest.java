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

	@Test
	public void noTransactionExceptionSupportsSupportsTest() {
		service.noTransactionExceptionSupportsSupports();
	}

	@Test
	public void noTransactionSupportsSupportsExceptionTest() {
		service.noTransactionSupportsSupportsException();
	}

	@Test
	public void transactionExceptionSupportsSupportsTest() {
		service.transactionExceptionSupportsSupports();
	}

	@Test
	public void transactionSupportsSupportsExceptionTest() {
		service.transactionSupportsSupportsException();
	}

	@Test
	public void transactionSupportsSupportsCatchExceptionTest() {
		service.transactionSupportsSupportsCatchException();
	}

	@Test
	public void noTransactionMandatoryMandatoryTest() {
		service.noTransactionMandatoryMandatory();
	}

	@Test
	public void transactionExceptionMandatoryMandatoryTest() {
		service.transactionExceptionMandatoryMandatory();
	}

	@Test
	public void transactionMandatoryMandatoryCatchExceptionTest() {
		service.transactionMandatoryMandatoryCatchException();
	}

	@Test
	public void noTransactionExceptionRequiresNewTest() {
		service.noTransactionExceptionRequiresNewRequiresNew();
	}

	@Test
	public void noTransactionRequiresNewExceptionTest() {
		service.noTransactionRequiresNewRequiresNewException();
	}

	@Test
	public void transactionExceptionRequiresNewTest() {
		service.transactionExceptionRequiresNewRequiresNew();
	}

	@Test
	public void transactionRequiresNewExceptionTest() {
		service.transactionRequiresNewRequiresNewException();
	}

	@Test
	public void transactionRequiresNewCatchExceptionTest() {
		service.transactionRequiresNewRequiresNewCatchException();
	}

	@Test
	public void noTransactionExceptionNotSupportedNotSupportedTest() {
		service.noTransactionExceptionNotSupportedNotSupported();
	}

	@Test
	public void noTransactionNotSupportedNotSupportedExceptionTest() {
		service.noTransactionNotSupportedNotSupportedException();
	}

	@Test
	public void transactionExceptionNotSupportedNotSupportedTest() {
		service.transactionExceptionNotSupportedNotSupported();
	}

	@Test
	public void transactionNotSupportedNotSupportedExceptionTest() {
		service.transactionNotSupportedNotSupportedException();
	}

	@Test
	public void noTransactionExceptionNeverNeverTest() {
		service.noTransactionExceptionNeverNever();
	}

	@Test
	public void noTransactionNeverNeverExceptionTest() {
		service.noTransactionNeverNeverException();
	}

	@Test
	public void transactionNeverNeverTest() {
		service.transactionNeverNever();
	}

	@Test
	public void noTransactionExceptionNestedNestedTest() {
		service.noTransactionExceptionNestedNested();
	}

	@Test
	public void noTransactionNestedNestedExceptionTest() {
		service.noTransactionNestedNestedException();
	}

	@Test
	public void transactionExceptionNestedNestedTest() {
		service.transactionExceptionNestedNested();
	}

	@Test
	public void transactionNestedNestedExceptionTest() {
		service.transactionNestedNestedException();
	}

	@Test
	public void transactionNestedNestedCatchExceptionTest() {
		service.transactionNestedNestedCatchException();
	}
}
