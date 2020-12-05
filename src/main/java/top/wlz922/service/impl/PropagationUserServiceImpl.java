package top.wlz922.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.wlz922.bean.PropagationUser;
import top.wlz922.dao.PropagationUserDao;
import top.wlz922.service.PropagationUserService;

@Service
public class PropagationUserServiceImpl implements PropagationUserService {
	@Autowired
	PropagationUserDao userDao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void addRequired(PropagationUser user) {
		userDao.insertSelective(user);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void addRequiredException(PropagationUser user) {
		userDao.insertSelective(user);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void addRequiredNew(PropagationUser user) {
		userDao.insertSelective(user);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void addRequiredNewException(PropagationUser user) {
		userDao.insertSelective(user);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
	@Override
	public void addSupports(PropagationUser user) {
		userDao.insertSelective(user);
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
	@Override
	public void addSupportsException(PropagationUser user) {
		userDao.insertSelective(user);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
	@Override
	public void addNotSupported(PropagationUser user) {
		userDao.insertSelective(user);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
	@Override
	public void addNotSupportedException(PropagationUser user) {
		userDao.insertSelective(user);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	@Override
	public void addMadatory(PropagationUser user) {
		userDao.insertSelective(user);
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	@Override
	public void addMadatoryException(PropagationUser user) {
		userDao.insertSelective(user);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.NEVER, rollbackFor = Exception.class)
	@Override
	public void addNever(PropagationUser user) {
		userDao.insertSelective(user);
	}

	@Transactional(propagation = Propagation.NEVER, rollbackFor = Exception.class)
	@Override
	public void addNeverException(PropagationUser user) {
		userDao.insertSelective(user);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
	@Override
	public void addNestead(PropagationUser user) {
		userDao.insertSelective(user);
	}

	@Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
	@Override
	public void addNesteadException(PropagationUser user) {
		userDao.insertSelective(user);
		throw new RuntimeException();
	}
}
