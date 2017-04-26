package com.zcbspay.platform.manager.system.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.system.bean.DeptBean;
import com.zcbspay.platform.manager.system.dao.DeptDAO;
import com.zcbspay.platform.manager.system.pojo.PojoDept;
import com.zcbspay.platform.manager.utils.BeanCopyUtil;
@Repository
@SuppressWarnings("all")
public class DeptDAOImpl extends HibernateBaseDAOImpl<PojoDept> implements DeptDAO{

	private static final Logger log = LoggerFactory.getLogger(DeptDAOImpl.class);
    @Override
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
    public List<?> updateDeptNotes(String deptCode, String notes) {
      String sql="update T_DEPT t set  t.NOTES =?  where t.DEPT_CODE=?";
      updateBySQL(sql, new Object[]{notes,deptCode});
      return null;  
    }

    public Map<String, Object> findDeptByPage(Map<String, Object> variables, int page,
			int rows) {
		String[] columns = new String[] { "v_dept_code", "v_dept_name", "i_no",
				"i_perno" };
		Object[] paramaters = new Object[4];
		paramaters[0] = variables.containsKey("deptCode") ? variables
				.get("deptCode") : null;
		paramaters[1] = variables.containsKey("deptName") ? variables
				.get("deptName") : null;
		paramaters[2] = page;
		paramaters[3] = rows;
		return executePageOracleProcedure("{CALL PCK_T_DEPT.sel_t_dept(?,?,?,?,?,?)}",columns,
				paramaters, "cursor0","v_total");
	}

	public long findDeptByPageCount(Map<String, Object> variables) {
		String[] columns = new String[] { "v_dept_code", "v_dept_name" };
		Object[] paramaters = new Object[2];
		paramaters[0] = variables.containsKey("deptCode") ? variables
				.get("deptCode") : null;
		paramaters[1] = variables.containsKey("deptName") ? variables
				.get("deptName") : null;
		Object total = executeOracleProcedure(
				"{CALL PCK_T_DEPT.sel_t_dept_num(?,?,?)}", columns,
				paramaters, "cursor0").get(0).get("TOTAL");
		return Long.valueOf(total.toString());
	}

	public List<?> saveDept(DeptBean dept) {

		String[] columns = new String[] { "v_dept_code", "v_dept_name",
				"v_organ_id", "v_creator", "v_notes ", "v_remarks"

		};
		Object[] paramaters = new Object[] {
				"".equals(dept.getDeptCode()) ? null : dept.getDeptCode(),
				"".equals(dept.getDeptName()) ? null : dept.getDeptName(),
				"".equals(dept.getOrganId()) ? null : dept.getOrganId(),
				"".equals(dept.getCreator()) ? null : dept.getCreator(),
				"".equals(dept.getNotes()) ? null : dept.getNotes(),
				"".equals(dept.getRemarks()) ? null : dept.getRemarks() };
		return executeOracleProcedure(
				"{CALL PCK_T_DEPT.ins_t_dept(?,?,?,?,?,?,?)}", columns,
				paramaters, "cursor0");
	}

	public List<?> updateDept(DeptBean dept) {
		String[] columns = new String[] { "v_dept_id", "v_dept_code",
				"v_dept_name", "v_organ_id", "v_creator", "v_status",
				"v_notes", "v_remarks" };
		Object[] paramaters = new Object[] {
				dept.getDeptId(),
				"".equals(dept.getDeptCode()) ? null : dept.getDeptCode(),
				"".equals(dept.getDeptName()) ? null : dept.getDeptName(),
				"".equals(dept.getOrganId()) ? null : dept.getOrganId(),
				"".equals(dept.getCreator()) ? null : dept.getCreator(),
				"".equals(dept.getStatus()) ? null : dept.getStatus(),
				"".equals(dept.getNotes()) ? null : dept.getNotes(),
				"".equals(dept.getRemarks()) ? null : dept.getRemarks() };
		
		return executeOracleProcedure(
				"{CALL PCK_T_DEPT.upt_t_dept(?,?,?,?,?,?,?,?,?)}",columns,
				paramaters, "cursor0");
	}

	public List<?> deleteDept(Long deptId) {
		String[] columns = new String[] { "v_dept_id"};
		Object[] paramaters = new Object[] {deptId};
		return executeOracleProcedure("{CALL PCK_T_DEPT.del_t_dept(?,?)}", columns,paramaters, "cursor0");
	}

	@Override
	public DeptBean get(Long deptId) {
		Criteria crite = this.getSession().createCriteria(PojoDept.class);
		crite.add(Restrictions.eq("deptId",deptId));
		Object uniqueResult = crite.uniqueResult();
		return BeanCopyUtil.copyBean(DeptBean.class, uniqueResult);
	}

	@Override
	public List<?> findByProperty(Long organId,String status){
		Object[] paramaters = null;
		 String sql ;
		if (organId != null) {
			 sql = "select rm from PojoDept rm where rm.status='00' and rm.organId=?";
			 paramaters = new Object[] {organId};
		}else{
			 sql = "select rm from PojoDept rm where rm.status='00'";
		}
		return queryByHQL(sql, paramaters);
	}
}
