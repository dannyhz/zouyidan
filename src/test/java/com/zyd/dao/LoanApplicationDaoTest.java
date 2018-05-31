package com.zyd.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyd.model.LoanApplicationDO;
import com.zyd.service.BaseService;

public class LoanApplicationDaoTest {
	
	@Test
	public void suppose_insert_loan_application_success(){
		
		 ApplicationContext act = new ClassPathXmlApplicationContext(new String[] { "config/zyd-context.xml" });
		 ILoanApplicationDao loanAppDao = act.getBean(ILoanApplicationDao.class);
		 System.out.println(loanAppDao);
		 LoanApplicationDO loanApp = new LoanApplicationDO();
		 loanApp.setApplyId(1000L);
		 loanApp.setApplyPersonId(200L);
		 loanApp.setApplyStatus("START");
		 
		 loanAppDao.insert(loanApp);
		
	}

}
