package com.zcbspay.platform.manager.constants;

public class Constants {

    private Constants() {
    }


    public static class LoginCanstant {
        public static final String LOGIN_USER = "LOGIN_USER";

        private LoginCanstant() {
        }
    }
    
    
    
    /**
     * 时间相关常量
     */
    public static class DateCanstant {
        public static final String EXCEL_DATE = "yyyyMMdd";
        public static final String EXCEL_MONTH = "yyyyMM";
        public static final String DATE_MONTH="yyyy-MM";
        public static final String MMDD = "MM-dd";
        public static final String DATE = "yyyy-MM-dd";
        public static final String CHINESE_DATE = "yyyy年MM月dd日";
        public static final String CHINESE_MMDD = "MM月dd日";
        public static final String DATE_TIME12 = "yyyy-MM-dd hh:mm:ss";
        public static final String DATE_TIME24 = "yyyy-MM-dd HH:mm:ss";

        private DateCanstant() {
        }
    }
    
    public static class BusinessType{
    	public static final String SINGLE_COLLECT="11000001";
    	public static final String SINGLE_PAY="11000002";
    	
    	public static final String BATCH_COLLECT="11000001";
    	public static final String BATCH_PAY="11000002";
    	
    	private BusinessType(){}
    }
    
    public static class CurrencyType{
    	public static final String RMB="156";
    	
    	private CurrencyType(){}
    }
    
    
    
    /**
	 * 发送、接收标志
		SR00：发送sendReceiveType;
		SR01：接收
	 */
    public static class SendReceiveType{
        public static final String SEND = "SR00";
        public static final String RECEIVE = "SR01";
        private SendReceiveType() {
        }
    }
	
    /**
     * web相关常量
     */
    public static class Web {

        public static final String COOKIE_ROOT_PATH = "/";
        /**
         * 路径分隔符
         */
        public static final String SPT = "/";
        /**
         * 索引页
         */
        public static final String INDEX = "index";
        /**
         * UTF-8编码
         */
        public static final String UTF8 = "UTF-8";
        /**
         * 提示信息
         */
        public static final String MESSAGE = "message";
        /**
         * cookie中的JSESSIONID名称
         */
        public static final String JSESSION_COOKIE = "JSESSIONID";
        /**
         * url中的jsessionid名称
         */
        public static final String JSESSION_URL = "jsessionid";
        /**
         * HTTP POST请求
         */
        public static final String POST = "POST";
        /**
         * HTTP GET请求
         */
        public static final String GET = "GET";
    }

    
    
    
}
