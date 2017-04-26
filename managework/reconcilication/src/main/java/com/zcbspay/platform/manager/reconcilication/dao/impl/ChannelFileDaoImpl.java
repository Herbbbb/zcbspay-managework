package com.zcbspay.platform.manager.reconcilication.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.reconcilication.bean.ChannelFileBean;
import com.zcbspay.platform.manager.reconcilication.dao.ChannelFileDao;

@Repository
public class ChannelFileDaoImpl extends HibernateBaseDAOImpl<ChannelFileBean> implements ChannelFileDao {

	@Override
	public List<?> getAllStatusChannel() {
		String queryString = "select * from T_CHANNEL_FILE c where  c.status=00";
        List<?> list = queryBySQL(queryString, null);
        return list;
	}
}
