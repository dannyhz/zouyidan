package com.zyd.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyd.cache.CacheManager;
import com.zyd.model.ChannelVendorDO;
import com.zyd.model.SalesmanDO;
import com.zyd.model.UserDO;
import com.zyd.service.ChannelService;
import com.zyd.service.SalesmanService;
import com.zyd.service.UserService;

import cn.evun.sweet.core.common.JsonResultDO;

@RestController
public class SalesmanController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private SalesmanService salesmanService;
	
	@Resource
	private ChannelService channelService;
	
	@Resource
	private CacheManager cacheManager;
	
	
	@RequestMapping("/salesman/reqMsgLoginVerifyCode")
	public JsonResultDO getMsgVerifyCode(SalesmanDO salesman, String verifyMsg, HttpServletRequest request) {
		 
		 JsonResultDO result = new JsonResultDO();
		 
		 String verifyCode = callShortMsgAPI();
		 
		 HttpSession session = request.getSession(true);
		 cacheManager.storeVerifyCode(session.getId(), verifyCode);
		 
		 result.addAttribute("verifyCode", verifyCode);  
		 result.setSuccess(true);
		 return result; 
	} 
	@ResponseBody
	@RequestMapping("/salesman/registerSalesman")
	 public JsonResultDO register(@RequestBody SalesmanDO salesman, HttpServletRequest request) {
		 
		 JsonResultDO result = new JsonResultDO();
		
		 UserDO userDO = new UserDO();
		 HttpSession session = request.getSession();
		 if(session == null){
			 result.setSuccess(false);
			 result.setMessage("用户会话缺失！");
			 return result;
		 }
		 System.out.println("session id = " + session.getId()); 
		 
		 String verifyCode = cacheManager.retrieveVerifyCode(session.getId());
		 
		 if(!verifyCode.equals(salesman.getLoginVerifyCode())){
			 result.setMessage("验证码不正确，请重新输入");  
			 result.setSuccess(false);
			 return result;
		 }
		 
		 ChannelVendorDO channelVendor = channelService.getChanelVendor(salesman.getChannelCode());
		 
		 if(channelVendor == null){
			 result.setMessage("渠道码不存在");  
			 result.setSuccess(false);
			 return result;
		 }
		 userDO.setPhone(salesman.getPhoneNo());
		 userDO.setPassword(salesman.getPassword());
		 UserDO retUser = userService.saveUser(userDO);
		 
		 salesman.setChannelId(channelVendor.getChannelId());
		 salesman.setUserId(retUser.getUserId());
		 salesman.setStatus("A");
		 salesmanService.addNewSalesman(salesman);
		 result.setMessage("add successful");
		 return result; 
	 }
	 
	private String callShortMsgAPI() {
		return "888888";
	}
}
