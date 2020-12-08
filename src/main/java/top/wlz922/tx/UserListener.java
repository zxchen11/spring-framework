package top.wlz922.tx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class UserListener {

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void onUserAddEvent(AbstractCustomApplicationEvent<?> event) {
		event.process();
		log.info("用户新增成功，发送通知消息");
	}
}
