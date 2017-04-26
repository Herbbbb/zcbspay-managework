package com.zcbspay.platform.manager.reconcilication.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.cnaps.application.bean.DetailCheckBean;
import com.zcbspay.platform.cnaps.application.bean.DetailCheckPaymentInformation;
import com.zcbspay.platform.cnaps.application.bean.ResultBean;
import com.zcbspay.platform.cnaps.application.bean.TotalCheckBean;
import com.zcbspay.platform.cnaps.application.bean.TotalCheckMessageBean;
import com.zcbspay.platform.cnaps.application.bean.TotalCheckPaymentBean;
import com.zcbspay.platform.cnaps.application.service.CheckBillService;
import com.zcbspay.platform.manager.constants.Constants;
import com.zcbspay.platform.manager.reconcilication.service.CheckInfoService;
import com.zcbspay.platform.manager.utils.BeanCopyUtil;
import com.zcbspay.platform.manager.utils.DateUtils;

@Service("checkInfoService")
public class CheckInfoServiceImpl implements CheckInfoService {

	
	@Autowired
	private CheckBillService checkBillService;
	
	@Override
	public String sayHello() {
		return "hi man";
	}

	@Override
	public ResultBean queryCheckInfoTotal(String checkInfoDate) {
		
		if (StringUtils.isNotBlank(checkInfoDate)) {
			checkInfoDate=checkInfoDate.replace("-", "");
		}else{
			checkInfoDate=DateUtils.getReqDateyyyyMMdd(DateUtils.addDay(new Date(), -1));
		}
		//TODO:业务处理
		//return checkBillService.totalCheckInformation(checkInfoDate);
		
		
		ResultBean resultBean =new ResultBean();
		resultBean.setResultBool(true);
		TotalCheckBean totalCheckBean=new TotalCheckBean();
		
		List<TotalCheckPaymentBean> totalCheckPaymentList=new ArrayList<>();
		TotalCheckPaymentBean totalCheckPaymentBean1=new TotalCheckPaymentBean();
		totalCheckPaymentBean1.setMessageType("1");
		totalCheckPaymentBean1.setProcessStatus("1");
		totalCheckPaymentBean1.setReceiveTotalAmount("1");
		totalCheckPaymentBean1.setReceiveTotalCount("1");
		totalCheckPaymentBean1.setSendTotalAmount("1");
		totalCheckPaymentBean1.setSendTotalCount("1");
		totalCheckPaymentBean1.setTransactionNettingDate("1");
		totalCheckPaymentBean1.setTransactionNettingRound("1");
		totalCheckPaymentList.add(totalCheckPaymentBean1);
		
		TotalCheckPaymentBean totalCheckPaymentBean2=new TotalCheckPaymentBean();
		totalCheckPaymentBean2.setMessageType("2");
		totalCheckPaymentBean2.setProcessStatus("2");
		totalCheckPaymentBean2.setReceiveTotalAmount("2");
		totalCheckPaymentBean2.setReceiveTotalCount("2");
		totalCheckPaymentBean2.setSendTotalAmount("2");
		totalCheckPaymentBean2.setSendTotalCount("2");
		totalCheckPaymentBean2.setTransactionNettingDate("2");
		totalCheckPaymentBean2.setTransactionNettingRound("2");
		totalCheckPaymentList.add(totalCheckPaymentBean2);
		
		
		List<TotalCheckMessageBean> totalCheckMessageList=new ArrayList<>();
		TotalCheckMessageBean totalCheckMessageBean=new TotalCheckMessageBean();
		totalCheckMessageBean.setMessageType("1");
		totalCheckMessageBean.setReceiveDate("1");
		totalCheckMessageBean.setReceiveTotalCount("1");
		totalCheckMessageBean.setSendTotalCount("1");
		totalCheckMessageList.add(totalCheckMessageBean);
		totalCheckBean.setTotalCheckMessageList(totalCheckMessageList);
		totalCheckBean.setTotalCheckPaymentList(totalCheckPaymentList);
		resultBean.setResultObj(totalCheckBean);
		totalCheckBean.setCheckDate("2017年3月1日 12:03:09");
		return resultBean;
		
	}

	@Override
	public ResultBean queryCheckInfoDetail(TotalCheckPaymentBean totalCheckPaymentBean, String checkDate) {
		
		DetailCheckPaymentInformation detailCheckPaymentInformation=BeanCopyUtil.copyBean(DetailCheckPaymentInformation.class,totalCheckPaymentBean);
		
		detailCheckPaymentInformation.setCheckDate(checkDate);
		detailCheckPaymentInformation.setSendReceiveType(Constants.SendReceiveType.RECEIVE);
		detailCheckPaymentInformation.setNumberOfTransactions(totalCheckPaymentBean.getReceiveTotalCount());
		
		DetailCheckBean detailCheckBean=new DetailCheckBean();
		detailCheckBean.setDetailCheckPaymentInformation(detailCheckPaymentInformation);
		//TODO:接受的业务
		//return checkBillService.detailCheck(detailCheckBean);
		
		detailCheckPaymentInformation.setSendReceiveType(Constants.SendReceiveType.SEND);
		detailCheckPaymentInformation.setNumberOfTransactions(totalCheckPaymentBean.getSendTotalCount());
		//TODO:发送的业务
		//return checkBillService.detailCheck(detailCheckBean);
		
		ResultBean resultBean = new ResultBean();
		resultBean.setSuccessResultDto("成功了");
		return resultBean;
	}
	
	


}
