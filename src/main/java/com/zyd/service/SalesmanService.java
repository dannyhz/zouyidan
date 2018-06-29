package com.zyd.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zyd.dao.ISalesmanDao;
import com.zyd.model.LoanApplicationDO;
import com.zyd.model.SalesmanDO;
import com.zyd.model.TaskDO;
@Component
public class SalesmanService {
	
	@Resource
	private ISalesmanDao salesmanDao;
	
	public SalesmanDO addNewSalesman(SalesmanDO salesman){
		
		//1. 保存  salesman
		//2. 保存 sys_user
		salesmanDao.insert(salesman);
		
		return salesman;
	}

}
