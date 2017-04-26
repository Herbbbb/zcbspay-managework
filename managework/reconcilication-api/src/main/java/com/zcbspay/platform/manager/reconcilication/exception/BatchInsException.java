/* 
 * TradeFeeException.java  
 * 
 * version TODO
 *
 * 2016年11月16日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zcbspay.platform.manager.reconcilication.exception;

/**
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2016年11月16日 上午9:18:12
 * @since 
 */
public class BatchInsException extends RuntimeException{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4634586182669271478L;
	/**
	 * 
	 */
	public BatchInsException(String message) {
		super(message);
	}
}
