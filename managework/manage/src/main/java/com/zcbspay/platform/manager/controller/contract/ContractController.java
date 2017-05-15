package com.zcbspay.platform.manager.controller.contract;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.zcbspay.platform.manager.merchant.bean.ContractBean;
import com.zcbspay.platform.manager.merchant.service.ContractService;
import com.zcbspay.platform.manager.system.bean.UserBean;
import com.zcbspay.platform.manager.utils.FTPUtils;
import com.zcbspay.platform.manager.utils.ReadExcle;

@Controller
@RequestMapping("/contract")
@SuppressWarnings("all")
public class ContractController {

	@Autowired
	private ContractService contractService;
	
	@ResponseBody
    @RequestMapping("/show")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/contract/contract_add");
        return result;
    }
	@ResponseBody
	@RequestMapping("/showAudit")
	public ModelAndView showAuditQuery(HttpServletRequest request) {
		ModelAndView result=new ModelAndView("/contract/contract_edit");
		return result;
	}
	
	/**
	 * 查询
	 * @param bankAccout
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/query")
	public Map<String, Object> query(String merchNo, String contractNum, String debName,
			String debAccNo, String credName, String credAccNo,
			Integer page, Integer rows,
    		HttpServletRequest request, String flag) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("merchNo", merchNo);
        variables.put("contractNum", contractNum);
        variables.put("debName", debName);
        variables.put("debAccNo", debAccNo); 
        variables.put("credName", credName);
        variables.put("credAccNo", credAccNo);
        return contractService.findAll(variables, page, rows);
    }
	/**
	 * 审核查询
	 * @param bankAccout
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryAudit")
	public Map<String, Object> queryAudit(ContractBean contract,Integer page, Integer rows,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<?> list = contractService.findAllAccout(contract,page, rows);
		Integer total= contractService.findAllCont(contract);
		result.put("total", total);
		result.put("rows", list);
		return result;
	}
	
	
	/**
	 * 新增用户信息
	 * @param request
	 * @param bankAccout
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public Map<String, Object> save(HttpServletRequest request,ContractBean contract) {
		Map<String, String> result = new HashMap<String, String>();
		UserBean loginUser = (UserBean)request.getSession().getAttribute("LOGIN_USER");
		contract.setInUser(loginUser.getUserId());
		if (contract.getFileAddress() == null || contract.getFileAddress().equals("")) {
			return null;
		}
        return contractService.addContract(contract);
	}
	
	/**
	 * 查询商户信息
	 * @param request
	 * @param tId
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/findById")
	public ContractBean findById(HttpServletRequest request,String tId) {
		return contractService.findById(tId);
	}
	
	/**
	 * 删除信息
	 * @param bankAccout
	 * @return queryCity
	 * @throws ParseException 
	 */
	@ResponseBody
    @RequestMapping("/delect")
	public Map<String, Object> delect(String tId,String withdrawOpt,String revocationDate,HttpServletRequest request) throws ParseException {
		Map<String, String> result = new HashMap<String, String>();
		UserBean loginUser = (UserBean)request.getSession().getAttribute("LOGIN_USER");
		ContractBean bean = contractService.findById(tId);
		bean.setStatus("99");
		bean.setWithdrawUser(loginUser.getUserId());
		bean.setWithdrawOpt(withdrawOpt);
		bean.setRevocationDate(revocationDate);
        return contractService.eidtContract(bean);
	}
	
	
    /**
     * @return
     */
    @ResponseBody
	@RequestMapping("/downloadImgUrl")
    public Map<String, String> downloadImgUrl(HttpServletRequest request, String fouceDownload, String tId, String certTypeCode) { 
    	ContractBean bean = contractService.findById(tId);
    	String filePath = bean.getFileAddress();
        Map<String, String> result = new HashMap<String, String>();
        if (bean == null) {
            result.put("status", "fail");
        } else if (bean.equals("")) {
            result.put("status", "notExist");
        } else {
        	filePath = "ftp:192.168.2.116/"+filePath;
            result.put("status", "OK");
            result.put("url", filePath);
        }
        return result;
    }
	
    @ResponseBody
	@RequestMapping("/fileUpload")
    public Map<String, String> fileUpload(HttpServletRequest request,String tId) throws Exception{
    	
    	Map<String, String> result = new HashMap<String, String>();
    	//上传文件解析器
    	CommonsMultipartResolver mutiparRe = new CommonsMultipartResolver();
    	//如果是文件类型的请求
    	if (mutiparRe.isMultipart(request)) {
    		
			MultipartHttpServletRequest mhr = (MultipartHttpServletRequest) request;
			//获取路径
			String uploadDir = request.getSession().getServletContext().getRealPath("/")+"javaCode\\";
			//如果目录不存在，创建一个目录
			if (!new File(uploadDir).exists()) {
				File dir = new File(uploadDir);
				dir.mkdirs();
			}
			//迭代文件名称
			Iterator<String> it = mhr.getFileNames();
			while(it.hasNext()){
				//获取下一个文件
				MultipartFile mf = mhr.getFile(it.next());
				if (mf !=null) {
					//原文件名称
					String resFileName = mf.getOriginalFilename();
					//保存文件名
					
//					String fileName = rename(resFileName);
					//路径＋文件名
					File outFile = new File(uploadDir+"/"+resFileName);
//					String path = "javaCode/"+resFileName;
					
					mf.transferTo(outFile);
					String fileName = UUID.randomUUID().toString().replace("-", "") + resFileName.substring(resFileName.lastIndexOf("."));
					String path = "ftp:192.168.2.116/"+fileName;
					FileInputStream in=new FileInputStream(outFile);  
			        boolean flag = FTPUtils.uploadFile("192.168.2.116", 21, "DownLoad", "624537", "E:ftp","/",fileName , in);
					result.put("status", "OK");
					result.put("path", path);
					result.put("fileName", fileName);
				}else{
					result.put("status", "FAIL");
				}
			}
		}
    	return result;
    }
    
    /**
     * 合同审核（通过，否决，驳回） --0 通过 1 拒绝 9 终止
     * @throws Exception
     */
    @ResponseBody
	@RequestMapping("/audit")
    public List<Map<String, Object>> audit(ContractBean contract,String tId, String isAgree, HttpServletRequest request) throws Exception {

        // 初审意见和复审意见，在页面中都是通过merchDate.stexaopt传过来的
        String stexopt = URLDecoder.decode(contract.getStexaOpt(), "utf-8");
        UserBean currentUser = (UserBean)request.getSession().getAttribute("LOGIN_USER");
    	ContractBean deta = contractService.findById(tId);
    	deta.setCvlexaOpt(stexopt);
    	deta.setCvlexaUser(currentUser.getUserId());
    	
        List<Map<String, Object>> resultlist = contractService.merchAudit(deta,isAgree);
        return resultlist;
    }
    
    /**
	 * 上传CSV文件并解析到数据库
	 * @param request
	 * @param fileUp 用户上传的input的name
	 * @param httpSession
	 * @return
	 */
    @RequestMapping("/excelImport")
	@ResponseBody
	public Map<String, Object> excelImport(HttpServletRequest request,HttpSession session,String instiid,
	        @RequestParam("orderCSV")MultipartFile fileUp,  HttpServletResponse response) {
	    Map<String, Object> resMap = new HashMap<String, Object>();
	    if(fileUp==null || fileUp.isEmpty()){
	    	 resMap.put("status", "error");
	        resMap.put("msg", "上传文件为空或没有数据");
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
	        File fileServer = new File(rootPath+"\\orderData\\"+(new Random().nextInt(100000)+100000)+fileUp.getOriginalFilename());
	        String fileName= fileUp.getOriginalFilename();
	        fileUp.transferTo(fileServer);
	        fileName=UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."));
	        
	        List<String[]> orderInfoList = ReadExcle.readXls(fileServer);
	        if(orderInfoList==null || orderInfoList.size()<=1 || orderInfoList.size()>10000){
	        	resMap.put("status", "error");
	            resMap.put("msg", "上传文件无数据或数据量过大");
	            return resMap;
	        }
	        UserBean user = (UserBean)request.getSession().getAttribute("LOGIN_USER");
	        List<ContractBean> list=new ArrayList<>();
	        for (int i = 0; i < orderInfoList.size(); i++) {
	        	ContractBean bean=new ContractBean();
				String[] cell=orderInfoList.get(i);
				bean.setMerchNo(cell[0]);
				bean.setContractNum(cell[1]);
				bean.setContractType(cell[2]);
				bean.setDebName(cell[3]);
				bean.setDebAccNo(cell[4]);
				bean.setDebBranchCode(cell[5]);
				bean.setDebAmoLimit(new BigDecimal(cell[6]).longValue());
//				bean.setDebAmoLimit(Long.parseLong(cell[6]));
				bean.setDebTranLimitType(cell[7]);
				bean.setDebAccyAmoLimit(new BigDecimal(cell[8]).longValue());
				bean.setDebTransLimitType(cell[9]);
				bean.setDebTransLimit(new BigDecimal(cell[10]).longValue());
				
				bean.setCredName(cell[11]);
				bean.setCredAccNo(cell[12]);
				bean.setCredBranchCode(cell[13]);
				bean.setCredAmoLimit(new BigDecimal(cell[14]).longValue());
				bean.setCredTranLimitType(cell[15]);
				bean.setCredAccuAmoLimit(new BigDecimal(cell[16]).longValue());
				bean.setCredTransLimitType(cell[17]);
				bean.setCredTransLimit(new BigDecimal(cell[18]).longValue());
				
				bean.setSignDate(cell[19]);
				bean.setExpiryDate(cell[20]);
				bean.setFileAddress(cell[21]);
				bean.setNotes(cell[22]);
				bean.setProprieTary(cell[23]);
				bean.setInUser(user.getUserId());
				bean.setFileName(fileName);;
				list.add(bean);
			}
	        List<StringBuffer> result=contractService.importBatch(list);
	        if (result.size() != 0) {
	        	resMap.put("status", "error");
	        	resMap.put("msg", result);
			}else if(result.size() < list.size()){
				FileInputStream in=new FileInputStream(fileServer);  
		        boolean flag = FTPUtils.uploadFile("192.168.2.116", 21, "DownLoad", "624537", "E:ftp","/",fileName , in);
			}else{
				resMap.put("status", "OK");
				resMap.put("msg", "成功");
			}
	    } catch (Exception e) {
	        e.printStackTrace();
	        resMap.put("status", "error");
	        resMap.put("msg", "出错");
	    }
	    return resMap;
	}
}
