package com.zyd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyd.common.JsonResultDO;
import com.zyd.dto.AuthDTO;
import com.zyd.model.auth.SysAuth;
import com.zyd.service.AuthService;

@RestController
@RequestMapping("/auth/*")
public class AuthController {
	
	@Resource
	private AuthService authService;
	
	 
	 @RequestMapping("add")
	 public JsonResultDO addRoleAuth(AuthDTO authDTO) {
		 
		 System.out.println(authDTO.getRoleId());
		 JsonResultDO rslt = new JsonResultDO();
		 rslt.setData(authDTO.getSysAuthContent());
		 List<SysAuth> sysAuthList = rslt.parseDataList(SysAuth.class);
		 authService.createRoleMenuAuth(sysAuthList);
		 
		 return rslt; 
	 }
}
