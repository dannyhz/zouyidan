package com.zyd.dao;

import com.zyd.model.ChannelVendorDO;

public interface IChannelVendorDao {
	
	ChannelVendorDO queryChannelVendor(ChannelVendorDO channelVendorDO);
	void insertChannelVendor(ChannelVendorDO channelVendorDO);
}
