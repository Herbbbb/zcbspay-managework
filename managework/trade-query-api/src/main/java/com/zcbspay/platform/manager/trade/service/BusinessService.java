package com.zcbspay.platform.manager.trade.service;

import java.util.List;

public interface BusinessService {
	/**
	 * 测试方法
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年3月2日 上午11:34:38 
	 * @version v1.0
	 */
	public String sayhello();
	/**
	 * 获取全部交易类型
	 * @author: zhangshd
	 * @return Object
	 * @date: 2017年3月2日 下午2:20:33 
	 * @version v1.0
	 */
	public List<?> getAllBusiness();
}
