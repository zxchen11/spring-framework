package top.wlz922.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	@Override
	public SystemUserCardVo getUserCardVo(long userId) {
		SystemUserCardVo userCardVo = systemUserDao.getUserCardVo(userId);

		return userCardVo;
	}

	@Override
	public List<SystemUserCardVo> listUserCardVo() {
		List<SystemUserCardVo> list = systemUserDao.listUserCardVo();

		return list;
	}
}
