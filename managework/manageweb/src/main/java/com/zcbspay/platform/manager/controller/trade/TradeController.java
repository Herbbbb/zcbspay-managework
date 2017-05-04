package com.zcbspay.platform.manager.controller.trade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.manager.trade.bean.BatchCollectOrderBean;
import com.zcbspay.platform.manager.trade.bean.BatchPaymentOrderBean;
import com.zcbspay.platform.manager.trade.bean.ChnCollectBatchBean;
import com.zcbspay.platform.manager.trade.bean.ChnCollectSingleLogBean;
import com.zcbspay.platform.manager.trade.bean.ChnPaymentBatchBean;
import com.zcbspay.platform.manager.trade.bean.ChnPaymentSingleLogBean;
import com.zcbspay.platform.manager.trade.bean.CnapsLogBean;
import com.zcbspay.platform.manager.trade.bean.CollectAndPaymentBean;
import com.zcbspay.platform.manager.trade.bean.OrderInfoBean;
import com.zcbspay.platform.manager.trade.bean.RealTimeCollectOrderBean;
import com.zcbspay.platform.manager.trade.bean.RealTimePaymentOrderBean;
import com.zcbspay.platform.manager.trade.bean.TxnsLogBean;
import com.zcbspay.platform.manager.trade.service.BusinessService;
import com.zcbspay.platform.manager.trade.service.ChnlDetaService;
import com.zcbspay.platform.manager.trade.service.TradeService;
import com.zcbspay.platform.manager.utils.UserHelper;

@Controller
@RequestMapping("/trade/")
public class TradeController {

	@Autowired
	private BusinessService businessService;

	@Autowired
	private ChnlDetaService chnlDetaService;

	@Autowired
	private TradeService txnsLogService;

	/**
	 * 核心交易流水查询页面
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年2月27日 16:48:00
	 * @version v1.0
	 */
	@RequestMapping("showTxnsLog")
	public String showTxnsLog(Model model) {
		model.addAttribute("bus", businessService.getAllBusiness());
		model.addAttribute("channel", chnlDetaService.getAllChannelCodeList());
		return "trade/txns_log";
	}
	/**
	 * 交易订单查询页面
	 * @author: zhangshd
	 * @param model
	 * @return String
	 * @date: 2017年3月6日 上午10:09:39 
	 * @version v1.0
	 */
	@RequestMapping("showTxnsOrderInfo")
	public String showTxnsOrderInfo(Model model) {
		return "trade/txns_orderinfo";
	}
	
	/**
	 * CNAPS核心交易流水页面
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年2月27日 16:48:00
	 * @version v1.0
	 */
	@RequestMapping("showCnapsLog")
	public String showCnapsLog(Model model) {
		return "trade/cnaps_log";
	}
	
	/**
	 * BEPS批量代收交易流水查询
	 * @author: zhangshd
	 * @param model
	 * @return String
	 * @date: 2017年3月7日 下午2:43:33 
	 * @version v1.0
	 */
	@RequestMapping("showBepsCollectBatch")
	public String showBepsCollectBatch(Model model) {
		return "trade/beps_collect_batch";
	}
	
	/**
	 * BEPS批量代付交易流水查询
	 * @author: zhangshd
	 * @param model
	 * @return String
	 * @date: 2017年3月8日 下午2:27:03 
	 * @version v1.0
	 */
	@RequestMapping("showBepsPaymentBatch")
	public String showBepsPaymentBatch(Model model) {
		return "trade/beps_payment_batch";
	}
	
	
	
	
	@RequestMapping("showBepsPaymentSingle")
	public String showBepsPaymentSingle(Model model) {
		return "trade/beps_payment_single";
	}
	
	
	
	
	@RequestMapping("showBepsCollectSingle")
	public String showBepsCollectSingle(Model model) {
		return "trade/beps_collect_single";
	}
	
	
	/**
	 * 实时代收界面
	 * @author: zhangshd
	 * @param model
	 * @return String
	 * @date: 2017年3月29日 下午5:08:51 
	 * @version v1.0
	 */
	@RequestMapping("showRealtimeCollect")
	public String showRealtimeCollect(Model model) {
		return "trade/single_collect_order_query";
	}
	
	/**
	 * 实时代付界面
	 * @author: zhangshd
	 * @param model
	 * @return String
	 * @date: 2017年3月29日 下午5:09:06 
	 * @version v1.0
	 */
	@RequestMapping("showRealtimePayment")
	public String showRealtimePayment(Model model) {
		return "trade/single_payment_order_query";
	}
	
