package com.zcbspay.platform.manager.business.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.business.bean.RouteBean;
import com.zcbspay.platform.manager.business.dao.RouteDao;
import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;

@Repository
public class RouteDaoImpl extends HibernateBaseDAOImpl<String> implements RouteDao {

	@Override
	public Map<String, Object> findRouteEditionByPage(RouteBean routeBean, String page, String rows) {
		String[] columns = new String[]{"v_routver", "v_routname", "v_status",
		        "v_intime","v_notes","v_remarks","i_no","i_perno"};

		            Object[] paramaters = new Object[]{
		                routeBean.getRoutver(),
		                routeBean.getRoutname(),
		                routeBean.getStatus(), 
		                routeBean.getIntime(), 
		                routeBean.getNote(), 
		                routeBean.getRemarks(), page, rows};
		            return executePageOracleProcedure(
		                    "{CALL PCK_T_ROUTE.SEL_T_ROUTE(?,?,?,?,?,?,?,?,?,?)}", columns, paramaters,
		                    "cursor0", "v_total");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> queryRoutver(Map<String, Object> variables) {
		
		List<Map<String, Object>> list =  (List<Map<String, Object>>) queryBySQL("select GET_BROK (?) as routver from dual ",new Object[]{variables.get("table_name")});
        Map<String, Object> resultMap = list.get(0);
        return    resultMap;
	}

	@Override
	public String addRouteEdition(RouteBean routeBean) {
        Object[] paramaters = new Object[]{routeBean.getRoutname(),routeBean.getRoutver(),
        		routeBean.getInuser(),routeBean.getNote(),routeBean.getRemarks()};
        String[] columns = new String[]{"v_routname", "v_routver","v_inuser", "v_notes", "v_remarks"};
        Object total =executeOracleProcedure(
                        "{CALL PCK_T_ROUTE.INS_T_ROUTE(?,?,?,?,?,?)}", columns,
                        paramaters, "cursor0").get(0).get("INFO");
        return (String) total;
	}

	@Override
	public Map<String, Object> queryOneRoute(String routid) {
		Object[] paramaters = new Object[]{routid};
        String[] columns = new String[]{"v_routid"};
        Map<String, Object> resultMap =executeOracleProcedure("{CALL PCK_T_ROUTE.SEL_T_ROUTE_DETAIL(?,?)}", 
                columns, paramaters, "cursor0").get(0);
         return resultMap;
	}

	@Override
	public String updateRoute(RouteBean routeBean) {
		 String[] columns = new String[]{"v_routid", "v_routname", "v_status",
			        "v_upuser","v_notes","v_remarks"};
			        Object[] paramaters = new Object[]{routeBean.getRoutid(), routeBean.getRoutname(),
			        		routeBean.getStatus(),routeBean.getUpuser(),routeBean.getNote(),routeBean.getRemarks()};
			        Map<String, Object> map =  executeOracleProcedure(
			                "{CALL PCK_T_ROUTE.UPT_T_ROUTE(?,?,?,?,?,?,?)}", columns, paramaters,
			                "cursor0").get(0);
			        String info = (String) map.get("RET");
			        return info;
	}

	@Override
	public String deleteRoute(String routid) {
		Object[] paramaters = new Object[]{routid};
        String[] columns = new String[]{"v_routid"};
        
        Map<String, Object> resultMap = executeOracleProcedure("{CALL PCK_T_ROUTE.DEL_T_ROUTE(?,?)}", 
                columns, paramaters, "cursor0").get(0);
        String info = (String) resultMap.get("RET");
         return info;
	}

	@Override
	public String startRoute(String routid) {
		Object[] paramaters = new Object[]{routid};
        String[] columns = new String[]{"v_routid"};
        Map<String, Object> resultMap =executeOracleProcedure("{CALL PCK_T_ROUTE.START_T_ROUTE(?,?)}", 
                columns, paramaters, "cursor0").get(0);
        String info = (String) resultMap.get("RET");
         return info;
	}
	

}
