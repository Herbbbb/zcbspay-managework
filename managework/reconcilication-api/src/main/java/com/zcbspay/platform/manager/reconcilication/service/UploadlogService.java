package com.zcbspay.platform.manager.reconcilication.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.reconcilication.bean.ChnTxnBean;

public interface UploadlogService {
	/**
	 * 任务分页查询（新增任务，开始对账）
	 * @author: zhangshd
	 * @return Map<String, Object>
	 * @date: 2017年3月1日 下午4:22:35
	 * @version v1.0
	 */
	public Map<String, Object> findProcessByPage(Map<String, Object> variables, String page, String rows);

	/**
	 * 保存任务
	 * @author: zhangshd
	 * @param instiid
	 * @return Object
	 * @date: 2017年3月1日 下午4:49:24
	 * @version v1.0
	 */
	public List<?> saveProcess(String instiid);
	/**
	 * 开始执行核对
	 * @author: zhangshd
	 * @param filestartid
	 * @return Object
	 * @date: 2017年3月1日 下午4:56:23 
	 * @version v1.0
	 */
	public List<?> startCheckFile(String filestartid);
	/**
	 * 查询对账差错的记录
	 * @author: zhangshd
	 * @param filestartid
	 * @return List<?>
	 * @date: 2017年3月1日 下午5:04:13 
	 * @version v1.0
	 */
	public Map<String, Object> queryFail(Map<String, Object> variables, String page, String rows);
	/**
	 * 查询对账成功的记录
	 * @author: zhangshd
	 * @param filestartid
	 * @return List<?>
	 * @date: 2017年3月1日 下午5:04:13 
	 * @version v1.0
	 */
	public Map<String, Object> querySuccess(Map<String, Object> variables, String page, String rows);
	/**
	 * 批量导入
	 * @author: zhangshd
	 * @param list void
	 * @date: 2017年3月28日 下午7:40:41 
	 * @version v1.0
	 * @return 
	 */
	public String importBatch(List<ChnTxnBean> list);
}
