package com.zcbspay.platform.manager.merchant.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_FTP")
public class PojoFtp implements Serializable {

	private static final long serialVersionUID = -6459492413591243949L;
	
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
	
	@Id
	@Column(name = "TID")
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	@Column(name = "SERVERNAME")
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	@Column(name = "IP")
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Column(name = "PORT")
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	@Column(name = "USERS")
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	@Column(name = "PWD")
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Column(name = "LOCALCHARSET")
	public String getLocalCharset() {
		return localCharset;
	}
	public void setLocalCharset(String localCharset) {
		this.localCharset = localCharset;
	}
	@Column(name = "REMOTECHARSET")
	public String getRemoteCharset() {
		return remoteCharset;
	}
	public void setRemoteCharset(String remoteCharset) {
		this.remoteCharset = remoteCharset;
	}
	@Column(name = "REMARKS")
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Column(name = "NOTES")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Column(name = "MODULE")
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	
	
}
