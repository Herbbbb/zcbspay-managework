package com.zcbspay.platform.manager.business.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.business.bean.RouteConfigBean;
import com.zcbspay.platform.manager.business.dao.RouteConfigDao;
import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
@SuppressWarnings("unchecked")
@Repository
public class RouteConfigDaoImpl extends HibernateBaseDAOImpl<String> implements RouteConfigDao {

	@Override
	public Map<String, Object> queryRouteConfig(RouteConfigBean routeBean, String page, String rows) {
		Object[] paramaters = new Object[] { null, null, routeBean.getRoutver(), routeBean.getStatus(),
				routeBean.getMerchroutver(), page, rows };
		String[] columns = new String[] { "v_rid", "v_routname", "v_routver", "v_status", "v_merchroutver", "i_no",
				"i_perno" };
		return executePageOracleProcedure("{CALL PCK_T_ROUTE_CONFIG.SEL_T_ROUTE_CONFIG(?,?,?,?,?,?,?,?,?)}", columns,
				paramaters, "cursor0", "v_total");
	}

	@Override
	public List<Map<String, Object>> getAllBank() {
		List<Map<String, Object>> resultList = (List<Map<String, Object>>) queryBySQL(
				"select distinct bankname||'('||bankcode||')' as bankname,bankcode from t_cash_bank order by bankname",null);
		return resultList;
	}

	
	@Override
	public List<Map<String, Object>> queryChnlcode() {
		List<Map<String, Object>> resultList = (List<Map<String, Object>>) queryBySQL(
				"select * from t_para_dic t where t.para_type='CHNLCODE' ", null);
		return resultList;
	}

	@Override
	public List<Map<String, Object>> queryAllBusicode() {
		List<Map<String, Object>>  resultList = (List<Map<String, Object>>) queryBySQL("select distinct (t.busicode),t.businame from t_business t  ", null);
        return resultList;
	}

	@Override
	public List<Map<String, Object>> queryAllRoutver() {
		List<Map<String, Object>>  resultList = (List<Map<String, Object>>) queryBySQL("select distinct (t.routver),t.routname from t_route t where t.status='00' ", null);
        return resultList;
	}

	@Override
	public List<?> queryOneRouteConfig(String rid) {
		Object[] paramaters = new Object[]{rid};
        String[] columns = new String[]{"v_rid"};        
        return executeOracleProcedure(
                "{CALL PCK_T_ROUTE_CONFIG.SEL_T_ROUTE_CONFIG_DETAIL(?,?)}",columns, paramaters, "cursor0"); 
	}

	@Override
	public List<Map<String, Object>> queryContainBank(String rid) {
		 Object[] paramaters = new Object[]{rid};
	        String[] columns = new String[]{"v_rid"};        
	        return executeOracleProcedure(
	                "{CALL PCK_T_ROUTE_CONFIG.SEL_BANKCODE(?,?)}",columns, paramaters, "cursor0"); 
	}

	@Override
	public List<Map<String, Object>> queryContainCardtype(String rid) {
		List<Map<String, Object>>  containList = (List<Map<String, Object>>) queryBySQL("select t.cardtype from t_route_config t where t.rid = ? ", new Object[]{rid});
        return containList;
	}

	@Override
	public List<Map<String, Object>> queryContainBusicode(String rid) {
		 Object[] paramaters = new Object[]{rid};
	        String[] columns = new String[]{"v_rid"};        
	        return executeOracleProcedure(
	                "{CALL PCK_T_ROUTE_CONFIG.SEL_BUCICODE(?,?)}",columns, paramaters, "cursor0"); 
	}

