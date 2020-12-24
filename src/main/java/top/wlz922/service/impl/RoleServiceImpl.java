package top.wlz922.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import top.wlz922.bean.TRole;
import top.wlz922.dao.TRoleDao;
import top.wlz922.service.RoleService;

import java.util.List;

// @Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	TRoleDao roleDao;

	@Transactional
	@Override
	public int addRole(TRole role) {
		return roleDao.insertSelective(role);
	}

	@Override
	public List<TRole> listRole() {
		return roleDao.listRole();
	}
}
