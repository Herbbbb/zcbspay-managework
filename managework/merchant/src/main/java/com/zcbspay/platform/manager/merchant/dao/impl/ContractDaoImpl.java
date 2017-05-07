package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.bean.ContractBean;
import com.zcbspay.platform.manager.merchant.dao.ContractDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoContract;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchDetaApply;

@Repository
public class ContractDaoImpl extends HibernateBaseDAOImpl<PojoContract> implements ContractDao {

	@Override
	public Map<String, Object> findAll(Map<String, Object> variables, int page, int rows) {
		String[] columns = new String[]{"v_merchno", "v_contractnum",
                "v_debtorname", "v_debtoraccountno", "v_creditorname",
                "v_creditoraccountno","i_no", "i_perno"};

        Object[] paramaters = new Object[]{
                variables.containsKey("merchNo") ? variables.get("merchNo") : null,
                variables.containsKey("contractNum") ? variables.get("contractNum") : null,
                variables.containsKey("debName") ? variables.get("debName") : null,
                variables.containsKey("debAccNo") ? variables.get("debAccNo") : null,
                variables.containsKey("credName") ? variables.get("credName") : null,
                variables.containsKey("credAccNo") ? variables.get("credAccNo") : null,
                page, rows};
        return executePageOracleProcedure("{CALL PCK_T_CONTRACT.sel_t_contract(?,?,?,?,?,?,?,?,?,?)}",
                columns, paramaters,"cursor0","v_total");
	}

	@Override
	public Map<String, Object> addContract(PojoContract pojo) {
        String[] columns = new String[]{"v_CONTRACTNUM", "v_MERCHNO",
                "v_DEBTORNAME", "v_DEBTORACCOUNTNO", "v_DEBTORBRANCHCODE",
                "v_CREDITORNAME", "v_CREDITORACCOUNTNO", "v_CREDITORBRANCHCODE", 
                "v_CONTRACTTYPE","v_DEBTORAMOUNTLIMIT", "v_DEBTORTRANSAMTLIMITTYPE",
                "v_DEBTORACCUAMOUNTLIMIT", "v_DEBTORTRANSNUMLIMITTYPE","v_DEBTORTRANSLIMIT",
                "v_CREDITORAMOUNTLIMIT", "v_CREDITORTRANSAMTLIMITTYPE", "v_CREDITORACCUAMOUNTLIMIT",
                "v_CREDITORTRANSNUMLIMITTYPE", "v_CREDITORTRANSLIMIT", "v_SIGNDATE", "v_EXPIRYDATE",
                "v_INUSER", "v_FILEADDRESS", "v_NOTES", "v_REMARKS",
                "v_filename", "v_PROPRIETARY","v_CATEGORYPURPOSE"};
        Object[] paramaters = null;
			paramaters = new Object[]{
			        "".equals(pojo.getContractNum()) ? null : pojo.getContractNum(),
			        "".equals(pojo.getMerchNo()) ? null : pojo.getMerchNo(),
			        "".equals(pojo.getDebName()) ? null : pojo.getDebName(),
			        "".equals(pojo.getDebAccNo()) ? null : pojo.getDebAccNo(),
	        		"".equals(pojo.getDebBranchCode()) ? null : pojo.getDebBranchCode(),
			        "".equals(pojo.getCredName()) ? null : pojo.getCredName(),
			        "".equals(pojo.getCredAccNo()) ? null : pojo.getCredAccNo(),
			        "".equals(pojo.getCredBranchCode()) ? null : pojo.getCredBranchCode(),
	        		"".equals(pojo.getContractType()) ? null : pojo.getContractType(),
			        "".equals(pojo.getDebAmoLimit()) ? null : pojo.getDebAmoLimit(),
			        "".equals(pojo.getDebTranLimitType()) ? null : pojo.getDebTranLimitType(),
	        		"".equals(pojo.getDebAccyAmoLimit()) ? null : pojo.getDebAccyAmoLimit(),
			        "".equals(pojo.getDebTransLimitType()) ? null : pojo.getDebTransLimitType(),
			        "".equals(pojo.getDebTransLimit()) ? null : pojo.getDebTransLimit(),
			        "".equals(pojo.getCredAmoLimit()) ? null : pojo.getCredAmoLimit(),
	        		"".equals(pojo.getCredTranLimitType()) ? null : pojo.getCredTranLimitType(),
 			        "".equals(pojo.getCredAccuAmoLimit()) ? null : pojo.getCredAccuAmoLimit(),
 			        "".equals(pojo.getCredTransLimitType()) ? null : pojo.getCredTransLimitType(),
 	        		"".equals(pojo.getCredTransLimit()) ? null : pojo.getCredTransLimit(),
 			        "".equals(pojo.getSignDate()) ? null : pojo.getSignDate(),
 			        "".equals(pojo.getExpiryDate()) ? null : pojo.getExpiryDate(),
 			        "".equals(pojo.getInUser()) ? null : pojo.getInUser(),
 			        "".equals(pojo.getFileAddress()) ? null : pojo.getFileAddress(),
 	        		"".equals(pojo.getNotes()) ? null : pojo.getNotes(),
    				"".equals(pojo.getRemarks()) ? null : pojo.getRemarks(),
					"".equals(pojo.getFileName()) ? null : pojo.getFileName(),
					"".equals(pojo.getProprieTary()) ? null : pojo.getProprieTary(),
					"".equals(pojo.getCategoryPurpose()) ? null : pojo.getCategoryPurpose()};
		return executeOracleProcedure("{CALL PCK_T_CONTRACT.ins_t_contract(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
				paramaters, "cursor0").get(0);
	}

