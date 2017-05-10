package com.zcbspay.platform.manager.merchant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.merchant.bean.ContractBean;
import com.zcbspay.platform.manager.merchant.dao.ContractBarchDao;
import com.zcbspay.platform.manager.merchant.dao.ContractDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoContract;
import com.zcbspay.platform.manager.merchant.pojo.PojoContractBatch;
import com.zcbspay.platform.manager.merchant.service.ContractService;

@Service("contractService")
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractDao contractDao;
	@Autowired
	private ContractBarchDao contractBarchDao;

	@Override
	public Map<String, Object> findAll(Map<String, Object> variables, int page, int rows) {
		return contractDao.findAll(variables,page,rows);
	}

	@Override
	public Map<String, Object> addContract(ContractBean contract) {
		PojoContract pojo = new PojoContract();
		BeanUtils.copyProperties(contract, pojo );
		return contractDao.addContract(pojo);
	}

	@Override
	public ContractBean findById(String tId) {
		PojoContract pojo = (PojoContract) contractDao.findById(tId).get(0);
		ContractBean bean = new ContractBean();
		BeanUtils.copyProperties(pojo, bean );
		return bean;
	}
	@Override
	public ContractBean findByCode(String contractNum) {
		PojoContract pojo = (PojoContract) contractDao.findByCode(contractNum).get(0);
		ContractBean bean = new ContractBean();
		BeanUtils.copyProperties(pojo, bean );
		return bean;
	}

	@Override
	public Map<String, Object> eidtContract(ContractBean bean) { 
		return contractDao.eidtContract(bean);
	}

	@Override
	public Integer findAllCont(ContractBean contract) {
		return contractDao.findAllCont(contract).size();
	}

	@Override
	public List<?> findAllAccout(ContractBean contract, Integer page, Integer rows) {
		return contractDao.findAllAccout(contract,page,rows);
	}

	@Override
	public List<Map<String, Object>> merchAudit(ContractBean contract, String isAgree) {
		return contractDao.merchAudit(contract,isAgree);
	}

	@Override
	public Map<String, Object> importBatch(List<ContractBean> list,String batchNo,String merchNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		
    	boolean resultSucc= contractBarchDao.queryContractBatch(batchNo,merchNo);
    	PojoContractBatch batch = new PojoContractBatch();
    	Long total = (long) list.size();
    	batch.setTotalCount(total);
    	batch.setBatchNo(batchNo);
    	batch.setMerchNo(merchNo);
    	
    	if (resultSucc) {
			map.put("RET", "error");
			map.put("INFO", "该批次号已存在或尚未被注销!");
			return map;
		}
    	
    	map = contractDao.importBatch_2(list,batchNo);
		 
        if (map.get("RET").equals("succ")) {
        	boolean isSucc = contractBarchDao.saveBatch(batch);
        	if (!isSucc) {
        		map.put("RET", "error");
    			map.put("INFO", "该批次号添加失败！");
    			return map;
			}else{
				map.put("RET", "succ");
    			map.put("INFO", "添加成功");
    			return map;
			}
		}
		return map;
	}
	@Override
	public List<StringBuffer> saveContractList(List<ContractBean> list) {
		return contractDao.saveContractList(list);
	}
}
