package top.wlz922.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wlz922.bean.SystemUserCardVo;
import top.wlz922.dao.SystemUserDao;
import top.wlz922.service.SystemUserService;

import java.util.List;

/**
 * @author Eddie
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {
	@Autowired
	SystemUserDao systemUserDao;

	@Transactional
	@Override
	public SystemUserCardVo getUserCardVo(long userId) {
		SystemUserCardVo userCardVo = systemUserDao.getUserCardVo(userId);

		return userCardVo;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addUserCardVo(SystemUserCardVo userCardVo) {
		return systemUserDao.insertSelective(userCardVo);
	}

	@Override
	public List<SystemUserCardVo> listUserCardVo() {
		List<SystemUserCardVo> list = systemUserDao.listUserCardVo();

		return list;
	}
}