	@Override
	public List<?> findById(String tId) {
		String sql = "select po from PojoContract po where po.tId=?";
		return queryByHQL(sql, new Object[]{Long.parseLong(tId)});
	}
	
	@Override
	public List<?> findByCode(String contractNum) {
		String sql = "select po from PojoContract po where po.contractNum=?";
		return queryByHQL(sql, new Object[]{contractNum});
	}

	/**
	 * 注销
	 */
	@Override
	public Map<String, Object> eidtContract(ContractBean bean) {
		
		String[] columns = new String[]{"v_tid","v_withdrawuser", "v_withdrawopt","v_revocationdate"};
		Object[] paramaters = new Object[] {
				"".equals(bean.gettId()) ? null : bean.gettId(),
				"".equals(bean.getWithdrawUser()) ? null : bean.getWithdrawUser(),
				"".equals(bean.getWithdrawOpt()) ? null : bean.getWithdrawOpt(),
				"".equals(bean.getRevocationDate()) ? null : bean.getRevocationDate()};
        return executeOracleProcedure("{CALL  PCK_T_CONTRACT.del_t_contract(?,?,?,?,?)}", columns,
                paramaters, "cursor0").get(0);
	}
	/**
	 * 查询记录数
	 */
	@Override
	public List<?> findAllCont(ContractBean contract) {
		String sql = "select  t.*, rownum RN from T_CONTRACT t where MERCHNO like ? and CONTRACTNUM like ?"
				+ " and DEBTORNAME like ? and DEBTORACCOUNTNO like ? and CREDITORNAME like ? and CREDITORACCOUNTNO like ?"
				+ " and  STATUS in (20,10)";
		Object[] paramaters = new Object[] {
				contract.getMerchNo() == null ? "%%" : "%"+contract.getMerchNo()+"%",
				contract.getContractNum() == null ? "%%" : "%"+contract.getContractNum()+"%",
				contract.getDebName() == null ? "%%" : "%"+contract.getDebName()+"%",
				contract.getDebAccNo() == null ? "%%" : "%"+contract.getDebAccNo()+"%",
				contract.getCredName() == null ? "%%" : "%"+contract.getCredName()+"%",
				contract.getCredAccNo() == null ? "%%" : "%"+contract.getCredAccNo()+"%"};
		return queryBySQL(sql, paramaters);
	}

	/**
	 * 查询
	 */
	@Override
	public List<?> findAllAccout(ContractBean contract, Integer page, Integer rows) {
		int count = page * rows;
		int num = page - 1;
		int num2 = num * rows;
		String sql = "select * from ( select  t.*, rownum RN from T_CONTRACT t where MERCHNO like ? and CONTRACTNUM like ?"
				+ " and DEBTORNAME like ? and DEBTORACCOUNTNO like ? and CREDITORNAME like ? and CREDITORACCOUNTNO like ?"
				+ " and  STATUS in (20,10) ) where RN between ? and ?";
		Object[] paramaters = new Object[] {
				contract.getMerchNo() == null ? "%%" : "%"+contract.getMerchNo()+"%",
				contract.getContractNum() == null ? "%%" : "%"+contract.getContractNum()+"%",
				contract.getDebName() == null ? "%%" : "%"+contract.getDebName()+"%",
				contract.getDebAccNo() == null ? "%%" : "%"+contract.getDebAccNo()+"%",
				contract.getCredName() == null ? "%%" : "%"+contract.getCredName()+"%",
				contract.getCredAccNo() == null ? "%%" : "%"+contract.getCredAccNo()+"%",
				num2,count	};
		return queryBySQL(sql, paramaters);
	}

