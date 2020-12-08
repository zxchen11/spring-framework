package top.wlz922.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import top.wlz922.bean.PropagationUser;
import top.wlz922.dao.PropagationUserDao;
import top.wlz922.service.TransactionSourceExtentionService;
import top.wlz922.tx.UserAddTransactionEvent;

/**
 * @author Eddie
 */
@Slf4j
@Service
public class TransactionSourceExtentionServiceImpl implements TransactionSourceExtentionService {
	@Autowired
	PropagationUserDao userDao;

	@Autowired
	ApplicationEventPublisher eventPublisher;

	@Transactional
	@Override
	public int addUserRequiredWithTransactionSynchronization(PropagationUser user) {
		userDao.insertSelective(user);
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
			@Override
			public void afterCommit() {
				log.info("事务成功提交了");
			}
		});
		return 1;
	}

	@Transactional
	@Override
	public int addUserRequiredWithApplicationEventPublisher2(PropagationUser user) {
		userDao.insertSelective(user);
		eventPublisher.publishEvent(new UserAddEvent(user));
		return 1;
	}

	static class UserAddEvent extends ApplicationEvent {
		public UserAddEvent(PropagationUser user) {
			super(user);
		}
	}

	@Component
	static class UserEventListener {
		@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
		public void processUserAddEvent(UserAddEvent user) {
			log.info("事务提交后用户信息处理，用户信息:{}", user.getSource());
		}
	}


	@Transactional
	@Override
	public int addUserRequiredWithApplicationEventPublisher(PropagationUser user) {
		userDao.insertSelective(user);
		eventPublisher.publishEvent(new UserAddTransactionEvent(user));
		return 1;
	}
}
