package com.zcbspay.platform.manager.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.system.bean.UserBean;
import com.zcbspay.platform.manager.system.dao.FunctionDAO;
import com.zcbspay.platform.manager.system.pojo.PojoFunction;

@Repository
public class FunctionDAOImpl extends HibernateBaseDAOImpl<PojoFunction> implements FunctionDAO{
	
	@Transactional(readOnly=true)
	public List<?> findAllFuntion(UserBean loginuser){
		String queryString = "from PojoFunction fun where fun.status=00 order by fun.functOrder asc";
		return queryByHQL(queryString,null);
	}
	public List<?> findFunction(){
		String queryString = "select funct_id, funct_name, funct_order, parent_id, url,icon,leafnode from t_function fun where fun.status=00 order by fun.parent_id, fun.funct_order, fun.funct_id";
		return queryBySQL(queryString, null);
	}
	
	@Transactional(readOnly=true)
	public List<?> existUserAndRoleFunct(Long userId,Long fid){
		StringBuffer queryString = new StringBuffer("select ");
		queryString.append("t.user_id,trf.funct_id rolefunct,tuf.funct_id userfunct ");
		queryString.append("from ");
		queryString.append("t_user t ");
		queryString.append("left join t_role_funct trf on t.role_id = trf.role_id ");
		queryString.append("left join t_user_funct tuf on t.user_id = tuf.user_id ");
		queryString.append("where ");
		queryString.append("t.user_id=? and (trf.funct_id=? or tuf.funct_id=?) ");
		Object[] paramaters = new Object[]{userId,fid,fid};
		return queryBySQL(queryString.toString(), paramaters);
	}
	
	
	public List<?> findLoginFuntion(UserBean loginuser) {
		
		String[] columns = new String[] { "v_user"};
		Object[] paramaters = new Object[] { "".equals(loginuser.getUserId()) ? null : loginuser.getUserId()};
		return executeOracleProcedure("{CALL pro_funct_by_user(?,?)}", columns,
				paramaters, "cursor0");
	}
}
