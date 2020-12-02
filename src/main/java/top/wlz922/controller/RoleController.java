package top.wlz922.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wlz922.bean.ResponseModel;
import top.wlz922.bean.TRole;
import top.wlz922.service.RoleService;

import java.util.List;

@RestController
public class RoleController {
	@Autowired
	RoleService roleService;

	@GetMapping("/listRole")
	public ResponseModel<List<TRole>> listRole() {
		List<TRole> list = roleService.listRole();
		return new ResponseModel<>(200, "成功", list);
	}
}
