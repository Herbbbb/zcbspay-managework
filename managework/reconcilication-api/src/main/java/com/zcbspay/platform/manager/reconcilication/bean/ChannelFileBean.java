package com.zcbspay.platform.manager.reconcilication.bean;

/**
 * t_channel_file entity. @author MyEclipse Persistence Tools
 */
public class ChannelFileBean implements java.io.Serializable {

    // Fields

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String id;
    //渠道标识
    private String chnlId;
    //渠道代码
    private String chnlCode;
    //渠道名称
    private String chnlName;
    //文件名
    private String fileName;
    //渠道状态 00父渠道 01子渠道
    private String status;
    //类的路径
    private String classPath;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getChnlId() {
        return chnlId;
    }

    public void setChnlId(String chnlId) {
        this.chnlId = chnlId;
    }
    public String getChnlCode() {
        return chnlCode;
    }
    public void setChnlCode(String chnlCode) {
        this.chnlCode = chnlCode;
    }
    public String getChnlName() {
        return chnlName;
    }
    public void setChnlName(String chnlName) {
        this.chnlName = chnlName;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getClassPath() {
        return classPath;
    }
    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }
    
    
    
}