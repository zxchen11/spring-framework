package top.wlz922.service.impl;

import org.springframework.stereotype.Service;
import top.wlz922.service.HomeService;

import java.util.Map;

@Service
public class HomeServiceImpl implements HomeService {
	@Override
	public Map<String, Object> serviceMirror(Map<String, Object> param) {
		return param;
	}
}
