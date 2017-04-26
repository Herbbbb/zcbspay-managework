package com.zcbspay.platform.manager.business.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zcbspay.platform.manager.business.bean.RouteBean;
import com.zcbspay.platform.manager.business.bean.RouteConfigBean;
import com.zcbspay.platform.manager.business.dao.RouteConfigDao;
import com.zcbspay.platform.manager.business.dao.RouteDao;
import com.zcbspay.platform.manager.business.service.RouteService;

@Service("routeService")
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private RouteConfigDao routeConfigDao;
	@Override
	public Map<String, Object> findRouteEditionByPage(RouteBean routeBean, String page, String rows) {
		return routeDao.findRouteEditionByPage(routeBean,page,rows);
	}
	@Override
	public Map<String, Object> queryRoutver(Map<String, Object> variables) {
		return routeDao.queryRoutver(variables);
	}
	@Override
	public String addRouteEdition(RouteBean routeBean) {
		return routeDao.addRouteEdition(routeBean);
	}
	@Override
	public Map<String, Object> queryOneRoute(String routid) {
		return routeDao.queryOneRoute(routid);
	}
	@Override
	public String updateRoute(RouteBean routeBean) {
		return routeDao.updateRoute(routeBean).equals("succ")?"修改成功":"修改失败";
	}
	@Transactional
	@Override
	public String deleteRoute(RouteBean routeBean) {
    	String mark=null;
        String succOrFail = routeDao.updateRoute(routeBean);
        if(succOrFail.equals("succ")){//表示修改成功，下一步需要注销
            mark =routeDao.deleteRoute(routeBean.getRoutid());
            if(mark.equals("succ")){
                mark ="注销成功!";
            }else {
                mark="注销失败!";
            }
        }else{
            mark="注销失败!";
        }    
        return mark;
	}
	@Override
	public String startRoute(RouteBean routeBean) {
		String mark=null;
		String succOrFail = routeDao.updateRoute(routeBean);
        if(succOrFail.equals("succ")){//表示修改成功，下一步需要注销
            mark = routeDao.startRoute(routeBean.getRoutid());
            if(mark.equals("succ")){
                mark ="启用成功!";
            }else{
                mark="启用失败!";
            }
        }else{
            mark="启用失败!";
        }    
        return mark;
	}
	@Override
	public Map<String, Object> queryRouteConfig(RouteConfigBean routeBean, String page, String rows) {
		return routeConfigDao.queryRouteConfig(routeBean,page,rows);
	}
	@Override
	public List<Map<String, Object>> getAllBank() {
		return routeConfigDao.getAllBank();
	}
	@Override
	public List<Map<String, Object>> queryChnlcode() {
		return routeConfigDao.queryChnlcode();
	}
	@Override
	public List<Map<String, Object>> queryAllBusicode() {
		return routeConfigDao.queryAllBusicode();
	}
	@Override
	public List<Map<String, Object>> queryAllRoutver() {
		return routeConfigDao.queryAllRoutver();
	}
	@Override
	public List<?> queryOneRouteConfig(String rid) {
		return routeConfigDao.queryOneRouteConfig(rid);
	}
	@Override
	public List<Map<String, Object>> queryContainBank(String rid) {
		return routeConfigDao.queryContainBank(rid);
	}
	@Override
	public List<Map<String, Object>> queryContainCardtype(String rid) {
		return routeConfigDao.queryContainCardtype(rid);
	}
	@Override
	public List<Map<String, Object>> queryContainBusicode(String rid) {
		return routeConfigDao.queryContainBusicode(rid);
	}
	@Override
	public String updateOneRouteConfig(RouteConfigBean routeConfigBean, List<String> bankcodelist,
			List<String> busicodelist, List<String> cradtypelist) {
		return routeConfigDao.updateOneRouteConfig(routeConfigBean,bankcodelist,busicodelist,cradtypelist);
	}
	@Override
	public String addRouteConfig(RouteConfigBean routeConfigBean, List<String> bankcodelist, List<String> busicodelist,
			List<String> cradtypelist) {
		return routeConfigDao.addRouteConfig(routeConfigBean,bankcodelist,busicodelist,cradtypelist);
	}
	@Override
	public String deleteRouteConfig(String routid, Long upuserId) {
		return routeConfigDao.deleteRouteConfig(routid,upuserId);
	}
	@Override
	public String startRouteConfig(String routid, Long upuserId) {
		return routeConfigDao.startRouteConfig(routid,upuserId);
	}

	

}
