package top.wlz922.service;

import top.wlz922.bean.PropagationUser;

/**
 * @author Eddie
 */
public interface TransactionSourceExtentionService {
	int addUserRequiredWithTransactionSynchronization(PropagationUser user);

	int addUserRequiredWithApplicationEventPublisher(PropagationUser user);

	int addUserRequiredWithApplicationEventPublisher2(PropagationUser user);
}
