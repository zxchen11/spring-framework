package top.wlz922.service;

import top.wlz922.bean.Goods;

/**
 * @author Eddie
 */
public interface GoodsTransactionService {
	int addGoodsRequired(Goods goods);

	int addGoodsRequiredException(Goods goods);

	int addGoodsRequiredNew(Goods goods);

	int addGoodsRequiredNewException(Goods goods);

	int addGoodsNested(Goods goods);

	int addGoodsNestedException(Goods goods);

	int addGoodsSupports(Goods goods);

	int addGoodsSupportsException(Goods goods);

	int addGoodsNotSupported(Goods goods);

	int addGoodsNotSupportedException(Goods goods);

	int addGoodsMandatory(Goods goods);

	int addGoodsMandatoryException(Goods goods);

	int addGoodsNever(Goods goods);

	int addGoodsNeverException(Goods goods);

	int addGoodsOuterNoTransactionException(Goods goods);

	int addGoodsOuterNoTransactionInnerException(Goods goods);

	int addGoodsOuterExceptionTest(Goods goods);

	int addGoodsInnerExceptionTest(Goods goods);

	int addGoodsSupportsOuterNoTransactionExceptionTest(Goods goods);

	int addGoodsSupportsOuterNoTransactionInnerExceptionTest(Goods goods);

	int addGoodsSupportsOuterExceptionTest(Goods goods);

	int addGoodsSupportsOuterInnerExceptionTest(Goods goods);

	int addGoodsMandatoryOuterNoTransactionExceptionTest(Goods goods);

	int addGoodsMandatoryOuterNoTransactionInnerException(Goods goods);

	int addGoodsMandatoryOuterException(Goods goods);

	int addGoodsMandatoryInnerException(Goods goods);

	int addGoodsRequiredNewOuterNoTransactionException(Goods goods);

	int addGoodsRequiredNewOuterNoTransactionInnerException(Goods goods);

	int addGoodsRequiredNewOuterException(Goods goods);

	int addGoodsRequiredNewInnerException(Goods goods);

	int addGoodsNotSupportedOuterNoTransactionException(Goods goods);

	int addGoodsNotSupportedOuterNoTransactionInnerException(Goods goods);

	int addGoodsNotSupportedOuterException(Goods goods);

	int addGoodsNotSupportedInnerExceptionTest(Goods goods);

	int addGoodsNeverOuterNoTransactionException(Goods goods);

	int addGoodsNeverOuterNoTransactionInnerException(Goods goods);

	int addGoodsNeverOuterException(Goods goods);

	int addGoodsNestedOuterNoTransactionException(Goods goods);

	int addGoodsNestedOuterNoTransactionInnerException(Goods goods);

	int addGoodsNestedOuterException(Goods goods);

	int addGoodsNestedOuterInnerException(Goods goods);

	int addGoodsNestedOuterExceptionCatch(Goods goods);
}
