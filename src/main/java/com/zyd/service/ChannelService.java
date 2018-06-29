package com.zyd.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zyd.dao.IChannelVendorDao;
import com.zyd.model.ChannelVendorDO;
@Component
public class ChannelService {
	
	@Resource
	private IChannelVendorDao channelDao;
	
	public ChannelVendorDO getChanelVendor(String channelVendorCode){
		ChannelVendorDO queryChannelVendor = new ChannelVendorDO();
		queryChannelVendor.setChannelCode(channelVendorCode);
		ChannelVendorDO channelVendor = channelDao.queryChannelVendor(queryChannelVendor);
		return channelVendor;
	}
	
	

}
