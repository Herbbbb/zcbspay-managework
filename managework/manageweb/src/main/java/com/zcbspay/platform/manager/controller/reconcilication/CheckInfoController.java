package com.zcbspay.platform.manager.controller.reconcilication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zcbspay.platform.cnaps.application.bean.ResultBean;
import com.zcbspay.platform.cnaps.application.bean.TotalCheckPaymentBean;
import com.zcbspay.platform.manager.constants.Constants;
import com.zcbspay.platform.manager.reconcilication.bean.ChnTxnBean;
import com.zcbspay.platform.manager.reconcilication.service.ChannelFileService;
import com.zcbspay.platform.manager.reconcilication.service.CheckInfoService;
import com.zcbspay.platform.manager.reconcilication.service.UploadlogService;
import com.zcbspay.platform.manager.utils.CSVUtils;
import com.zcbspay.platform.manager.utils.UserHelper;
@SuppressWarnings("all")
@Controller
@RequestMapping("/checkinfo/")
public class CheckInfoController {

	@Autowired
	private CheckInfoService checkInfoService;
	
	@Autowired
	private ChannelFileService channelFileService;
	
	@Autowired
	private UploadlogService uploadlogService;
	
		
	private final String rmb="156";

	/**
	 * 总账数据页面
	 * 
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年2月27日 16:48:00
	 * @version v1.0
	 */
	@RequestMapping("showTotalCheckInfo")
	public String showBusiRate() {
		return "checkinfo/checkinfo_total";
	}

	/**
	 * 开始对账页面
	 * 
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年2月27日 16:48:00
	 * @version v1.0
	 */
	@RequestMapping("showStartCheck")
	public String showStartCheck() {
		return "checkinfo/file_start";
	}
	
	
	
	@RequestMapping("showFileUpload")
	public String showFileUpload() {
		return "checkinfo/file_upload";
	}

	/**
	 * 查询全部对账数据
	 * 
	 * @author: zhangshd
	 * @param request
	 * @param checkInfoDate
	 * @param page
	 * @param rows
	 * @return List<?>
	 * @date: 2017年2月28日 上午11:45:32
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryCheckInfoTotal")
	public Object queryCheckInfoTotal(String checkInfoDate) {
		return checkInfoService.queryCheckInfoTotal(checkInfoDate);
	}

	/**
	 * 查询对账详细信息
	 * 
	 * @author: zhangshd
	 * @param caseid
	 * @return ResultBean
	 * @date: 2017年2月28日 下午3:16:49
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryCheckInfoDetail")
	public ResultBean queryCheckInfoDetail(TotalCheckPaymentBean totalCheckPaymentBean, String checkDate) {
		return checkInfoService.queryCheckInfoDetail(totalCheckPaymentBean, checkDate);
	}

	/**
	 *  查询机构
	 * @author: zhangshd
	 * @return List<ChannelFileBean>
	 * @date: 2017年3月1日 下午3:31:05 
	 * @version v1.0
	 */
	 
	@ResponseBody
	@RequestMapping("queryChannel")
	public List<?> queryChannel() {
		List<?> list = channelFileService.getAllStatusChannel();
		return list;
	}
	
