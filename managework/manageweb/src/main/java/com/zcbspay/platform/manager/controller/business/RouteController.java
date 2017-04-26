package com.zcbspay.platform.manager.controller.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.manager.business.bean.ParaDicBean;
import com.zcbspay.platform.manager.business.bean.RouteBean;
import com.zcbspay.platform.manager.business.bean.RouteConfigBean;
import com.zcbspay.platform.manager.business.service.RouteService;
import com.zcbspay.platform.manager.utils.JsonUtils;
import com.zcbspay.platform.manager.utils.UserHelper;

@SuppressWarnings("all")
@Controller
@RequestMapping("/route/")
public class RouteController {

	@Autowired
	private RouteService routeService;

	/**
	 * 路由配置
	 * 
	 * @author: zhangshd
	 * @param request
	 * @return String
	 * @date: 2017年3月10日 上午9:55:45
	 * @version v1.0
	 */
	@RequestMapping("showRoute")
	public String showRoute(HttpServletRequest request) {
		return "/route/route_manager";
	}

	/**
	 * 路由管理
	 * 
	 * @author: zhangshd
	 * @param request
	 * @return String
	 * @date: 2017年3月10日 上午9:56:03
	 * @version v1.0
	 */
	@RequestMapping("showRouteConfig")
	public String showRouteConfig(HttpServletRequest request) {
		return "/route/routeconfig_manager";
	}

