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

	@Override
	public void noTransactionExceptionSupportsSupports() {
		userService.addSupports(new PropagationUser("张三"));
		userService.addSupports(new PropagationUser("李四"));
		throw new RuntimeException();
	}

	@Override
	public void noTransactionSupportsSupportsException() {
		userService.addSupports(new PropagationUser("张三"));
		userService.addSupportsException(new PropagationUser("李四"));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionExceptionSupportsSupports() {
		userService.addSupports(new PropagationUser("张三"));
		userService.addSupports(new PropagationUser("李四"));
		throw new RuntimeException();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionSupportsSupportsException() {
		userService.addSupports(new PropagationUser("张三"));
		userService.addSupportsException(new PropagationUser("李四"));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionSupportsSupportsCatchException() {
		userService.addRequired(new PropagationUser("张三"));
		try {
			userService.addRequiredException(new PropagationUser("李四"));
		} catch (Exception ignored) {
		}
	}

	@Override
	public void noTransactionMandatoryMandatory() {
		userService.addMandatory(new PropagationUser("张三"));
		userService.addMandatory(new PropagationUser("李四"));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionExceptionMandatoryMandatory() {
		userService.addMandatory(new PropagationUser("张三"));
		userService.addMandatory(new PropagationUser("李四"));
		throw new RuntimeException();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionMandatoryMandatoryCatchException() {
		userService.addMandatory(new PropagationUser("张三"));
		try {
			userService.addMandatoryException(new PropagationUser("李四"));
		} catch (Exception ignored) {
		}
	}

	@Override
	public void noTransactionExceptionRequiresNewRequiresNew() {
		userService.addRequiredNew(new PropagationUser("张三"));
		userService.addRequiredNew(new PropagationUser("李四"));
		throw new RuntimeException();
	}

	@Override
	public void noTransactionRequiresNewRequiresNewException() {
		userService.addRequiredNew(new PropagationUser("张三"));
		userService.addRequiredNewException(new PropagationUser("李四"));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionExceptionRequiresNewRequiresNew() {
		userService.addRequiredNew(new PropagationUser("张三"));
		userService.addRequiredNew(new PropagationUser("李四"));
		throw new RuntimeException();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionRequiresNewRequiresNewException() {
		userService.addRequiredNew(new PropagationUser("张三"));
		userService.addRequiredNewException(new PropagationUser("李四"));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionRequiresNewRequiresNewCatchException() {
		userService.addRequiredNew(new PropagationUser("张三"));
		try {
			userService.addRequiredNewException(new PropagationUser("李四"));
		} catch (Exception ignored) {
		}
	}

	@Override
	public void noTransactionExceptionNotSupportedNotSupported() {
		userService.addNotSupported(new PropagationUser("张三"));
		userService.addNotSupported(new PropagationUser("李四"));
		throw new RuntimeException();
	}

	@Override
	public void noTransactionNotSupportedNotSupportedException() {
		userService.addNotSupported(new PropagationUser("张三"));
		userService.addNotSupportedException(new PropagationUser("李四"));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionExceptionNotSupportedNotSupported() {
		userService.addNotSupported(new PropagationUser("张三"));
		userService.addNotSupported(new PropagationUser("李四"));
		throw new RuntimeException();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionNotSupportedNotSupportedException() {
		userService.addNotSupported(new PropagationUser("张三"));
		userService.addNotSupportedException(new PropagationUser("李四"));
	}

	@Override
	public void noTransactionExceptionNeverNever() {
		userService.addNever(new PropagationUser("张三"));
		userService.addNever(new PropagationUser("李四"));
		throw new RuntimeException();
	}

	@Override
	public void noTransactionNeverNeverException() {
		userService.addNever(new PropagationUser("张三"));
		userService.addNeverException(new PropagationUser("李四"));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionNeverNever() {
		userService.addNever(new PropagationUser("张三"));
		userService.addNever(new PropagationUser("李四"));
	}

	@Override
	public void noTransactionExceptionNestedNested() {
		userService.addNestead(new PropagationUser("张三"));
		userService.addNestead(new PropagationUser("李四"));
		throw new RuntimeException();
	}

	@Override
	public void noTransactionNestedNestedException() {
		userService.addNestead(new PropagationUser("张三"));
		userService.addNesteadException(new PropagationUser("李四"));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionExceptionNestedNested() {
		userService.addNestead(new PropagationUser("张三"));
		userService.addNestead(new PropagationUser("李四"));
		throw new RuntimeException();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionNestedNestedException() {
		userService.addNestead(new PropagationUser("张三"));
		userService.addNesteadException(new PropagationUser("李四"));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void transactionNestedNestedCatchException() {
		userService.addNestead(new PropagationUser("张三"));
		try {
			userService.addNesteadException(new PropagationUser("李四"));
		} catch (Exception ignore) {
		}
	}
}