	/**
	 * 任务分页查询（新增任务，开始对账）
	 * @author: zhangshd
	 * @return Map<String, Object>
	 * @date: 2017年3月1日 下午4:22:35 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryProcess")
	public Map<String, Object> queryProcess(String startDate,String endDate,String page,String rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
        if (!StringUtils.isBlank(startDate)) {
            variables.put("startDate", startDate.replace("-", ""));
        }
        if (!StringUtils.isBlank(endDate)) {
            variables.put("endDate", endDate.replace("-", ""));
        }
        Map<String, Object> processList =uploadlogService.findProcessByPage(variables, page,rows);
        return processList;
	}
	
	
	/**
	 * 保存任务
	 * @author: zhangshd
	 * @param instiid
	 * @return Object
	 * @date: 2017年3月1日 下午4:49:24 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("saveProcess")
	public Object saveProcess(String instiid) {
		 List<?> list = uploadlogService.saveProcess(instiid);
	     return list.get(0);
	}
	
	/**
	 * 开始执行核对
	 * @author: zhangshd
	 * @param filestartid
	 * @return Object
	 * @date: 2017年3月1日 下午4:56:23 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("startCheckFile")
	public List<?> startCheckFile(String filestartid) {
		List<?> list = uploadlogService.startCheckFile(filestartid);
        return list;
	}
	/**
	 * 查询对账差错的记录
	 * @author: zhangshd
	 * @param filestartid
	 * @return List<?>
	 * @date: 2017年3月1日 下午5:04:13 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryFail")
	public Map<String, Object> queryFail(HttpServletRequest request,String page,String rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("proid", request.getParameter("proid")); 
        variables.put("user",UserHelper.getCurrentUser(request).getUserId());
        Map<String, Object> failList = uploadlogService.queryFail(variables, page,rows);
        return failList;
	}
	
	/**
	 * 查询对账成功的记录
	 * @author: zhangshd
	 * @param filestartid
	 * @return List<?>
	 * @date: 2017年3月1日 下午5:04:13 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("querySuccess")
	public Map<String, Object> querySuccess(HttpServletRequest request,String page,String rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("proid", request.getParameter("proid")); 
        variables.put("user",UserHelper.getCurrentUser(request).getUserId());
        Map<String, Object> failList = uploadlogService.querySuccess(variables, page,rows);
        return failList;
	}
	
	
	/**
	 * 上传CSV文件并解析到数据库
	 * @param request
	 * @param fileUp 用户上传的input的name
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value="csvimport",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> csvImport(HttpServletRequest request,HttpSession session,String instiid,
	        @RequestParam("orderCSV")MultipartFile fileUp,  HttpServletResponse response) {
	    Map<String, Object> resMap = new HashMap<String, Object>();
	    if(fileUp==null || fileUp.isEmpty()){
	        resMap.put("error", "上传文件为空或没有数据");
	        return resMap;
	    }
	    try {
	        boolean localhost = request.getRequestURL().toString().contains("localhost");
	        String rootPath=localhost?request.getSession().getServletContext().getRealPath("/"):
	               "/";//获取项目根目录
	        File dir = new File(rootPath+"\\orderData\\");
	        if(!dir.exists()){//目录不存在则创建
	             dir.mkdir();
	        }
	        File fileServer = new File(rootPath+"\\orderData\\"
	                +(new Random().nextInt(100000)+100000)+fileUp.getOriginalFilename());
	        String fileName= fileUp.getOriginalFilename();	        
	        fileUp.transferTo(fileServer);
	        List<String> orderInfoList = CSVUtils.importCsv(fileServer);
	        if(orderInfoList==null || orderInfoList.size()<1 || orderInfoList.size()>10000){
	            resMap.put("error", "上传文件无数据或数据量过大");
	            return resMap;
	        }
	        String[] files=fileName.split("_");
	        String organization=files[0];
			String date=files[1];
	        String busiType=files[2];
	        List<ChnTxnBean> list=new ArrayList<>();
	        for (int i = 0; i < orderInfoList.size(); i++) {
	        	String row=orderInfoList.get(i);
	        	ChnTxnBean chnTxnBean=new ChnTxnBean();
				String[] cell=row.split(",");
				chnTxnBean.setInstiid(instiid);
				chnTxnBean.setBusicode(busiType.contains("D")?Constants.BusinessType.SINGLE_COLLECT:Constants.BusinessType.SINGLE_PAY);//TODO:这里出现的是C或者D  需要对应成数据库编码
				chnTxnBean.setChargingunit(organization);
				chnTxnBean.setTransdate(cell[0]);
				chnTxnBean.setTxid(cell[1]);
				chnTxnBean.setCreditorbranchcode(cell[5]);
				chnTxnBean.setCreditoraccountno(cell[6]);
				chnTxnBean.setCreditorname(cell[7]);
				chnTxnBean.setDebtorbranchcode(cell[2]);
				chnTxnBean.setDebtoraccountno(cell[3]);
				chnTxnBean.setDebtorname(cell[4]);
				chnTxnBean.setCurrencysymbol(Constants.CurrencyType.RMB);
				chnTxnBean.setAmount(cell[8].replace("RMB", ""));
				chnTxnBean.setBillnumber(cell[9]);
				chnTxnBean.setRspcode(cell[10]);
				chnTxnBean.setSettledate(cell[13]);
				list.add(chnTxnBean);
			}
	        String returnStr=uploadlogService.importBatch(list);
	        resMap.put("msg", returnStr);
	    } catch (Exception e) {
	        e.printStackTrace();
	        resMap.put("msg", "出错");
	    }
	    return resMap;
	}
	
}
