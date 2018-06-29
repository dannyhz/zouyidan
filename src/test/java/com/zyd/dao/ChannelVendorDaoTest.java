package com.zyd.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyd.model.ChannelVendorDO;;

public class ChannelVendorDaoTest {
	ApplicationContext act = null;
	
	@Before
	public void init(){
		act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });	
	}
	
	@Test
	public void suppose_query_channel_vendor_success(){
		IChannelVendorDao cvDao = act.getBean(IChannelVendorDao.class);
		ChannelVendorDO cv = new ChannelVendorDO();
		cv.setChannelCode("mpxx");
		
		ChannelVendorDO channelVendor = cvDao.queryChannelVendor(cv);
		System.out.println(channelVendor.getChannelName());
		
	}
}
