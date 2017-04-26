package com.zcbspay.platform.manager.reconcilication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.reconcilication.dao.ChannelFileDao;
import com.zcbspay.platform.manager.reconcilication.service.ChannelFileService;
@Service("channelFileService")
public class ChannelFileServiceImpl implements ChannelFileService{

	@Autowired
	private ChannelFileDao channelFileDao;
	
	@Override
	public List<?> getAllStatusChannel() {
		return channelFileDao.getAllStatusChannel();
	}
	
}
