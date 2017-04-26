package com.zcbspay.platform.manager.business.dao;

import java.util.Map;

import com.zcbspay.platform.manager.business.bean.RouteBean;
import com.zcbspay.platform.manager.dao.BaseDAO;

public interface RouteDao extends BaseDAO<String>{
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
	 * @date: 2017年3月10日 上午11:44:35 
	 * @version v1.0
	 */
	public String updateRoute(RouteBean routeBean);
	/**
	 * 删除路由实例
	 * @author: zhangshd
	 * @param routid
	 * @return String
	 * @date: 2017年3月10日 下午1:11:58 
	 * @version v1.0
	 */
	public String deleteRoute(String routid);
	/**
	 * 开启路由版本
	 * @author: zhangshd
	 * @param routid
	 * @return String
	 * @date: 2017年3月10日 下午1:20:34 
	 * @version v1.0
	 */
	public String startRoute(String routid);
	


}
