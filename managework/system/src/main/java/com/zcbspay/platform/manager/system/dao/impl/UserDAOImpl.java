package com.zcbspay.platform.manager.system.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.system.bean.UserBean;
import com.zcbspay.platform.manager.system.dao.UserDAO;
import com.zcbspay.platform.manager.system.pojo.PojoUser;
import com.zcbspay.platform.manager.utils.BeanCopyUtil;


@Repository
public class UserDAOImpl extends HibernateBaseDAOImpl<PojoUser> implements UserDAO{

	public Map<String, Object> findUserByPage(Map<String, Object> variables, int page,
			int rows) {
		String[] columns = new String[] { "v_user_code", "v_user_name",
				"v_role_id", "v_organ_id", "v_dept_id", "i_no", "i_perno" };
		Object[] paramaters = new Object[7];
		paramaters[0] = variables.containsKey("userCode") ? variables
				.get("userCode") : null;
		paramaters[1] = variables.containsKey("userName") ? variables
				.get("userName") : null;
		paramaters[2] = variables.containsKey("roleId") ? variables
				.get("roleId") : null;
		paramaters[3] = variables.containsKey("organId") ? variables
				.get("organId") : null;
		paramaters[4] = variables.containsKey("deptId") ? variables
				.get("deptId") : null;
		paramaters[5] = page;
		paramaters[6] = rows;
		return executePageOracleProcedure("{CALL PCK_T_USER.sel_t_user(?,?,?,?,?,?,?,?,?)}",columns,
				paramaters, "cursor0","v_total");
	}

	public long findUserByPageCount(Map<String, Object> variables) {
		String[] columns = new String[] { "v_user_code", "v_user_name",
				"v_role_id", "v_organ_id", "v_dept_id" };
		Object[] paramaters = new Object[5];
		paramaters[0] = variables.containsKey("userCode") ? variables
				.get("userCode") : null;
		paramaters[1] = variables.containsKey("userName") ? variables
				.get("userName") : null;
		paramaters[2] = variables.containsKey("roleId") ? variables
				.get("roleId") : null;
		paramaters[3] = variables.containsKey("organId") ? variables
				.get("organId") : null;
		paramaters[4] = variables.containsKey("deptId") ? variables
				.get("deptId") : null;
		Object total = executeOracleProcedure("{CALL PCK_T_USER.sel_t_user_num(?,?,?,?,?,?)}", columns,
				paramaters, "cursor0").get(0).get("TOTAL");
		return Long.valueOf(total.toString());
	}

	public List<?> saveUser(UserBean user) {
		String[] columns = new String[] { "v_user_code", "v_user_name",
				"v_login_name", "v_pwd", "v_pwd_valid", "v_creator",
				"v_organ_id", "v_dept_id", "v_isadmin", "v_notes",
				"v_remarks"};
		
		Object[] paramaters = new Object[] {
				"".equals(user.getUserCode()) ? null : user.getUserCode(),
				"".equals(user.getUserName()) ? null : user.getUserName(),
				"".equals(user.getLoginName()) ? null : user.getLoginName(),
				"".equals(user.getPwd()) ? null : user.getPwd(),
				"".equals(user.getPwdValid()) ? null : user.getPwdValid(),
				"".equals(user.getCreator()) ? null : user.getCreator(),
				"".equals(user.getOrganId()) ? null : user.getOrganId(),
				"".equals(user.getDeptId()) ? null : user.getDeptId(),
				"".equals(user.getIsadmin()) ? null : user.getIsadmin(),
				"".equals(user.getNotes()) ? null : user.getNotes(),
				"".equals(user.getRemarks()) ? null : user.getRemarks() };
		return executeOracleProcedure("{CALL PCK_T_USER.ins_t_user(?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
				paramaters, "cursor0");
		
	}

	public List<?> updateUser(UserBean user) {
		String[] columns = new String[] { "v_user_id","v_user_code", "v_user_name",
				"v_login_name", "v_pwd", "v_pwd_valid", "v_creator",
			    "v_organ_id", "v_dept_id", "v_isadmin","v_status", "v_notes",
				"v_remarks"};
		
			Object[] paramaters = new Object[] {
					"".equals(user.getUserId()) ? null : user.getUserId(),
					"".equals(user.getUserCode()) ? null : user.getUserCode(),
					"".equals(user.getUserName()) ? null : user.getUserName(),
					"".equals(user.getLoginName()) ? null : user.getLoginName(),
					"".equals(user.getPwd()) ? null : user.getPwd(),
					"".equals(user.getPwdValid()) ? null : user.getPwdValid(),
					"".equals(user.getCreator()) ? null : user.getCreator(),
					"".equals(user.getOrganId()) ? null : user.getOrganId(),
					"".equals(user.getDeptId()) ? null : user.getDeptId(),
					"".equals(user.getIsadmin()) ? null : user.getIsadmin(),
					"".equals(user.getStatus()) ? null : user.getStatus(),
					"".equals(user.getNotes()) ? null : user.getNotes(),
					"".equals(user.getRemarks()) ? null : user.getRemarks() };
			return executeOracleProcedure("{CALL PCK_T_USER.upt_t_user(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
					paramaters, "cursor0");
		
	}

	@Override
	@Transactional(readOnly=true)
	public UserBean getLoginUser(UserBean user) {
		Criteria crite = this.getSession().createCriteria(PojoUser.class);
		crite.add(Restrictions.eq("loginName", user.getLoginName()));
		crite.add(Restrictions.eq("status", user.getStatus()));
		crite.add(Restrictions.eq("pwd",user.getPwd()));
		
		Object uniqueResult = crite.uniqueResult();
		UserBean bean = new UserBean();
		if (uniqueResult != null) {
			bean = BeanCopyUtil.copyBean(UserBean.class, uniqueResult);
		}else{
			bean = null;
		}
		return bean;
	}

	@Override
	public UserBean getSingleById(Long userId) {
		Criteria crite = this.getSession().createCriteria(PojoUser.class);
		crite.add(Restrictions.eq("userId",userId));
		Object uniqueResult = crite.uniqueResult();
		return BeanCopyUtil.copyBean(UserBean.class, uniqueResult);
	}

	@Override
	public void resetPwd(UserBean user, String timestamp) {
		String pwd =user.getPwd();
		Long userId =user.getUserId();
		String sql = "update PojoUser p set p.pwd=?,p.pwdValid=to_date(?,'yyyy-MM-dd') where p.userId=?";
//		String sql = "update PojoUser p set p.pwd=?,p.pwdValid=? where p.userId=?";
		updateByHQL(sql, new Object[]{pwd,timestamp,userId});	
	}
}