	@Override
	public String updateOneRouteConfig(RouteConfigBean routeConfigModel, List<String> bankcodeList,
			List<String> busicodeList, List<String> cradtypeList) {
		String  bankcodeStr ="";
        String  busicodeStr =""; 
        String  cardtypeStr =""; 
        if(bankcodeList!=null&&bankcodeList.size()>0){
            for(int i=0;i<bankcodeList.size();i++){
                bankcodeStr = bankcodeStr+bankcodeList.get(i).toString()+";";
            }
       }
       if(busicodeList!=null&&busicodeList.size()>0){
           for(int i=0;i<busicodeList.size();i++){
               busicodeStr = busicodeStr+busicodeList.get(i).toString()+";";
           }
       }
       if(cradtypeList!=null&&cradtypeList.size()>0){
           for(int i=0;i<cradtypeList.size();i++){
               cardtypeStr = cardtypeStr+cradtypeList.get(i).toString()+";";
           }
       }
        Object[] paramaters = new Object[]{
                routeConfigModel.getRid(), routeConfigModel.getCashcode(),
                routeConfigModel.getStime(), routeConfigModel.getEtime(), 
                routeConfigModel.getMinamt(),routeConfigModel.getMaxamt(), 
                bankcodeStr,busicodeStr,cardtypeStr,routeConfigModel.getRoutver(),
                routeConfigModel.getStatus(),routeConfigModel.getUpuser(),
                routeConfigModel.getOrdertype(),routeConfigModel.getOrders(),
                routeConfigModel.getIsdef(),routeConfigModel.getNotes(),
                routeConfigModel.getRemarks(),routeConfigModel.getMerchroutver()};
        String[] columns = new String[]{
                "v_rid", "v_cashcode", "v_stime","v_etime", 
                "v_minamt", "v_maxamt", " v_bankcode","v_busicode",
                "v_cardtype","v_routver","v_status","v_upuser",
                "v_ordertype","v_orders","v_isdef","v_notes",
                "v_remarks","v_merchroutver"};
        List<Map<String, Object>>  resultList = executeOracleProcedure(
                        "{CALL PCK_T_ROUTE_CONFIG.UPT_T_ROUTE_CONFIG(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}",
                        columns, paramaters, "cursor0");
        String resultString =  (String) resultList.get(0).get("INFO");
        return resultString;
	}

	@Override
	public String addRouteConfig(RouteConfigBean routeConfigModel, List<String> bankcodeList, List<String> busicodeList,
			List<String> cradtypeList) {
		String  bankcodeStr ="";
        String  busicodeStr =""; 
        String  cardtypeStr =""; 
        if(routeConfigModel==null){
            return "产品不能为空";
        }
        if(bankcodeList!=null&&bankcodeList.size()>0){
             for(int i=0;i<bankcodeList.size();i++){
                 bankcodeStr = bankcodeStr+bankcodeList.get(i).toString()+";";
             }
        }
        if(busicodeList!=null&&busicodeList.size()>0){
            for(int i=0;i<busicodeList.size();i++){
                busicodeStr = busicodeStr+busicodeList.get(i).toString()+";";
            }
        }
        if(cradtypeList!=null&&cradtypeList.size()>0){
            for(int i=0;i<cradtypeList.size();i++){
                cardtypeStr = cardtypeStr+cradtypeList.get(i).toString()+";";
            }
        }
        Object[] paramaters = new Object[] {
                routeConfigModel.getCashcode(),
                routeConfigModel.getStime(),
                routeConfigModel.getEtime(),
                routeConfigModel.getMinamt(),
                routeConfigModel.getMaxamt(),
                bankcodeStr,
                busicodeStr,
                cardtypeStr,
                routeConfigModel.getRoutver(),
                "00",
                routeConfigModel.getInuser(),
                routeConfigModel.getOrdertype(),
                routeConfigModel.getOrders(),
                routeConfigModel.getIsdef(),
                routeConfigModel.getNotes(),
                routeConfigModel.getRemarks(),
                routeConfigModel.getMerchroutver()
        };
        String[] columns = new String[] {"v_cashcode","v_stime","v_etime","v_minamt","v_maxamt",
                "v_bankcode","v_busicode","v_cardtype","v_routver","v_status","v_inuser","v_ordertype","v_orders",
                "v_isdef","v_notes","v_remarks","v_merchroutver"};//总共17个参数+cursor0
         Object total = executeOracleProcedure(
                "{CALL PCK_T_ROUTE_CONFIG.INS_T_ROUTE_CONFIG(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}",
                columns,paramaters, "cursor0").get(0).get("INFO");

        return (String) total;
	}

	@Override
	public String deleteRouteConfig(String routid, Long upuserId) {
		 Object[] paramaters = new Object[]{routid,"01",upuserId};
	        String[] columns = new String[]{"v_rid", "v_status","v_upuser"};
	        Object total =  executeOracleProcedure(
	                        "{CALL PCK_T_ROUTE_CONFIG.DEL_T_ROUTE_CONFIG(?,?,?,?)}",columns, paramaters, "cursor0").get(0).get("INFO");
	        return (String) total ;
	}

	@Override
	public String startRouteConfig(String routid, Long upuserId) {
		Object[] paramaters = new Object[]{routid,"00",upuserId};
        String[] columns = new String[]{"v_rid","v_status", "v_upuser"};
        Object total =  executeOracleProcedure(
                        "{CALL PCK_T_ROUTE_CONFIG.DEL_T_ROUTE_CONFIG(?,?,?,?)}",columns, paramaters, "cursor0").get(0).get("INFO");
        return (String) total ;
	}
}