	/**
	 * 路由版本界面
	 * 
	 * @author: zhangshd
	 * @param request
	 * @param routeBean
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年3月10日 上午10:36:31
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryRouteEdition")
	public Map<String, Object> queryRouteEdition(HttpServletRequest request, RouteBean routeBean, String page,
			String rows) {
		Map<String, Object> groupList = routeService.findRouteEditionByPage(routeBean, page, rows);
		return groupList;
	}

	/**
	 * 查询路由版本代码(路由版本代码要求按照规则生成，不能让用户自己填写、修改)
	 * 
	 * @author: zhangshd
	 * @param request
	 * @param routeBean
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年3月10日 上午10:46:05
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryRoutver")
	public Map<String, Object> queryRoutver(HttpServletRequest request, RouteBean routeBean, String page, String rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("table_name", "T_ROUTE");
		Map<String, Object> map = (Map<String, Object>) routeService.queryRoutver(variables);
		return map;
	}

	/**
	 * 保存路由版本信息
	 * 
	 * @author: zhangshd
	 * @param request
	 * @param routeBean
	 * @param page
	 * @param rows
	 * @param response
	 *            void
	 * @date: 2017年3月10日 上午11:01:35
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("saveRoute")
	public void saveRoute(HttpServletRequest request, RouteBean routeBean, HttpServletResponse response) {
		String mark = "";

		if (StringUtils.isEmpty(routeBean.getRoutname().trim())) {
			mark = "路由版本名称不能为空";
		}

		routeBean.setInuser(UserHelper.getCurrentUser(request).getUserId());
		mark = routeService.addRouteEdition(routeBean);
		if (mark.equals("操作成功!")) {
			mark = "添加成功!";
		}
		JsonUtils.json_encodeAndWrite(response, mark);
	}

	/**
	 * 查询路由版本信息
	 * 
	 * @author: zhangshd
	 * @param routid
	 * @return Map<String,Object>
	 * @date: 2017年3月10日 上午11:08:00
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryOneRoute")
	public Map<String, Object> queryOneRoute(String routid) {
		Map<String, Object> routeMap = routeService.queryOneRoute(routid);
		return routeMap;
	}

	/**
	 * 修改路由版本信息
	 * 
	 * @author: zhangshd
	 * @param routeBean
	 * @param request
	 * @param response
	 *            void
	 * @date: 2017年3月10日 上午11:44:35
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("updateRoute")
	public void updateRoute(RouteBean routeBean, HttpServletRequest request, HttpServletResponse response) {
		String mark = "";
		if (StringUtils.isEmpty(routeBean.getRoutver().trim()) || StringUtils.isEmpty(routeBean.getRoutname().trim())) {
			mark = "路由版本代码或者路由版本名称不能为空";
		}
		routeBean.setUpuser(UserHelper.getCurrentUser(request).getUserId());
		routeBean.setStatus("00");
		mark = routeService.updateRoute(routeBean);
		JsonUtils.json_encodeAndWrite(response, mark);
	}

	/**
	 * 注销路由版本信息
	 * 
	 * @author: zhangshd
	 * @param routeBean
	 * @param response
	 * @param request
	 *            void
	 * @date: 2017年3月10日 下午1:08:29
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("deleteRoute")
	public void deleteRoute(RouteBean routeBean, HttpServletResponse response, HttpServletRequest request) {
		String mark = "";
		if (StringUtils.isEmpty(routeBean.getNote().trim())) {
			mark = "请在备注处填写注销理由";
		} else {
			routeBean.setUpuser(UserHelper.getCurrentUser(request).getUserId());
			routeBean.setStatus("00");
			mark = routeService.deleteRoute(routeBean);
		}

		JsonUtils.json_encodeAndWrite(response, mark);
	}

	/**
	 * 启用路由版本
	 * 
	 * @author: zhangshd
	 * @param routeBean
	 * @param response
	 * @param request
	 *            void
	 * @date: 2017年3月10日 下午1:19:11
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("startRoute")
	public void startRoute(RouteBean routeBean, HttpServletResponse response, HttpServletRequest request) {
		String mark = "";
		if (StringUtils.isEmpty(routeBean.getNote().trim())) {
			mark = "请在备注处填写启用理由";
		} else {
			routeBean.setUpuser(UserHelper.getCurrentUser(request).getUserId());// 记录修改人
			routeBean.setStatus("01");
			mark = routeService.startRoute(routeBean);
		}
		JsonUtils.json_encodeAndWrite(response, mark);
	}

	/**
	 * 查询路由配置
	 * 
	 * @author: zhangshd
	 * @param request
	 * @param routeBean
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年3月10日 下午1:44:37
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryRouteConfig")
	public Map<String, Object> queryRouteConfig(RouteConfigBean routeBean, String page,
			String rows) {
		Map<String, Object> groupList = routeService.queryRouteConfig(routeBean, page, rows);
		return groupList;
	}

	/**
	 * 查询发卡行对应的银行代码
	 * 
	 * @author: zhangshd
	 * @param request
	 * @param routeBean
	 * @param page
	 * @param rows
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午1:54:22
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryBankCode")
	public List<Map<String, Object>> queryBankCode() {
		List<Map<String, Object>> resultList = routeService.getAllBank();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < resultList.size(); i++) {
			String bankcodeString = resultList.get(i).get("BANKCODE").toString();
			String banknameString = resultList.get(i).get("BANKNAME").toString();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("bankcode", bankcodeString);
			map.put("bankname", banknameString);
			list.add(map);
		}
		return list;
	}

	/**
	 * 查询交易渠道
	 * 
	 * @author: zhangshd
	 * @param routeBean
	 * @return List<ParaDicBean>
	 * @date: 2017年3月10日 下午2:10:24
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryChnlcode")
	public List<ParaDicBean> queryChnlcode() {
		List<Map<String, Object>> groupList = routeService.queryChnlcode();
		List<ParaDicBean> list = new ArrayList<ParaDicBean>();
		for (int i = 0; i < groupList.size(); i++) {
			String paracodeString = groupList.get(i).get("PARA_CODE").toString();
			String paranameString = groupList.get(i).get("PARA_NAME").toString();
			ParaDicBean paraDicModel = new ParaDicBean();
			paraDicModel.setParaCode(paracodeString);
			paraDicModel.setParaName(paranameString);
			list.add(paraDicModel);
		}
		return list;
	}

	/**
	 * 得到所有的交易类型
	 * 
	 * @author: zhangshd
	 * @param routeBean
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:28:07
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryAllBusicode")
	public List<Map<String, Object>> queryAllBusicode() {
		List<Map<String, Object>> resultList = routeService.queryAllBusicode();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < resultList.size(); i++) {
			String busicodeString = resultList.get(i).get("BUSICODE").toString();
			String businameString = resultList.get(i).get("BUSINAME").toString();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("busiCode", busicodeString);
			map.put("busiName", businameString);
			list.add(map);
		}
		return list;
	}

	/**
	 * 得到所有的路由版本
	 * 
	 * @author: zhangshd
	 * @param routeBean
	 * @return List<Map<String,Object>>
	 * @date: 2017年3月10日 下午2:33:24
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryAllRoutver")
	public List<Map<String, Object>> queryAllRoutver() {
		List<Map<String, Object>> resultList = routeService.queryAllRoutver();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < resultList.size(); i++) {
			String routverString = resultList.get(i).get("ROUTVER").toString();
			String routnameString = resultList.get(i).get("ROUTNAME").toString();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("routver", routverString);
			map.put("routname", routnameString);
			list.add(map);
		}
		return list;
	}
	/**
	 * 查询一条路由配置信息
	 * @author: zhangshd
	 * @param rid
	 * @return List<?>
	 * @date: 2017年3月10日 下午2:37:28 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryOneRouteConfig")
	public List<?> queryOneRouteConfig(String rid) {
		List<?> groupList = routeService.queryOneRouteConfig(rid);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (groupList != null && groupList.size() != 0) {
			resultMap = (Map<String, Object>) groupList.get(0);
		}
		return groupList;
	}
	
	
	/**
	 * 根据t_route_configde的主键查询此记录包含的发卡行
	 * @author: zhangshd
	 * @param rid
	 * @return List<?>
	 * @date: 2017年3月10日 下午2:40:10 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryContainBank")
	public List<?> queryContainBank(String rid) {
		List<Map<String, Object>> containList = null;
        if(rid!=null&&!rid.equals("")){
            containList =(List<Map<String, Object>>)routeService.queryContainBank(rid);    
        }
        return containList;
	}
	
	/**
	 * 根据t_route_configde的主键查询此记录包含的卡种类
	 * @author: zhangshd
	 * @param rid
	 * @return List<?>
	 * @date: 2017年3月10日 下午2:43:27 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryContainCardtype")
	public List<?> queryContainCardtype(String rid) {
		 if(rid!=null&&!rid.equals("")){
	            List<Map<String, Object>> cardtypeList = new ArrayList<Map<String, Object>>();
	            List<Map<String, Object>> containList =(List<Map<String, Object>>)routeService.queryContainCardtype(rid);
	            Map<String,Object> map1 = new HashMap<String, Object>();
	            Map<String,Object> map2 = new HashMap<String, Object>();
	            if(containList == null || containList.size()==0){
	                Map<String,Object> map = new HashMap<String, Object>();
	                map.put("CONTAIN1", "NO");
	                map.put("CONTAIN2", "NO");
	                map.put("1", "借记卡");                
	                map.put("2", "贷记卡");  
	                cardtypeList.add(map);
	            }else{
	                String cardtype =  (String) containList.get(0).get("CARDTYPE");
	                if(cardtype == null || cardtype==""){
	                    map1.put("CONTAIN1", "NO");                      
	                    map1.put("1", "借记卡");                            
	                    cardtypeList.add(map1);
	                    map2.put("CONTAIN2", "NO");               
	                    map2.put("2", "贷记卡");
	                    cardtypeList.add(map2);
	                }else{
	                    String[] cardtypeArray = cardtype.split(";");
	                    if(cardtypeArray.length ==1 ){
	                        if(cardtypeArray[0].equals("1")){                            
	                            map1.put("CONTAIN1", "YES");                      
	                            map1.put("1", "借记卡");                            
	                            cardtypeList.add(map1);
	                            map2.put("CONTAIN2", "NO");
	                            map2.put("2", "贷记卡");
	                            cardtypeList.add(map2);
	                        }else if (cardtypeArray[0].equals("2")){
	                            map1.put("CONTAIN1", "NO");                      
	                            map1.put("1", "借记卡");                            
	                            cardtypeList.add(map1);
	                            map2.put("CONTAIN2", "YES");               
	                            map2.put("2", "贷记卡");
	                            cardtypeList.add(map2);
	                        }
	                    }else{ 
	                        map1.put("CONTAIN1", "YES");                      
	                        map1.put("1", "借记卡");
	                        cardtypeList.add(map1);
	                        map2.put("CONTAIN2", "YES");                      
	                        map2.put("2", "贷记卡");
	                        cardtypeList.add(map2);
	                    }
	                }
	                }
	            return cardtypeList;
	         }
	        return null;
	}
	/**
	 * 查询 业务代码
	 * @author: zhangshd
	 * @param rid
	 * @return List<?>
	 * @date: 2017年3月10日 下午2:48:09 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryContainBusicode")
	public List<?> queryContainBusicode(String rid) {
		List<Map<String, Object>> containList = null;
        if(rid!=null&&!rid.equals("")){
            containList =(List<Map<String, Object>>)routeService.queryContainBusicode(rid);    
        }
        return containList;
	}
	/**
	 * 修改路由配置信息
	 * @author: zhangshd
	 * @param routeConfigBean
	 * @param request
	 * @param response
	 * @param bankcodearray
	 * @param busicodearray
	 * @param cradtypearray void
	 * @date: 2017年3月10日 下午2:55:49 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("updateOneRouteConfig")
	public void updateOneRouteConfig(RouteConfigBean routeConfigBean,HttpServletRequest request,HttpServletResponse 
			                          response,String[] bankcodearray,String[] busicodearray,String[] cradtypearray) {
		String result = "";
        if (StringUtils.isEmpty(routeConfigBean.getRoutver().trim())) {
            result = "交易渠道不能为空";
        }else {
        	routeConfigBean.setUpuser(UserHelper.getCurrentUser(request).getUserId());
            String mark = routeService.updateOneRouteConfig(routeConfigBean,Arrays.asList(bankcodearray),Arrays.asList(busicodearray),Arrays.asList(cradtypearray));
            if(mark.equals("操作成功!") ){
                mark = "修改成功!";
            }
		}
	}
	
	
	
	/**
	 * 增加一条路由配置信息
	 * @author: zhangshd
	 * @param routeConfigBean
	 * @param request
	 * @param response
	 * @param bankcodearray
	 * @param busicodearray
	 * @param cradtypearray void
	 * @date: 2017年3月10日 下午3:04:19 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("addRouteConfig")
	public void addRouteConfig(RouteConfigBean routeConfigBean,HttpServletRequest request,HttpServletResponse 
			                          response,String[] bankcodearray,String[] busicodearray,String[] cradtypearray) {
		String result = "";
        if (StringUtils.isEmpty(routeConfigBean.getRoutver()) || StringUtils.isEmpty(routeConfigBean.getIsdef())) {
            result = "交易渠道或是否为默认路由不能为空";
        }else{
        	routeConfigBean.setInuser(UserHelper.getCurrentUser(request).getUserId());
            //发卡行  交易类型  卡种类  交易渠道
            result=routeService.addRouteConfig(routeConfigBean, bankcodearray!=null?Arrays.asList(bankcodearray):null,busicodearray!=null?Arrays.asList(busicodearray):null,cradtypearray!=null?Arrays.asList(cradtypearray):null);
            if(result.equals("操作成功!")){
                result = "添加成功!";
            }else if(result.equals("执行出错!已存在默认路由")){
                result = "该路由版本下已存在默认路由";
            }else if(result.equals("执行出错!请先设置默认路由")){
                result= "请先对该路由版本设置默认路由";
            }else if(result.equals("执行出错!设置默认路由参数错误")){
                result="请设置是否为默认路由";
            }
        }
        
        JsonUtils.json_encodeAndWrite(response, result);
	}
	
	/**
	 * 注销路由配置
	 * @author: zhangshd
	 * @param routeConfigBean
	 * @param request
	 * @param response
	 * @param bankcodearray
	 * @param busicodearray
	 * @param cradtypearray void
	 * @date: 2017年3月10日 下午3:19:32 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("deleteRouteConfig")
	public void deleteRouteConfig(String routid,HttpServletRequest request,HttpServletResponse response) {
		Long upuserId = UserHelper.getCurrentUser(request).getUserId();
        String mark = routeService.deleteRouteConfig(routid,upuserId);
        JsonUtils.json_encodeAndWrite(response, mark);
	}
	
	/**
	 * 开启路由配置
	 * @author: zhangshd
	 * @param routid
	 * @param request
	 * @param response void
	 * @date: 2017年3月10日 下午3:42:53 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("startRouteConfig")
	public void startRouteConfig(String routid,HttpServletRequest request,HttpServletResponse response) {
		Long upuserId = UserHelper.getCurrentUser(request).getUserId();
        String mark = routeService.startRouteConfig(routid,upuserId);
        JsonUtils.json_encodeAndWrite(response, mark);
	}
	
	
	
	
	
}
