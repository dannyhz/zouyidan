package com.zyd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zyd.dto.LoanApplicationDTO;
import com.zyd.model.LoanApplicationDO;

/**
 * @author Zhu Xiang
 */
public interface ILoanApplicationDao {
	
	/**
	 * @param order
	 * @return
	 *
	 */
	int insert(LoanApplicationDO application);
	
	/**
	 * @param query
	 * @return
	 *
	 */
	int isExist(LoanApplicationDTO query);
	
	/**
	 * @param queryDO
	 * @return
	 *
	 */
	List<LoanApplicationDO> queryApplicationById(LoanApplicationDO queryDO);
	
	/**
	 * @param queryDO
	 * @return
	 *
	 */
	List<LoanApplicationDO> queryLoanApplicationByStatus(LoanApplicationDO queryDO);

}
