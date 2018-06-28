package com.zyd.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyd.cache.CacheManager;
import com.zyd.cache.UserOnlinePool;
import com.zyd.model.UserDO;
import com.zyd.service.UserService;

import cn.evun.sweet.auth.model.UserDo;
import cn.evun.sweet.core.common.JsonResultDO;

@RestController
public class PhoneLoginController {
	@Resource
	private UserService userService;
	
	@Resource
	private CacheManager cacheManager;
	
	  @ResponseBody
	  @RequestMapping(value = "/phone/checkPhoneNo" , method = RequestMethod.GET)
	  public JsonResultDO chekPhoneNo(UserDO user) {
		  
		  JsonResultDO result = new JsonResultDO();
		  
		  if(userService.getUserByPhone(user.getPhone()) == null){
			  result.addAttribute("isRegister", "false");  
		      result.setSuccess(false);
		      result.setStatusCode("100");
		      result.setMessage("此手机号码账户不存在");
		      return result;
		  }
		  
		  UserDO cachedUser = UserOnlinePool.currentUser.get();
		  if(cachedUser != null){
			  System.out.println("get the cached userDO ,  userId= " + cachedUser.getUserId());
		  }
		  result.addAttribute("isRegister", "true");  
		  result.setSuccess(true);
		  return result;
	  }	
	
	 @RequestMapping("/phone/login")
	 public JsonResultDO login(UserDO user, HttpServletRequest request) {
		 
		 JsonResultDO result = new JsonResultDO();
		 UserDO userDo = userService.getUser(user);
		 if(userDo == null){
			 result.setSuccess(false);
		     result.setStatusCode("200");
		     result.setMessage("密码有误");
		     return result;
		 }
		 HttpSession currentSession = request.getSession(true);
		 if(currentSession != null){
			 cacheManager.storeOnlineUser(currentSession.getId(), userDo);
		 }
		 
		 return result; 
	 }
	 
	 
	 @ResponseBody
	  @RequestMapping(value = "/phone/getCachedUser" , method = RequestMethod.GET)
	  public JsonResultDO getCachedUser(UserDO user) {
		  
		  JsonResultDO result = new JsonResultDO();
		  if(userService.getUserByPhone(user.getPhone()) == null){
			  result.addAttribute(JsonResultDO.RETURN_OBJECT_KEY, "fail");  
		      result.setSuccess(false);
		      result.setStatusCode("100");
		      result.setMessage("此手机号码账户不存在");
		      return result;
		  }
		  
		  UserDO cachedUser = UserOnlinePool.currentUser.get();
		  if(cachedUser != null){
			  System.out.println("get the cached userDO ,  userId= " + cachedUser.getUserId());
		  }
		  
		  result.setSuccess(true);
		  return result;
	  }	
	 
}
