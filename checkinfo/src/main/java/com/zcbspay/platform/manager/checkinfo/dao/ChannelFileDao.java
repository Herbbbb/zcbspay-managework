package com.zcbspay.platform.manager.checkinfo.dao;

import java.util.List;

import com.zcbspay.platform.manager.checkinfo.bean.ChannelFileBean;
import com.zcbspay.platform.manager.dao.BaseDAO;

public interface ChannelFileDao extends BaseDAO<ChannelFileBean>{

	/**
	 * 获取全部的组织结构
	 * @author: zhangshd
	 * @return List<ChannelFileBean>
	 * @date: 2017年3月1日 下午3:51:09 
	 * @version v1.0
	 */
	public List<?> getAllStatusChannel();

}
