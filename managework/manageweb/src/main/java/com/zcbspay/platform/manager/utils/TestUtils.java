package com.zcbspay.platform.manager.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.zcbspay.platform.manager.merchant.bean.PortalUserModel;

import net.sf.json.JSONObject;

@SuppressWarnings("all")
public class TestUtils {

	
	public static Map<String, Object> register(String userBeanStr) {
		String url = "http://192.168.2.90:9911/fe/user/register";
		HttpUtils httpUtils = new HttpUtils();
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("userBeanStr", userBeanStr);
		try {
			httpUtils.openConnection();
			String result = httpUtils.post(url, paramMap);
			Map<String, Object> map= (Map<String, Object>) JSONObject.toBean(JSONObject.fromObject(result),Map.class);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,Object> mapErr = new HashMap<>();
			mapErr.put("RET", "err");
			mapErr.put("INFO", "服务异常！");
			return mapErr;
		}finally {
			httpUtils.closeConnection();
		}
	}
    
    private static String getFixLenthString(int strLength) {  
        
        Random rm = new Random();  
        // 获得随机数  
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);  
      
        // 将获得的获得随机数转化为字符串  
        String fixLenthString = String.valueOf(pross);  
      
        // 返回固定的长度的随机数  
        return fixLenthString.substring(1, strLength + 1);  
    } 
    
	public static void main(String[] args) {
		try {  
			PortalUserModel userBean = new PortalUserModel();
        	userBean.setMemberid("200000000001590");
        	userBean.setUserName("交易测试商户千万勿动");
        	userBean.setPwd(MD5Util.MD5(getFixLenthString(6)));
        	userBean.setPhone("17736539989");
        	userBean.setEmail("76674512@qq.com");
			String userBeanStr =JSONObject.fromObject(userBean).toString();
        	Map<String, Object> register = register(userBeanStr);
        	 Set<Entry<String, Object>> entrySet = register.entrySet();
        	 for (Entry<String, Object> entry : entrySet) {
                 String key = entry.getKey();
                 Object value = entry.getValue();
                 System.out.println("key="+key+" value="+value);
             }
        	System.out.println(register);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}
}
