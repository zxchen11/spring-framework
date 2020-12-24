package top.wlz922.service.impl;

import org.springframework.stereotype.Service;
import top.wlz922.bean.TRole;

@Service
public class RoleServiceSonImpl extends RoleServiceImpl{
	@Override
	public int addRole(TRole role) {
		final int i = roleDao.insertSelective(role);
		throw new RuntimeException();
	}
}
