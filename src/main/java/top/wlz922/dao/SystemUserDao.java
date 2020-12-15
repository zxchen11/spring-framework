package top.wlz922.dao;

import top.wlz922.bean.SystemUser;
import top.wlz922.bean.SystemUserCardVo;

import java.util.List;

public interface SystemUserDao {
	int deleteByPrimaryKey(Long id);

	int insert(SystemUser record);

	int insertSelective(SystemUser record);

	SystemUser selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SystemUser record);

	int updateByPrimaryKey(SystemUser record);

	SystemUserCardVo getUserCardVo(long userId);

	List<SystemUserCardVo> listUserCardVo();

}