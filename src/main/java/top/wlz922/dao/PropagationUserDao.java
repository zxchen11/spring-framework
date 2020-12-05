package top.wlz922.dao;

import top.wlz922.bean.PropagationUser;

public interface PropagationUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(PropagationUser record);

    int insertSelective(PropagationUser record);

    PropagationUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PropagationUser record);

    int updateByPrimaryKey(PropagationUser record);
}