	@Override
	public List<Map<String, Object>> merchAudit(ContractBean contract, String isAgree) {
		String[] columns = new String[]{"v_user", "v_tid","v_opinion", "v_isagree"};
        Object[] paramaters = new Object[4];
        
        paramaters[0] = contract.getCvlexaUser();
        paramaters[1] = contract.gettId();
        paramaters[2] = contract.getCvlexaOpt();
        paramaters[3] = isAgree;
        
        List<Map<String, Object>> resultlist = executeOracleProcedure(
                "{CALL  PCK_T_CONTRACT.exam_t_contract(?,?,?,?,?)}", columns,
                paramaters, "cursor0");
        
        return resultlist;
	}

	@Override
	public List<StringBuffer> saveContractList(List<ContractBean> list) {
		String[] columns = new String[]{"v_CONTRACTNUM", "v_MERCHNO",
                "v_DEBTORNAME", "v_DEBTORACCOUNTNO", "v_DEBTORBRANCHCODE",
                "v_CREDITORNAME", "v_CREDITORACCOUNTNO", "v_CREDITORBRANCHCODE", 
                "v_CONTRACTTYPE","v_DEBTORAMOUNTLIMIT", "v_DEBTORTRANSAMTLIMITTYPE",
                "v_DEBTORACCUAMOUNTLIMIT", "v_DEBTORTRANSNUMLIMITTYPE","v_DEBTORTRANSLIMIT",
                "v_CREDITORAMOUNTLIMIT", "v_CREDITORTRANSAMTLIMITTYPE", "v_CREDITORACCUAMOUNTLIMIT",
                "v_CREDITORTRANSNUMLIMITTYPE", "v_CREDITORTRANSLIMIT", "v_SIGNDATE", "v_EXPIRYDATE",
                "v_INUSER", "v_FILEADDRESS", "v_NOTES", "v_REMARKS",
                "v_filename", "v_PROPRIETARY","v_CATEGORYPURPOSE"};
		List<StringBuffer> result = new ArrayList<StringBuffer>();
		for (ContractBean pojo : list) {
			
			 Object[] paramaters = new Object[]{
				        "".equals(pojo.getContractNum()) ? null : pojo.getContractNum(),
				        "".equals(pojo.getMerchNo()) ? null : pojo.getMerchNo(),
				        "".equals(pojo.getDebName()) ? null : pojo.getDebName(),
				        "".equals(pojo.getDebAccNo()) ? null : pojo.getDebAccNo(),
		        		"".equals(pojo.getDebBranchCode()) ? null : pojo.getDebBranchCode(),
				        "".equals(pojo.getCredName()) ? null : pojo.getCredName(),
				        "".equals(pojo.getCredAccNo()) ? null : pojo.getCredAccNo(),
				        "".equals(pojo.getCredBranchCode()) ? null : pojo.getCredBranchCode(),
		        		"".equals(pojo.getContractType()) ? null : pojo.getContractType(),
				        "".equals(pojo.getDebAmoLimit()) ? null : pojo.getDebAmoLimit(),
				        "".equals(pojo.getDebTranLimitType()) ? null : pojo.getDebTranLimitType(),
		        		"".equals(pojo.getDebAccyAmoLimit()) ? null : pojo.getDebAccyAmoLimit(),
				        "".equals(pojo.getDebTransLimitType()) ? null : pojo.getDebTransLimitType(),
				        "".equals(pojo.getDebTransLimit()) ? null : pojo.getDebTransLimit(),
				        "".equals(pojo.getCredAmoLimit()) ? null : pojo.getCredAmoLimit(),
		        		"".equals(pojo.getCredTranLimitType()) ? null : pojo.getCredTranLimitType(),
	 			        "".equals(pojo.getCredAccuAmoLimit()) ? null : pojo.getCredAccuAmoLimit(),
	 			        "".equals(pojo.getCredTransLimitType()) ? null : pojo.getCredTransLimitType(),
	 	        		"".equals(pojo.getCredTransLimit()) ? null : pojo.getCredTransLimit(),
	 			        "".equals(pojo.getSignDate()) ? null : pojo.getSignDate(),
	 			        "".equals(pojo.getExpiryDate()) ? null : pojo.getExpiryDate(),
	 			        "".equals(pojo.getInUser()) ? null : pojo.getInUser(),
	 			        "".equals(pojo.getFileAddress()) ? null : pojo.getFileAddress(),
	 	        		"".equals(pojo.getNotes()) ? null : pojo.getNotes(),
	 			        "".equals(pojo.getRemarks()) ? null : pojo.getRemarks(),
						"".equals(pojo.getFileName()) ? null : pojo.getFileName(),
						"".equals(pojo.getProprieTary()) ? null : pojo.getProprieTary(),
						"".equals(pojo.getCategoryPurpose()) ? null : pojo.getCategoryPurpose()};
			Object total = executeOracleProcedure("{CALL PCK_T_CONTRACT.ins_t_contract(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
					paramaters, "cursor0").get(0).get("INFO");
			if (!total.equals("添加成功!")) {
				StringBuffer msg = new StringBuffer();
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append(total.toString()).append(" ];");
				result.add(msg);
			}
		}
			return result;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public List<StringBuffer> importBatch_2(List<ContractBean> list) {
		List<StringBuffer> result = new ArrayList<StringBuffer>();
		StringBuffer msg = new StringBuffer();
		for (ContractBean pojo : list) {
			
			if(pojo.getContractNum() == null || pojo.getContractNum().equals("")){
				msg.append("合同编号:").append("合同号不能为空!");
				result.add(msg);
				return result;
			}
			if(pojo.getMerchNo() == null || pojo.getMerchNo().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("委托机构代码不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getInUser() == null || pojo.getInUser().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("操作员代码不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getContractType() == null || pojo.getContractType().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("合同类型不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getCredAccNo() == null || pojo.getCredAccNo().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("付款人账号不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getDebAccNo() == null || pojo.getDebAccNo().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("收款人账号不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getCredName() == null || pojo.getCredName().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("付款人名称不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getDebName() == null || pojo.getDebName().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("收款人名称不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getDebBranchCode() == null || pojo.getDebBranchCode().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("付款行行号不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getCredBranchCode() == null || pojo.getCredBranchCode().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("收款行行号不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getContractType() == null || pojo.getContractType().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("合同类型不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getDebAmoLimit() == null || pojo.getDebAmoLimit().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("付款单笔金额上限不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getDebTranLimitType() == null || pojo.getDebTranLimitType().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("付款累计金额限制类型不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getDebAccyAmoLimit() == null || pojo.getDebAccyAmoLimit().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("付款累计金额上限不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getDebTransLimitType() == null || pojo.getDebTransLimitType().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("付款次数限制类型不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getDebTransLimit() == null || pojo.getDebTransLimit().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("付款次数不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getCredAmoLimit() == null || pojo.getCredAmoLimit().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("收款单笔金额上限不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getCredTranLimitType() == null || pojo.getCredTranLimitType().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("收款累计金额限制类型不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getCredAccuAmoLimit() == null || pojo.getCredAccuAmoLimit().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("收款累计金额上限不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getCredTransLimitType() == null || pojo.getCredTransLimitType().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("收款次数限制类型不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getCredTransLimit() == null || pojo.getCredTransLimit().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("收款次数不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getSignDate() == null || pojo.getSignDate().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("合同开始日期不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getExpiryDate() == null || pojo.getExpiryDate().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("合同截止日期不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getFileAddress() == null || pojo.getFileAddress().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("合同附件保存地址名不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getFileName() == null || pojo.getFileName().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("批量导入文件名不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getProprieTary() == null || pojo.getProprieTary().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("业务种类代码不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getCategoryPurpose() == null || pojo.getCategoryPurpose().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("业务种类代码不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			if(pojo.getBatchNo() == null || pojo.getBatchNo().equals("")){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("批次号不能为空!").append(" ];");
				result.add(msg);
				return result;
			}
			
			PojoContract contractBean = (PojoContract) findByCode(pojo.getContractNum()).get(0);
			if(contractBean != null){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("该合同已存在或尚未被注销!").append(" ];");
				result.add(msg);
				return result;
			}
			
			PojoMerchDetaApply merch = (PojoMerchDetaApply) queryConType(pojo.getMerchNo()).get(0);
			if(merch == null){
				msg.append("合同编号:").append(pojo.getContractNum());
				msg.append(" : [ ").append("该委托机构不存在或已被注销!").append(" ];");
				result.add(msg);
				return result;
			}
			PojoContract bean = new PojoContract();
			BeanUtils.copyProperties(pojo, bean);
			Date curDate = new Date(System.currentTimeMillis());
			bean.setInTime(curDate);
			saveEntity(bean);
		}
		return result;
	}

	@Override
	public List<?> queryConType(String merchNo){
		String sql = "select po from PojoMerchDetaApply po where po.memberId=? and po.memberType=03";
		return queryByHQL(sql, new Object[]{merchNo});
	}

}
