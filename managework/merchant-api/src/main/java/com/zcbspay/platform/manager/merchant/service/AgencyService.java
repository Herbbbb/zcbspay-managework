package com.zcbspay.platform.manager.merchant.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.merchant.bean.AgencyInfoBean;
import com.zcbspay.platform.manager.merchant.bean.CertType;
import com.zcbspay.platform.manager.merchant.bean.EnterpriseDetaApplyBean;
import com.zcbspay.platform.manager.merchant.bean.MerchDetaApplyBean;
@SuppressWarnings("all")
public interface AgencyService {

	/**
	 * 所属商户
	 * @return
	 */
	public List<?> queryMerchParent();
	
	/**
	 * 商户类型
	 * @return
	 */
	public List<?> queryMerchType();
	
	/**
	 * 所属行业
	 * @return
	 */
	public List<?> queryTrade();
	
	/**
	 * 商户清算类型
	 * @return
	 */
	public List<?> querysetltype();

	/**
	 * 商户信息管理（查询，修改，查看详情）页面
	 * @param variables
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> findMerchByPage(Map<String, Object> variables, Integer page, Integer rows);

	/**
	 * 保存商户信息
	 * @param merchDeta
	 * @return
	 */
	public List<?> saveMerchDeta(MerchDetaApplyBean merchDeta,EnterpriseDetaApplyBean enterprise);

	/**
	 * 县
	 * @param pid
	 * @return
	 */
	public List<?> queryCounty(Long pid);

	/**
	 * 关键字查询开户行
	 * @param bankName
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<?> queryBankNode(String bankName, Integer page, Integer rows);

	/**
	 * 收银台版本
	 * @return
	 */
	public List<?> queryCashAll();

	/**
	 * 交易渠道
	 * @return
	 */
	public List<?> queryChnlnameAll();

	/**
	 * 路由版本
	 * @return
	 */
	public List<?> queryRouteAll();

	/**
	 * 风控版本
	 * @param vid
	 * @return
	 */
	public List<?> queryRiskType(String vid);

	/**
	 * 分润版本
	 * @param vid
	 * @return
	 */
	public List<?> querySplit(String vid);

	/**
	 * 扣率版本
	 * @param vid
	 * @return
	 */
	public List<?> queryFee(String vid);

	/**
	 * 清算周期
	 * @return
	 */
	public List<?> querySetlcycleAll();

	/**
	 * 获取商户个人企业信息
	 * @param parseLong
	 * @return
	 */
	public MerchDetaApplyBean getBean(Long merchApplyId);

	/**
	 * 
	 * 上传照片
	 * @param parseLong
	 * @param headImageFileName
	 * @param headImage
	 * @param certType
	 * @return
	 */
	public boolean upload(String merchApplyId, String path, CertType certType);

	/**提交申请
	 * @param parseLong
	 * @return
	 */
	public boolean commitMerch(String merchApplyId);

	/**
	 * 下载图片路径
	 * @param merchApplyId
	 * @param format
	 * @return
	 */
	public String downloadFromFtp(String merchApplyId, CertType format);

	/**
	 * 修改商户信息
	 * @param merchApplyId
	 * @param merchDeta
	 * @return
	 */
	public List<?> saveChangeMerchDeta(String merchApplyId, MerchDetaApplyBean merchDeta,EnterpriseDetaApplyBean enterpriseDeta);

	/**
	 * 查询银行账户
	 * @param bankNode
	 * @param bankCode
	 * @return
	 */
	public String queryBankName(String bankNode, String bankCode);

	/**
	 * 查看商户详情
	 * @param parseLong
	 * @param userId
	 * @return
	 */
	public Map<String, Object> queryApplyMerchDeta(String merchApplyId, Long userId);

	/**
	 * 商户审核
	 * @param merchApplyId
	 * @param merchDeta
	 * @param memId
	 * @param flag
	 * @param isAgree
	 * @return
	 */
	public List<Map<String, Object>> merchAudit(String merchApplyId, MerchDetaApplyBean merchDeta, String memId,
			String flag, String isAgree);
	
	/**
	 * 复审--添加风控
	 * @param memberId
	 * @param riskVer
	 */
	public void updateMerch(String memberId, String riskVer);

	/**
	 * 保存业务收费信息
	 * @param bean
	 * @return
	 */
	public Map<String, Object> saveAgencyInfo(AgencyInfoBean bean);

	/**
	 * 查询业务收费信息
	 * @param merchNo
	 * @return
	 */
	public List<?> queryByMerchNo(String merchNo);

	/**
	 * 修改业务收费信息
	 * @param bean
	 * @return
	 */
	public Map<String, Object> updateAgencyInfo(AgencyInfoBean bean);

	/**
	 * 查询业务收费信息
	 * @param merchNo
	 * @param bustCode 
	 * @return
	 */
	public AgencyInfoBean queryByCode(String merchNo, String bustCode);

}
