package com.zcbspay.platform.manager.business.bean;

import java.util.Date;

public class RouteBean implements java.io.Serializable{

    /**标识**/
    private String routid;
    /**路由号**/
    private String routver;
    /**路由名称**/
    private String routname;
    /**状态**/
    private String status;
    /**写入时间**/
    private Date intime;
    /**写入人**/
    private Long inuser;
    /**更新时间**/
    private Date uptime;
    /**更新人**/
    private Long upuser;
    /**备注**/
    private String note;
    /**操作**/
    private String remarks;
    
    public RouteBean() {
        super();
    }

    public RouteBean(String routid, String routver, String routname,
            String status, Date intime, Long inuser, Date uptime,
            Long upuser, String note, String remarks) {
        super();
        this.routid = routid;
        this.routver = routver;
        this.routname = routname;
        this.status = status;
        this.intime = intime;
        this.inuser = inuser;
        this.uptime = uptime;
        this.upuser = upuser;
        this.note = note;
        this.remarks = remarks;
    }

    public String getRoutid() {
        return routid;
    }

    public void setRoutid(String routid) {
        this.routid = routid;
    }

    public String getRoutver() {
        return routver;
    }

    public void setRoutver(String routver) {
        this.routver = routver;
    }

    public String getRoutname() {
        return routname;
    }

    public void setRoutname(String routname) {
        this.routname = routname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getIntime() {
        return intime;
    }
    
    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Long getInuser() {
        return inuser;
    }

    public void setInuser(Long inuser) {
        this.inuser = inuser;
    }

    public Date getUptime() {
        return uptime;
    }
    
    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Long getUpuser() {
        return upuser;
    }

    public void setUpuser(Long upuser) {
        this.upuser = upuser;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



    
    
    
    
}
