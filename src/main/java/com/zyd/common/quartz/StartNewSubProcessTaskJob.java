package com.zyd.common.quartz;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.zyd.dao.ILoanApplicationDao;
import com.zyd.model.LoanApplicationDO;


public class StartNewSubProcessTaskJob implements Job{

	//private static final Logger LOGGER = StartNewSubProcessTaskJob.getLogger();

	
	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		//LOGGER.info("开始执行 - 每日跑明细凭证的任务 ， 执行时间 ：  " + DateUtils.getDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		
		ILoanApplicationDao applicationDao = (ILoanApplicationDao)jobContext.getJobDetail().getJobDataMap().get("applicationDao");
		LoanApplicationDO application = new LoanApplicationDO();
		application.setLoanApplicationId(1L);
		List<LoanApplicationDO> list = applicationDao.queryApplicationById(application);
		System.out.println("size = " + list.size());
        
        //LOGGER.info("完成执行 ， 完成时间 ：  " + DateUtils.getDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}

}
