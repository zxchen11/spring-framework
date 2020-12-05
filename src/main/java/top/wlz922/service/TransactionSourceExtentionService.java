package top.wlz922.service;

import top.wlz922.bean.PropagationUser;

public interface TransactionSourceExtentionService {
	int addUserRequiredWithTransactionSynchronization(PropagationUser user);

	int addUserRequiredWithApplicationEventPublisher(PropagationUser user);
}
