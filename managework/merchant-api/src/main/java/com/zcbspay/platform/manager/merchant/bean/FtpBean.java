package com.zcbspay.platform.manager.merchant.bean;

import java.io.Serializable;

public class FtpBean implements Serializable {

	private static final long serialVersionUID = 2548400611101785781L;
	/** 标识 **/
	private Long tId;
	/** 服务名称 **/
	private String serverName;
	/** IP地址 **/
	private String ip;
	/** 端口号 **/
	private String port;
	/** 用户名 **/
	private String users;
	/** 密码 **/
	private String pwd;
	/** 本地编码 **/
	private String localCharset;
	/** 输出编码 **/
	private String remoteCharset;
	/** 备注 **/
	private String remarks;
	/** 备注 **/
	private String notes;
	/** 模块 **/
	private String module;
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getLocalCharset() {
		return localCharset;
	}
	public void setLocalCharset(String localCharset) {
		this.localCharset = localCharset;
	}
	public String getRemoteCharset() {
		return remoteCharset;
	}
	public void setRemoteCharset(String remoteCharset) {
		this.remoteCharset = remoteCharset;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	
	
}
