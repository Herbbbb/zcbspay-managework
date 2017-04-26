package com.zcbspay.platform.manager.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.system.bean.ParaDicBean;
import com.zcbspay.platform.manager.system.dao.ParaDicDAO;
import com.zcbspay.platform.manager.system.pojo.PojoParaDic;

@Repository
public class ParaDicDAOImpl extends HibernateBaseDAOImpl<PojoParaDic> implements ParaDicDAO{
	public List<?> getAllParaListByParaType(String paraType, String status) {
        String queryString = "";
        String[] paramaters = null;
        if (status == null || status.equals("")) {
            queryString = "select * from t_para_dic t where t.para_type=?";
            paramaters = new String[]{paraType};
        } else {
            queryString = "select * from t_para_dic t where t.para_type=? and t.status=?";
            paramaters = new String[]{paraType, status};
        }
        return queryBySQL(queryString, paramaters);

    }
    // 新增一条参数信息
    public String AddOneParaDic(ParaDicBean paradic) {
        Object[] paramaters = new Object[]{paradic.getParaCode(),
                paradic.getParentId(), paradic.getParaName(),
                paradic.getHasSub(), paradic.getStatus(), paradic.getRemarks()};
        String[] columns = new String[]{"v_para_code", "v_parent_id",
                "v_para_name", "v_has_sub", "v_status", "v_remarks"};
        return (String) executeOracleProcedure("{CALL MODI_T_PARA_DIC.ins_t_para_dic(?,?,?,?,?,?,?)}",
                columns, paramaters, "cursor0").get(0).get("INFO");

    }
    // 分页查询参数
    public List<?> queryParaDicList(String parentid,String paraname,String status,int page,int rows) {
        Object[] paramaters = new Object[]{parentid, paraname, "1", page, rows};
        String[] columns = new String[]{"v_parent_id", "v_para_name","v_status", "i_no", "i_perno"};
        return executeOracleProcedure("{CALL MODI_T_PARA_DIC.sel_t_para_dic(?,?,?,?,?,?)}", columns,
                paramaters, "cursor0");
    }
    // 分页查询参数信息总条数
    public Long queryParaDicCount(String parentid,String paraname,String status) {
    	
        Object[] paramaters = new Object[]{parentid, paraname, "1"};
        String[] columns = new String[]{"v_parent_id", "v_para_name","v_status"};
        Object total = executeOracleProcedure("{CALL MODI_T_PARA_DIC.sel_t_para_dic_num(?,?,?,?)}",
                        columns, paramaters, "cursor0").get(0).get("TOTAL");
        return Long.valueOf(total.toString());
    }
    // 修改参数信息
    public String updatePara(ParaDicBean paradic) {
        Object[] paramaters = new Object[]{paradic.getTid(),
                paradic.getParaCode(), paradic.getParentId(),
                paradic.getParaName(), paradic.getHasSub(), "1",
                paradic.getRemarks()};
        String[] columns = new String[]{"v_tid", "v_para_code", "v_parent_id",
                "v_para_name", "v_has_sub", "v_status", "v_remarks"};
        return (String) executeOracleProcedure("{CALL MODI_T_PARA_DIC.upt_t_para_dic(?,?,?,?,?,?,?,?)}",
                columns, paramaters, "cursor0").get(0).get("INFO");

    }
}
