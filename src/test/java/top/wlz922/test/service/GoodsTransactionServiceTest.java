package top.wlz922.test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.wlz922.annoboot.GlobalTransactionConfig;
import top.wlz922.bean.Goods;
import top.wlz922.service.GoodsTransactionService;
import top.wlz922.test.config.AspectAnoForTransactionConfiguration;

public class GoodsTransactionServiceTest {
	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
			GlobalTransactionConfig.class, AspectAnoForTransactionConfiguration.class);
	private Goods goods = new Goods();
	private GoodsTransactionService goodsService;

	@Before
	public void before() {
		goodsService = context.getBean(GoodsTransactionService.class);
	}

	@Test
	public void addGoodsOuterNoTransactionExceptionTest() {
		goodsService.addGoodsOuterNoTransactionException(goods);
	}

	@Test
	public void addGoodsOuterNoTransactionInnerExceptionTest() {
		goodsService.addGoodsOuterNoTransactionInnerException(goods);
	}

	@Test
	public void addGoodsOuterExceptionTest() {
		goodsService.addGoodsOuterExceptionTest(goods);
	}

	@Test
	public void addGoodsInnerExceptionTest() {
		goodsService.addGoodsInnerExceptionTest(goods);
	}

	@Test
	public void addGoodsSupportsOuterNoTransactionExceptionTest() {
		goodsService.addGoodsSupportsOuterNoTransactionExceptionTest(goods);
	}

	@Test
	public void addGoodsSupportsOuterNoTransactionInnerExceptionTest() {
		goodsService.addGoodsSupportsOuterNoTransactionInnerExceptionTest(goods);
	}

	@Test
	public void addGoodsSupportsOuterExceptionTest() {
		goodsService.addGoodsSupportsOuterExceptionTest(goods);
	}

	@Test
	public void addGoodsSupportsOuterInnerExceptionTest() {
		goodsService.addGoodsSupportsOuterInnerExceptionTest(goods);
	}

	@Test
	public void addGoodsMandatoryOuterNoTransactionExceptionTest() {
		goodsService.addGoodsMandatoryOuterNoTransactionExceptionTest(goods);
	}

	@Test
	public void addGoodsMandatoryOuterNoTransactionInnerExceptionTest() {
		goodsService.addGoodsMandatoryOuterNoTransactionInnerException(goods);
	}

	@Test
	public void addGoodsMandatoryOuterExceptionTest() {
		goodsService.addGoodsMandatoryOuterException(goods);
	}

	@Test
	public void addGoodsMandatoryInnerExceptionTest() {
		goodsService.addGoodsMandatoryInnerException(goods);
	}

	@Test
	public void addGoodsRequiredNewOuterNoTransactionExceptionTest() {
		goodsService.addGoodsRequiredNewOuterNoTransactionException(goods);
	}

	@Test
	public void addGoodsRequiredNewOuterNoTransactionInnerExceptionTest() {
		goodsService.addGoodsRequiredNewOuterNoTransactionInnerException(goods);
	}

	@Test
	public void addGoodsRequiredNewOuterExceptionTest() {
		goodsService.addGoodsRequiredNewOuterException(goods);
	}

	@Test
	public void addGoodsRequiredNewInnerExceptionTest() {
		goodsService.addGoodsRequiredNewInnerException(goods);
	}

	@Test
	public void addGoodsNotSupportedOuterNoTransactionExceptionTest() {
		goodsService.addGoodsNotSupportedOuterNoTransactionException(goods);
	}

	@Test
	public void addGoodsNotSupportedOuterNoTransactionInnerExceptionTest() {
		goodsService.addGoodsNotSupportedOuterNoTransactionInnerException(goods);
	}

	@Test
	public void addGoodsNotSupportedOuterExceptionTest() {
		goodsService.addGoodsNotSupportedOuterException(goods);
	}

	@Test
	public void addGoodsNotSupportedInnerExceptionTest() {
		goodsService.addGoodsNotSupportedInnerExceptionTest(goods);
	}

	@Test
	public void addGoodsNeverOuterNoTransactionExceptionTest() {
		goodsService.addGoodsNeverOuterNoTransactionException(goods);
	}

	@Test
	public void addGoodsNeverOuterNoTransactionInnerExceptionTest() {
		goodsService.addGoodsNeverOuterNoTransactionInnerException(goods);
	}

	@Test
	public void addGoodsNeverOuterExceptionTest() {
		goodsService.addGoodsNeverOuterException(goods);
	}

	@Test
	public void addGoodsNestedOuterNoTransactionExceptionTest() {
		goodsService.addGoodsNestedOuterNoTransactionException(goods);
	}

	@Test
	public void addGoodsNestedOuterNoTransactionInnerExceptionTest() {
		goodsService.addGoodsNestedOuterNoTransactionInnerException(goods);
	}

	@Test
	public void addGoodsNestedOuterExceptionTest() {
		goodsService.addGoodsNestedOuterException(goods);
	}

	@Test
	public void addGoodsNestedOuterInnerExceptionTest() {
		goodsService.addGoodsNestedOuterInnerException(goods);
	}

	@Test
	public void addGoodsNestedOuterExceptionCatchTest() {
		goodsService.addGoodsNestedOuterExceptionCatch(goods);
	}
}
