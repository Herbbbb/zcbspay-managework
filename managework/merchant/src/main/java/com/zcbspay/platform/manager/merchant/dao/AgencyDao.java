package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.bean.CertType;
import com.zcbspay.platform.manager.merchant.bean.EnterpriseDetaApplyBean;
import com.zcbspay.platform.manager.merchant.bean.MerchDetaApplyBean;
import com.zcbspay.platform.manager.merchant.pojo.PojoEnterpriseDetaApply;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchDetaApply;

public interface AgencyDao extends BaseDAO<PojoMerchDetaApply>{

	/**
	 * 查询所有商户
	 * @return
	 */
	List<?> queryMerchParent();

	/**
	 * 商户信息管理（查询，修改，查看详情）页面
	 * @param variables
	 * @param page
	 * @param rows
	 * @return
	 */
	Map<String, Object> findMerchByPage(Map<String, Object> variables, Integer page, Integer rows);

	/**
	 * 保存商户信息
	 * @param merchDeta
	 * @return
	 */
	List<?> saveMerchDeta(MerchDetaApplyBean merchDeta,EnterpriseDetaApplyBean enterprise);

	/**
	 * 县
	 * @param pid
	 * @return
	 */
	List<?> queryCounty(Long pid);

	/**
	 * 所属行业
	 * @return
	 */
	List<?> queryMerchType();

	/**
	 * 商户类型
	 * @return
	 */
	List<?> queryTrade();

	/**
	 * 商户清算类型
	 * @return
	 */
	List<?> querysetltype();

	/**
	 * 关键字查询开户行
	 * @param bankName
	 * @param page
	 * @param rows
	 * @return
	 */
	List<?> queryBankNode(String bankName, Integer page, Integer rows);

	/**
	 * 收银台版本
	 * @return
	 */
	List<?> queryCashAll();

	/**
	 * 交易渠道
	 * @return
	 */
	List<?> queryChnlnameAll();

	/**
	 * 路由版本
	 * @return
	 */
	List<?> queryRouteAll();

	/**
	 * 风控版本
	 * @param vid
	 * @return
	 */
	List<?> queryRiskType(String vid);

	/**
	 * 分润版本
	 * @param vid
	 * @return
	 */
	List<?> querySplit(String vid);

	/**
	 * 扣率版本
	 * @param vid
	 * @return
	 */
	List<?> queryFee(String vid);

	/**
	 * 清算周期
	 * @return
	 */
	List<?> querySetlcycleAll();

	/**
	 * 获取商户企业数据
	 * @param merchApplyId
	 * @return
	 */
	List<?> getBean(Long merchApplyId);

	/**
	 * 提交申请
	 * @param merchApplyId
	 * @return
	 */
	boolean commitMerch(String merchApplyId);

	/**
	 * 下载图片路径
	 * @param parseLong
	 * @param realpath
	 * @param format
	 * @param fouce
	 * @return
	 */
	String downloadFromFtp(PojoMerchDetaApply bean,PojoEnterpriseDetaApply enterpriseDeta, String targDir, CertType certType, boolean fouce);

	/**
	 * 修改商户信息
	 * @param merchApplyId
	 * @param merchDeta
	 * @return
	 */
	List<?> saveChangeMerchDeta(String merchApplyId, MerchDetaApplyBean merchDeta,EnterpriseDetaApplyBean enterpriseDeta);

	/**
	 * 查询银行账户
	 * @param bankNode
	 * @param bankCode
	 * @return
	 */
	String queryBankName(String bankNode, String bankCode);

	/**
	 * 查看商户详情
	 * @param merchApplyId
	 * @param userId
	 * @return
	 */
	Map<String, Object> queryApplyMerchDeta(String merchApplyId, Long userId);

	/**
	 * 商户审核
	 * @param merchApplyId
	 * @param merchDeta
	 * @param memId
	 * @param flag
	 * @param isAgree
	 * @return
	 */
	List<Map<String, Object>> merchAudit(String merchApplyId, MerchDetaApplyBean merchDeta, String memId, String flag,
			String isAgree);
	
	/**
	 * 复审--添加风控
	 * @param memberId
	 * @param riskVer
	 */
	void updateMerch(String memberId, String riskVer);

}
