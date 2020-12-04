package top.wlz922.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.wlz922.bean.Goods;
import top.wlz922.dao.GoodsDao;
import top.wlz922.service.GoodsTransactionService;

/**
 * @author Eddie
 */
@Service
public class GoodsTransactionServiceImpl implements GoodsTransactionService {
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private GoodsTransactionService goodsService;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int addGoodsRequired(Goods goods) {
		goods.setGoodsName("addGoodsRequired");
		return goodsDao.insertSelective(goods);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int addGoodsRequiredException(Goods goods) {
		goods.setGoodsName("addGoodsRequiredException");
		goodsDao.insertSelective(goods);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public int addGoodsRequiredNew(Goods goods) {
		goods.setGoodsName("addGoodsRequiredNew");
		return goodsDao.insertSelective(goods);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public int addGoodsRequiredNewException(Goods goods) {
		goods.setGoodsName("addGoodsRequiredNewException");
		goodsDao.insertSelective(goods);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
	@Override
	public int addGoodsNested(Goods goods) {
		goods.setGoodsName("addGoodsNestead");
		return goodsDao.insertSelective(goods);
	}

	@Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
	@Override
	public int addGoodsNestedException(Goods goods) {
		goods.setGoodsName("addGoodsNesteadException");
		goodsDao.insertSelective(goods);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
	@Override
	public int addGoodsSupports(Goods goods) {
		goods.setGoodsName("addGoodsSupports");
		return goodsDao.insertSelective(goods);
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
	@Override
	public int addGoodsSupportsException(Goods goods) {
		goods.setGoodsName("addGoodsSupportsException");
		goodsDao.insertSelective(goods);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
	@Override
	public int addGoodsNotSupported(Goods goods) {
		goods.setGoodsName("addGoodsNotSupported");
		return goodsDao.insertSelective(goods);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
	@Override
	public int addGoodsNotSupportedException(Goods goods) {
		goods.setGoodsName("addGoodsNotSupportedException");
		goodsDao.insertSelective(goods);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	@Override
	public int addGoodsMandatory(Goods goods) {
		goods.setGoodsName("addGoodsMandatory");
		return goodsDao.insertSelective(goods);
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	@Override
	public int addGoodsMandatoryException(Goods goods) {
		goods.setGoodsName("addGoodsMandatoryException");
		goodsDao.insertSelective(goods);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.NEVER, rollbackFor = Exception.class)
	@Override
	public int addGoodsNever(Goods goods) {
		goods.setGoodsName("addGoodsNever");
		return goodsDao.insertSelective(goods);
	}

	@Transactional(propagation = Propagation.NEVER, rollbackFor = Exception.class)
	@Override
	public int addGoodsNeverException(Goods goods) {
		goods.setGoodsName("addGoodsNeverException");
		goodsDao.insertSelective(goods);
		throw new RuntimeException();
	}

	/**
	 * 3.1 外围方法不开启事务、内部方法开启事务、外围方法抛出异常
	 */
	@Override
	public int addGoodsOuterNoTransactionException(Goods goods) {
		goods.setGoodsName("addGoodsOuterNoTransaction");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsRequired(goods);
		throw new RuntimeException();
	}

	@Override
	public int addGoodsOuterNoTransactionInnerException(Goods goods) {
		goods.setGoodsName("addGoodsOuterNoTransactionInnerException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsRequiredException(goods);
		return 0;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int addGoodsOuterExceptionTest(Goods goods) {
		goods.setGoodsName("addGoodsOuterNoTransaction");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsRequired(goods);
		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public int addGoodsInnerExceptionTest(Goods goods) {
		goods.setGoodsName("addGoodsOuterNoTransactionInnerException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsRequiredException(goods);
		return 0;
	}

	@Override
	public int addGoodsSupportsOuterNoTransactionExceptionTest(Goods goods) {
		goods.setGoodsName("addGoodsSupportsOuterNoTransactionExceptionTest");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsSupports(goods);
		throw new RuntimeException();
	}

	@Override
	public int addGoodsSupportsOuterNoTransactionInnerExceptionTest(Goods goods) {
		goods.setGoodsName("addGoodsOuterNoTransactionInnerException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsSupportsException(goods);
		return 0;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addGoodsSupportsOuterExceptionTest(Goods goods) {
		goods.setGoodsName("addGoodsSupportsOuterExceptionTest");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsSupports(goods);
		throw new RuntimeException();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addGoodsSupportsOuterInnerExceptionTest(Goods goods) {
		goods.setGoodsName("addGoodsSupportsOuterInnerExceptionTest");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsSupportsException(goods);
		return 0;
	}

	@Override
	public int addGoodsMandatoryOuterNoTransactionExceptionTest(Goods goods) {
		goods.setGoodsName("addGoodsMandatoryOuterNoTransactionExceptionTest");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsMandatory(goods);
		throw new RuntimeException();
	}

	@Override
	public int addGoodsMandatoryOuterNoTransactionInnerException(Goods goods) {
		goods.setGoodsName("addGoodsMandatoryOuterNoTransactionInnerException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsMandatoryException(goods);
		return 0;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addGoodsMandatoryOuterException(Goods goods) {
		goods.setGoodsName("addGoodsMandatoryOuterException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsMandatory(goods);
		throw new RuntimeException();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addGoodsMandatoryInnerException(Goods goods) {
		goods.setGoodsName("addGoodsMandatoryInnerException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsMandatoryException(goods);
		return 0;
	}

	@Override
	public int addGoodsRequiredNewOuterNoTransactionException(Goods goods) {
		goods.setGoodsName("addGoodsRequiredNewOuterNoTransactionException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsRequiredNew(goods);
		throw new RuntimeException();
	}

	@Override
	public int addGoodsRequiredNewOuterNoTransactionInnerException(Goods goods) {
		goods.setGoodsName("addGoodsRequiredNewOuterNoTransactionInnerException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsRequiredNewException(goods);
		return 0;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addGoodsRequiredNewOuterException(Goods goods) {
		goods.setGoodsName("addGoodsRequiredNewOuterException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsRequiredNew(goods);
		throw new RuntimeException();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addGoodsRequiredNewInnerException(Goods goods) {
		goods.setGoodsName("addGoodsRequiredNewInnerException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsRequiredNewException(goods);
		return 0;
	}

	@Override
	public int addGoodsNotSupportedOuterNoTransactionException(Goods goods) {
		goods.setGoodsName("addGoodsNotSupportedOuterNoTransactionException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsNotSupported(goods);
		throw new RuntimeException();
	}

	@Override
	public int addGoodsNotSupportedOuterNoTransactionInnerException(Goods goods) {
		goods.setGoodsName("addGoodsNotSupportedOuterNoTransactionInnerException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsNotSupportedException(goods);
		return 0;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addGoodsNotSupportedOuterException(Goods goods) {
		goods.setGoodsName("addGoodsNotSupportedOuterException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsNotSupported(goods);
		throw new RuntimeException();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addGoodsNotSupportedInnerExceptionTest(Goods goods) {
		goods.setGoodsName("addGoodsNotSupportedInnerExceptionTest");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsNotSupportedException(goods);
		return 0;
	}

	@Override
	public int addGoodsNeverOuterNoTransactionException(Goods goods) {
		goods.setGoodsName("addGoodsNeverOuterNoTransactionException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsNever(goods);
		throw new RuntimeException();
	}

	@Override
	public int addGoodsNeverOuterNoTransactionInnerException(Goods goods) {
		goods.setGoodsName("addGoodsNeverOuterNoTransactionInnerException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsNeverException(goods);
		return 0;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addGoodsNeverOuterException(Goods goods) {
		goods.setGoodsName("addGoodsNeverOuterException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsNever(goods);
		throw new RuntimeException();
	}

	@Override
	public int addGoodsNestedOuterNoTransactionException(Goods goods) {
		goods.setGoodsName("addGoodsNestedOuterNoTransactionException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsNested(goods);
		throw new RuntimeException();
	}

	@Override
	public int addGoodsNestedOuterNoTransactionInnerException(Goods goods) {
		goods.setGoodsName("addGoodsNestedOuterNoTransactionInnerException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsNestedException(goods);
		return 0;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addGoodsNestedOuterException(Goods goods) {
		goods.setGoodsName("addGoodsNestedOuterException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsNested(goods);
		throw new RuntimeException();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addGoodsNestedOuterInnerException(Goods goods) {
		goods.setGoodsName("addGoodsNestedOuterInnerException");
		goodsDao.insertSelective(goods);
		goodsService.addGoodsNestedException(goods);
		return 0;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addGoodsNestedOuterExceptionCatch(Goods goods) {
		goods.setGoodsName("addGoodsNestedOuterException");
		goodsDao.insertSelective(goods);
		try {
			goodsService.addGoodsNestedException(goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
}
