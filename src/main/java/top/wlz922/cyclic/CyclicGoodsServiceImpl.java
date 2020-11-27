package top.wlz922.cyclic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CyclicGoodsServiceImpl implements CyclicGoodsService {
	@Autowired
	private CyclicOrderService cyclicOrderService;

	@Override
	public CyclicOrderService getCyclicOrderService() {
		return cyclicOrderService;
	}
}
