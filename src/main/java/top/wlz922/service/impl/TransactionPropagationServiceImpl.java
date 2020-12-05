package top.wlz922.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wlz922.bean.PropagationUser;
import top.wlz922.service.PropagationUserService;
import top.wlz922.service.TransactionPropagationService;

/**
 * @author Eddie
 */
@Service
public class TransactionPropagationServiceImpl implements TransactionPropagationService {
	@Autowired
	PropagationUserService userService;

	@Override
	public void noTransactionExceptionRequiredRequired() {
		userService.addRequired(new PropagationUser("张三"));
		userService.addRequired(new PropagationUser("李四"));
		throw new RuntimeException();
	}

	@Override
	public void noTransactionRequiredRequiredException() {
		userService.addRequired(new PropagationUser("张三"));
		userService.addRequiredException(new PropagationUser("李四"));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionExceptionRequiredRequired() {
		userService.addRequired(new PropagationUser("张三"));
		userService.addRequired(new PropagationUser("李四"));
		throw new RuntimeException();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionRequiredRequiredException() {
		userService.addRequired(new PropagationUser("张三"));
		userService.addRequiredException(new PropagationUser("李四"));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionRequiredRequiredCatchException() {
		userService.addRequired(new PropagationUser("张三"));
		try {
			userService.addRequiredException(new PropagationUser("李四"));
		} catch (Exception ignored) {

		}
	}
}
