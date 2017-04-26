package com.zcbspay.platform.manager.business.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.business.bean.RouteConfigBean;
import com.zcbspay.platform.manager.dao.BaseDAO;

public interface RouteConfigDao extends BaseDAO<String>{
	/**
	 * 查询路由配置
	 * @author: zhangshd
	 * @param routeBean
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年3月10日 下午1:49:40 
	 * @version v1.0
	 */
	public Map<String, Object> queryRouteConfig(RouteConfigBean routeBean, String page, String rows);
	/**
	 * 查询发卡行对应的银行代码
	 * @author: zhangshd
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午1:56:33 
	 * @version v1.0
	 */
	public List<Map<String, Object>> getAllBank();
	/**
	 * 交易渠道查询
	 * @author: zhangshd
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:11:33 
	 * @version v1.0
	 */
	public List<Map<String, Object>> queryChnlcode();
	/**
	 * 得到所有的交易类型
	 * @author: zhangshd
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:29:48 
	 * @version v1.0
	 */
	public List<Map<String, Object>> queryAllBusicode();
	/**
	 * 得到所有的路由版本
	 * @author: zhangshd
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:34:18 
	 * @version v1.0
	 */
	public List<Map<String, Object>> queryAllRoutver();
	/**
	 * 查询一条路由配置信息
	 * @author: zhangshd
	 * @param rid
	 * @return List<?>
	 * @date: 2017年3月10日 下午2:38:27 
	 * @version v1.0
	 */
	public List<?> queryOneRouteConfig(String rid);
	/**
	 * 根据t_route_configde的主键查询此记录包含的发卡行
	 * @author: zhangshd
	 * @param rid
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:41:03 
	 * @version v1.0
	 */
	public List<Map<String, Object>> queryContainBank(String rid);
	/**
	 * 根据t_route_configde的主键查询此记录包含的卡种类
	 * @author: zhangshd
	 * @param rid
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:44:24 
	 * @version v1.0
	 */
	public List<Map<String, Object>> queryContainCardtype(String rid);
	/**
	 * 
	 * @author: zhangshd
	 * @param rid
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:49:30 
	 * @version v1.0
	 */
	public List<Map<String, Object>> queryContainBusicode(String rid);
	/**
	 * 修改路由配置信息
	 * @author: zhangshd
	 * @param routeConfigBean
	 * @param bankcodelist
	 * @param busicodelist
	 * @param cradtypelist
	 * @return String
	 * @date: 2017年3月10日 下午2:59:40 
	 * @version v1.0
	 */
	public String updateOneRouteConfig(RouteConfigBean routeConfigBean, List<String> bankcodelist,
			List<String> busicodelist, List<String> cradtypelist);
	/**
	 * 增加一条路由配置信息
	 * @author: zhangshd
	 * @param routeConfigBean
	 * @param bankcodelist
	 * @param busicodelist
	 * @param cradtypelist
	 * @return String
	 * @date: 2017年3月10日 下午3:06:09 
	 * @version v1.0
	 */
	public String addRouteConfig(RouteConfigBean routeConfigBean, List<String> bankcodelist, List<String> busicodelist,
			List<String> cradtypelist);
	/**
	 * 删除一条路由配置信息
	 * @author: zhangshd
	 * @param routid
	 * @param upuserId
	 * @return String
	 * @date: 2017年3月10日 下午3:40:14 
	 * @version v1.0
	 */
	public String deleteRouteConfig(String routid, Long upuserId);
	/**
	 * 开启路由配置
	 * @author: zhangshd
	 * @param routid
	 * @param upuserId
	 * @return String
	 * @date: 2017年3月10日 下午3:43:48 
	 * @version v1.0
	 */
	public String startRouteConfig(String routid, Long upuserId);

}
