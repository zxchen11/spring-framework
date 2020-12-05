package top.wlz922.service;

/**
 * @author Eddie
 */
public interface TransactionPropagationService {
	/**
	 * REQUIRED
	 */
	void noTransactionExceptionRequiredRequired();

	void noTransactionRequiredRequiredException();

	void transactionExceptionRequiredRequired();

	void transactionRequiredRequiredException();

	void transactionRequiredRequiredCatchException();

	/**
	 * SUPPORTS
	 */
	void noTransactionExceptionSupportsSupports();

	void noTransactionSupportsSupportsException();

	void transactionExceptionSupportsSupports();

	void transactionSupportsSupportsException();

	void transactionSupportsSupportsCatchException();

	/**
	 * MANDATORY
	 */
	void noTransactionMandatoryMandatory();

	void transactionExceptionMandatoryMandatory();

	void transactionMandatoryMandatoryCatchException();

	/**
	 * REQUIRES_NEW
	 */
	void noTransactionExceptionRequiresNewRequiresNew();

	void noTransactionRequiresNewRequiresNewException();

	void transactionExceptionRequiresNewRequiresNew();

	void transactionRequiresNewRequiresNewException();

	void transactionRequiresNewRequiresNewCatchException();

	/**
	 * NOT_SUPPORTED
	 */
	void noTransactionExceptionNotSupportedNotSupported();

	void noTransactionNotSupportedNotSupportedException();

	void transactionExceptionNotSupportedNotSupported();

	void transactionNotSupportedNotSupportedException();

	/**
	 * NEVER
	 */
	void noTransactionExceptionNeverNever();

	void noTransactionNeverNeverException();

	void transactionNeverNever();

	/**
	 * NESTED
	 */
	void noTransactionExceptionNestedNested();

	void noTransactionNestedNestedException();

	void transactionExceptionNestedNested();

	void transactionNestedNestedException();

	void transactionNestedNestedCatchException();
}