	/**
	 * 批量代收界面
	 * @author: zhangshd
	 * @param model
	 * @return String
	 * @date: 2017年3月29日 下午5:09:13 
	 * @version v1.0
	 */
	@RequestMapping("showBatchCollect")
	public String showBatchCollect(Model model) {
		return "trade/batch_collect_order_query";
	}
	/**
	 * 批量代付界面
	 * @author: zhangshd
	 * @param model
	 * @return String
	 * @date: 2017年3月29日 下午5:09:22 
	 * @version v1.0
	 */
	@RequestMapping("showBatchPayment")
	public String showBatchPayment(Model model) {
		return "trade/batch_payment_order_query";
	}
	
	/**
	 * 分页查询核心交易流水
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年3月2日 下午3:14:43
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getTxnsLogByPage")
	public Map<String, Object> getTxnsLogByPage(TxnsLogBean values, String page, String rows,
			HttpServletRequest request) {
		values.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getTxnsLogByPage(page, rows, values);
	}
	/**
	 * BEPS批量代收交易流水查询分页查询
	 * @author: zhangshd
	 * @param values
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月7日 下午3:38:02 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getBepsCollectBatchByPage")
	public Map<String, Object> getBepsCollectBatchByPage(CollectAndPaymentBean collectBatchBean, String page, String rows,
			HttpServletRequest request) {
		collectBatchBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getBepsCollectBatchByPage(page, rows, collectBatchBean);
	}
	/**
	 * BEPS批量代付交易流水查询分页查询
	 * @author: zhangshd
	 * @param values
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月7日 下午3:38:02 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getBepsPaymentBatchByPage")
	public Map<String, Object> getBepsPaymentBatchByPage(CollectAndPaymentBean collectBatchBean, String page, String rows,
			HttpServletRequest request) {
		collectBatchBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getBepsPaymentBatchByPage(page, rows, collectBatchBean);
	}
	
	
	
	/**
	 * BEPS实时代付交易流水查询
	 * @author: zhangshd
	 * @param collectBatchBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月9日 上午11:27:29 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getBepsPaymentSingleByPage")
	public Map<String, Object> getBepsPaymentSingleByPage(CollectAndPaymentBean collectBatchBean, String page, String rows,
			HttpServletRequest request) {
		collectBatchBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getBepsPaymentSingleByPage(page, rows, collectBatchBean);
	}
	
	
	
	/**
	 * 实时代付订单查询
	 * @author: zhangshd
	 * @param realTimePaymentOrderBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月29日 下午6:01:30 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getRealTimePaymentOrderByPage")
	public Map<String, Object> getRealTimePaymentOrderByPage(RealTimePaymentOrderBean realTimePaymentOrderBean, String page, String rows,
			HttpServletRequest request) {
		realTimePaymentOrderBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getRealTimePaymentOrderByPage(page, rows, realTimePaymentOrderBean);
	}
	/**
	 * 实时代收订单查询
	 * @author: zhangshd
	 * @param realTimeCollectOrderBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月29日 下午6:01:56 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getRealTimeCollectOrderByPage")
	public Map<String, Object> getRealTimeCollectOrderByPage(RealTimeCollectOrderBean realTimeCollectOrderBean, String page, String rows,
			HttpServletRequest request) {
		realTimeCollectOrderBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getRealTimeCollectOrderByPage(page, rows, realTimeCollectOrderBean);
	}
	
	
	/**
	 * 实时代付订单查询
	 * @author: zhangshd
	 * @param realTimePaymentOrderBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月29日 下午6:01:30 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getBatchPaymentOrderByPage")
	public Map<String, Object> getBatchPaymentOrderByPage(BatchPaymentOrderBean batchPaymentOrderBean, String page, String rows,
			HttpServletRequest request) {
		batchPaymentOrderBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getBatchPaymentOrderByPage(page, rows, batchPaymentOrderBean);
	}
	/**
	 * 实时代收订单查询
	 * @author: zhangshd
	 * @param realTimeCollectOrderBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月29日 下午6:01:56 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getBatchCollectOrderByPage")
	public Map<String, Object> getBatchCollectOrderByPage(BatchCollectOrderBean batchCollectOrderBean, String page, String rows,
			HttpServletRequest request) {
		batchCollectOrderBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getBatchCollectOrderByPage(page, rows, batchCollectOrderBean);
	}
	
	
	@ResponseBody
	@RequestMapping("getCollectOrderDetaByBatchNo")
	public Map<String, Object> getCollectOrderDetaByBatchNo(BatchCollectOrderBean batchCollectOrderBean, String page, String rows,
			HttpServletRequest request) {
		batchCollectOrderBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getCollectOrderDetaByBatchNo(page, rows, batchCollectOrderBean);
	}
	
	@ResponseBody
	@RequestMapping("getPaymentOrderDetaByBatchNo")
	public Map<String, Object> getPaymentOrderDetaByBatchNo(BatchPaymentOrderBean batchPaymentOrderBean, String page, String rows,
			HttpServletRequest request) {
		batchPaymentOrderBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getPaymentOrderDetaByBatchNo(page, rows, batchPaymentOrderBean);
	}
	
	/**
	 * BEPS实时代收交易流水查询
	 * @author: zhangshd
	 * @param collectBatchBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月9日 上午11:27:13 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getBepsCollectSingleByPage")
	public Map<String, Object> getBepsCollectSingleByPage(CollectAndPaymentBean collectBatchBean, String page, String rows,
			HttpServletRequest request) {
		collectBatchBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getBepsCollectSingleByPage(page, rows, collectBatchBean);
	}
	
	/**
	 * BEPS批量代收交易流水详细信息分页查询
	 * @author: zhangshd
	 * @param collectBatchBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月7日 下午3:45:49 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryCollectDetail")
	public Map<String, Object> queryCollectDetail(CollectAndPaymentBean collectBatchBean, String page, String rows,
			HttpServletRequest request) {
		collectBatchBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.queryDetail(page, rows, collectBatchBean);
	}
	
	/**
	 * BEPS批量代付交易流水详细信息分页查询
	 * @author: zhangshd
	 * @param collectBatchBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月8日 下午2:39:04 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryPaymentDetail")
	public Map<String, Object> queryPaymentDetail(CollectAndPaymentBean collectBatchBean, String page, String rows,
			HttpServletRequest request) {
		collectBatchBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.queryPaymentDetail(page, rows, collectBatchBean);
	}
	
	
	/**
	 * CNAPS核心交易分页查询
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年3月2日 下午3:14:43
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getCnapsLogByPage")
	public Map<String, Object> getCnapsLogByPage(CnapsLogBean values, String page, String rows,
			HttpServletRequest request) {
		values.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getCnapsLogByPage(page, rows, values);
	}
	/**
	 * 
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年3月2日 下午3:14:43
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getOrderInfoByPage")
	public Map<String, Object> getOrderInfoByPage(OrderInfoBean values, String page, String rows,
			HttpServletRequest request) {
		values.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return txnsLogService.getOrderInfoByPage(page, rows, values);
	}
	/**
	 * 获取交易流水详细信息
	 * @author: zhangshd
	 * @param txnseqno
	 * @return Map<String,Object>
	 * @date: 2017年3月3日 上午11:04:33 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getTxnsLogByTxnseqno")
	public Map<String, Object> getTxnsLogByTxnseqno(String txnseqno) {
		String messg=null;   
		Map<String, Object> map = new HashMap<String, Object>();
		List<?> li = txnsLogService.getTxnsLogById(txnseqno);
		if (li == null || li.isEmpty()) {
			messg = "交易数据不存在";
			map.put("messg", messg);
		} else {
			map.put("json", li.get(0));
		}
		return map;
	}
	
	/**
	 * 获取订单详细信息
	 * @author: zhangshd
	 * @param txnseqno
	 * @return Map<String,Object>
	 * @date: 2017年3月3日 上午11:04:33 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getOrderInfoDetail")
	public Map<String, Object> getOrderInfoDetail(String id) {
		String messg=null;   
		Map<String, Object> map = new HashMap<String, Object>();
		List<?> li = txnsLogService.getOrderInfoDetail(id);
		if (li == null || li.isEmpty()) {
			messg = "交易数据不存在";
			map.put("messg", messg);
		} else {
			map.put("json", li.get(0));
		}
		return map;
	}
	/**
	 * 实时代收渠道流水查询界面
	 * @author: 张连海
	 * @param model
	 * @return String
	 * @date: 2017年4月26日 
	 * @version v1.0
	 */
	@RequestMapping("showChnCollectSingleLog")
	public String showChnCollectSingleLog() {
		return "trade/chn_collect_single_log_query";
	}
	
