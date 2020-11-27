package top.wlz922.cyclic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CyclicOrderServiceImpl implements CyclicOrderService {
	@Autowired
	private CyclicGoodsService cyclicGoodsService;

	@Override
	public CyclicGoodsService getCyclicGoodsService() {
		return cyclicGoodsService;
	}
}
