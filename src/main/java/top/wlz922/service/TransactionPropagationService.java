package top.wlz922.service;

/**
 * @author Eddie
 */
public interface TransactionPropagationService {
	/**
	 * 外围方法未开启事务
	 */
	void noTransactionExceptionRequiredRequired();

	void noTransactionRequiredRequiredException();

	/**
	 * 外围方法开启事务
	 */
	void transactionExceptionRequiredRequired();

	void transactionRequiredRequiredException();

	void transactionRequiredRequiredCatchException();
}
