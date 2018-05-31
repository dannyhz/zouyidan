package com.zyd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	 * @param order
	 * @return
	 */
	int insertKey(LoanApplicationDO application);
	
	/**
	 * @param order
	 * @return
	 *
	 */
	int update(LoanApplicationDO application);
	
	/**
	 * @param id
	 * @return
	 *
	 */
	int deleteById(Integer id);
	
	/**
	 * @param ids
	 * @return
	 *
	 */
	int delBatch(@Param("ids")List<Integer> ids);
	
	/**
	 * @param query
	 * @return
	 *
	 */
	int delByDTO(LoanApplicationDO query);
	
	/**
	 * @param query
	 * @return
	 *
	 */
	int isExist(LoanApplicationDO query);

}
