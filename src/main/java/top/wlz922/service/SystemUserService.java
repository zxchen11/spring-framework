package top.wlz922.service;

import top.wlz922.bean.SystemUserCardVo;

import java.util.List;

/**
 * @author Eddie
 */
public interface SystemUserService {
	SystemUserCardVo getUserCardVo(long userId);

	List<SystemUserCardVo> listUserCardVo();
}
