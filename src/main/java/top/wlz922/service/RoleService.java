package top.wlz922.service;

import top.wlz922.bean.TRole;

import java.util.List;

public interface RoleService {
	int addRole(TRole role);

	List<TRole> listRole();
}
