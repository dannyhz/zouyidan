package com.zyd.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.evun.sweet.core.common.JsonResultDO;
import com.zyd.model.SalesmanDO;
import com.zyd.model.UserDO;
import com.zyd.service.LoanApplicationService;

@RestController
@RequestMapping("/salesman/*")
public class SalesmanController {
	
	@Resource
	LoanApplicationService loanApplicationService;
	
	@RequestMapping("/Msg")
	 public JsonResultDO register(UserDO user) {
		 
		 JsonResultDO result = new JsonResultDO();
//		 UserDO userDo = userService.getUser(user);
//		 if(userDo == null){
//			 result.setSuccess(false);
//		     result.setStatusCode("200");
//		     result.setMessage("密码有误");
//		     return result;
//		 }
		 return result; 
	 } 
	
	
	 @RequestMapping("add")
	 public JsonResultDO addNewSalesman(SalesmanDO salesman) {
		 
		 JsonResultDO rslt = new JsonResultDO();
		
		 //rslt.setCode("0000");
		 rslt.setMessage("add successful");
		 
		 
		return rslt; 
	 }
}
