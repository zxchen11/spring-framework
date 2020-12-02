package top.wlz922.dao;

import top.wlz922.bean.TRole;

import java.util.List;

public interface TRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);

	List<TRole> listRole();
}