	/**
	 * 实时代收渠道流水查询
	 * @author: 张连海
	 * @param chnCollectSingleLogBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年4月27日
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getChnCollectSingleLogByPage")
	public Map<String, Object> getChnCollectSingleLogByPage(ChnCollectSingleLogBean chnCollectSingleLogBean, String page, String rows,
			HttpServletRequest request) {
		chnCollectSingleLogBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return chnlDetaService.getChnCollectSingleLogByPage(page, rows, chnCollectSingleLogBean);
	}
	
	/**
	 * 实时代付渠道流水查询界面
	 * @author: 张连海
	 * @param model
	 * @return String
	 * @date: 2017年4月26日 
	 * @version v1.0
	 */
	@RequestMapping("showChnPaymentSingleLog")
	public String showChnPaymentSingleLog() {
		return "trade/chn_payment_single_log_query";
	}
	
	/**
	 * 实时代付渠道流水查询
	 * @author: 张连海
	 * @param chnPaymentSingleLogBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年4月27日
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getChnPaymentSingleLogByPage")
	public Map<String, Object> getChnPaymentSingleLogByPage(ChnPaymentSingleLogBean chnPaymentSingleLogBean, String page, String rows,
			HttpServletRequest request) {
		chnPaymentSingleLogBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return chnlDetaService.getChnPaymentSingleLogByPage(page, rows, chnPaymentSingleLogBean);
	}	
	
	
	/**
	 * 批量代收渠道流水查询界面
	 * @author: 张连海
	 * @param model
	 * @return String
	 * @date: 2017年4月26日 
	 * @version v1.0
	 */
	@RequestMapping("showChnCollectBatchLog")
	public String showChnCollectBatchLog() {
		return "trade/chn_collect_batch_log_query";
	}
	
