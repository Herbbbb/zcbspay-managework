package com.zcbspay.platform.manager.utils;

import javax.servlet.http.HttpServletRequest;

import com.zcbspay.platform.manager.constants.Constants;
import com.zcbspay.platform.manager.system.bean.UserBean;

public class UserHelper {

	public static UserBean getCurrentUser(HttpServletRequest request) {
		return (UserBean) request.getSession().getAttribute(Constants.LoginCanstant.LOGIN_USER);
	}
}
