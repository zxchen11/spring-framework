package top.wlz922.dao;

import top.wlz922.bean.SystemUserCard;

public interface SystemUserCardDao {
	int deleteByPrimaryKey(Long id);

	int insert(SystemUserCard record);

	int insertSelective(SystemUserCard record);

	SystemUserCard selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SystemUserCard record);

	int updateByPrimaryKey(SystemUserCard record);

	SystemUserCard getUserCard(long userId);
}