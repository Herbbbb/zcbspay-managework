package com.zcbspay.platform.manager.business.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.business.bean.RouteBean;
import com.zcbspay.platform.manager.business.bean.RouteConfigBean;

public interface RouteService {
	/**
	 * 路由版本界面
	 * @author: zhangshd
	 * @param routeBean
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年3月10日 上午10:36:31 
	 * @version v1.0
	 */
	public Map<String, Object> findRouteEditionByPage(RouteBean routeBean, String page, String rows);
	/**
	 * 查询路由版本代码(路由版本代码要求按照规则生成，不能让用户自己填写、修改)
	 * @author: zhangshd
	 * @param routeBean
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年3月10日 上午10:46:05 
	 * @version v1.0
	 */
	public Map<String, Object> queryRoutver(Map<String, Object> variables);
	/**
	 * 保存路由版本信息
	 * @author: zhangshd
	 * @param request
	 * @param routeBean
	 * @param page
	 * @param rows
	 * @param response void
	 * @date: 2017年3月10日 上午11:01:35 
	 * @version v1.0
	 */
	public String addRouteEdition(RouteBean routeBean);
	/**
	 * 查询路由版本信息
	 * @author: zhangshd
	 * @param routid
	 * @return Map<String,Object>
	 * @date: 2017年3月10日 上午11:08:00 
	 * @version v1.0
	 */
	public Map<String, Object> queryOneRoute(String routid);
	/**
	 * 修改路由版本信息
	 * @author: zhangshd
	 * @param routeBean
	 * @param response void
	 * @date: 2017年3月10日 上午11:44:35 
	 * @version v1.0
	 */
	public String updateRoute(RouteBean routeBean);
	/**
	 * 注销路由版本信息
	 * @author: zhangshd
	 * @param routeBean
	 * @date: 2017年3月10日 下午1:08:29 
	 * @version v1.0
	 */
	public String deleteRoute(RouteBean routeBean);
	/**
	 * 启用路由版本
	 * @author: zhangshd
	 * @param routeBean
	 * @return String
	 * @date: 2017年3月10日 下午1:19:27 
	 * @version v1.0
	 */
	public String startRoute(RouteBean routeBean);
	/**
	 * 查询路由配置
	 * @author: zhangshd
	 * @param routeBean
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年3月10日 下午1:46:49 
	 * @version v1.0
	 */
	public Map<String, Object> queryRouteConfig(RouteConfigBean routeBean, String page, String rows);
	/**
	 * 查询发卡行对应的银行代码
	 * @author: zhangshd
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午1:55:33 
	 * @version v1.0
	 */
	public List<Map<String, Object>> getAllBank();
	/**
	 * 交易渠道查询
	 * @author: zhangshd
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:10:38 
	 * @version v1.0
	 */
	public List<Map<String, Object>> queryChnlcode();
	/**
	 * 得到所有的交易类型
	 * @author: zhangshd
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:28:20 
	 * @version v1.0
	 */
	public List<Map<String, Object>> queryAllBusicode();
	/**
	 * 得到所有的路由版本
	 * @author: zhangshd
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:33:36 
	 * @version v1.0
	 */
	public List<Map<String, Object>> queryAllRoutver();
	/**
	 * 查询一条路由配置信息
	 * @author: zhangshd
	 * @param rid
	 * @return List<?>
	 * @date: 2017年3月10日 下午2:37:42 
	 * @version v1.0
	 */
	public List<?> queryOneRouteConfig(String rid);
	/**
	 * 根据t_route_configde的主键查询此记录包含的发卡行
	 * @author: zhangshd
	 * @param rid
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:40:27 
	 * @version v1.0
	 */
	public List<Map<String, Object>> queryContainBank(String rid);
	/**
	 * 根据t_route_configde的主键查询此记录包含的卡种类
	 * @author: zhangshd
	 * @param rid
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:43:46 
	 * @version v1.0
	 */
	public List<Map<String, Object>> queryContainCardtype(String rid);
	/**
	 * 查询业务代码
	 * @author: zhangshd
	 * @param rid
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:48:37 
	 * @version v1.0
	 */
	public List<Map<String, Object>> queryContainBusicode(String rid);
	/**
	 * 修改路由配置信息
	 * @author: zhangshd
	 * @param routeConfigBean
	 * @param asList
	 * @param asList2
	 * @param asList3
	 * @return String
	 * @date: 2017年3月10日 下午2:56:09 
	 * @version v1.0
	 */
	public String updateOneRouteConfig(RouteConfigBean routeConfigBean, List<String> bankcodelist, List<String> busicodelist,
			List<String> cradtypelist);
	/**
	 * 增加一条路由配置信息
	 * @author: zhangshd
	 * @param routeConfigBean
	 * @param bankcodelist
	 * @param busicodelist
	 * @param cradtypelist
	 * @return String
	 * @date: 2017年3月10日 下午3:04:50 
	 * @version v1.0
	 */
	public String addRouteConfig(RouteConfigBean routeConfigBean, List<String> bankcodelist, List<String> busicodelist,
			List<String> cradtypelist);
	/**
	 * 注销路由配置
	 * @author: zhangshd
	 * @param routid
	 * @param upuserId
	 * @return String
	 * @date: 2017年3月10日 下午3:27:49 
	 * @version v1.0
	 */
	public String deleteRouteConfig(String routid, Long upuserId);
	/**
	 * 开启路由配置
	 * @author: zhangshd
	 * @param routid
	 * @param upuserId
	 * @return String
	 * @date: 2017年3月10日 下午3:42:36 
	 * @version v1.0
	 */
	public String startRouteConfig(String routid, Long upuserId);
	
}