	/**
	 * 批量代收渠道流水查询
	 * @author: 张连海
	 * @param chnCollectBatchBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年4月27日 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getChnCollectBatchLogByPage")
	public Map<String, Object> getChnCollectBatchLogByPage(ChnCollectBatchBean chnCollectBatchBean, String page, String rows,
			HttpServletRequest request) {
		chnCollectBatchBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return chnlDetaService.getChnCollectBatchLogByPage(page, rows, chnCollectBatchBean);
	}
	
	/**
	 * 查询代收批次明细交易信息
	 * @author: 张连海
	 * @param chnCollectBatchBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年4月27日 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getChnCollectDetaByBatchNo")
	public Map<String, Object> getChnCollectDetaByBatchNo(ChnCollectBatchBean chnCollectBatchBean, String page, String rows,
			HttpServletRequest request) {
		chnCollectBatchBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return chnlDetaService.getChnCollectDetaByBatchNo(page, rows, chnCollectBatchBean);
	}
	
	/**
	 * 批量代付渠道流水查询界面
	 * @author: 张连海
	 * @param model
	 * @return String
	 * @date: 2017年4月26日 
	 * @version v1.0
	 */
	@RequestMapping("showChnPaymentBatchLog")
	public String showChnPaymentBatchLog() {
		return "trade/chn_payment_batch_log_query";
	}
	
	/**
	 * 批量代收渠道流水查询
	 * @author: 张连海
	 * @param chnPaymentBatchBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年4月27日 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getChnPaymentBatchLogByPage")
	public Map<String, Object> getChnPaymentBatchLogByPage(ChnPaymentBatchBean chnPaymentBatchBean, String page, String rows,
			HttpServletRequest request) {
		chnPaymentBatchBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return chnlDetaService.getChnPaymentBatchLogByPage(page, rows, chnPaymentBatchBean);
	}
	
	/**
	 * 查询代收批次明细交易信息
	 * @author: 张连海
	 * @param chnPaymentBatchBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年4月27日 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("getChnPaymentDetaByBatchNo")
	public Map<String, Object> getChnPaymentDetaByBatchNo(ChnPaymentBatchBean chnPaymentBatchBean, String page, String rows,
			HttpServletRequest request) {
		chnPaymentBatchBean.setUserId(UserHelper.getCurrentUser(request).getUserId());
		return chnlDetaService.getChnPaymentDetaByBatchNo(page, rows, chnPaymentBatchBean);
	}
}

