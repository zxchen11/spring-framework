package top.wlz922.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.wlz922.service.PropagationExampleService;

@Service
public class PropagationExampleServiceImpl implements PropagationExampleService {
	@Autowired
	PropagationExampleService propagationExampleService;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void methodA() throws InterruptedException {
		Thread.sleep(100);
		propagationExampleService.methodB();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
	@Override
	public void methodB() throws InterruptedException {
		Thread.sleep(100);
	}
}
