package top.wlz922.tx;

import lombok.extern.slf4j.Slf4j;
import top.wlz922.bean.PropagationUser;

@Slf4j
public class UserAddTransactionEvent extends AbstractCustomApplicationEvent<PropagationUser> {
	private PropagationUser user;
	public UserAddTransactionEvent(PropagationUser user) {
		super(user);
		this.user = user;
	}

	@Override
	void process() {
		log.info(source.toString());
	}
}
