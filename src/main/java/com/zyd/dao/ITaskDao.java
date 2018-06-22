package com.zyd.dao;

import java.util.List;

import com.zyd.model.TaskDO;

/**
 * @author Zhu Xiang
 */
public interface ITaskDao {
	
	/**
	 * @param order
	 * @return
	 *
	 */
	int insert(TaskDO application);
	
	/**
	 * @param query
	 * @return
	 *
	 */
	int isExist(TaskDO query);
	
	/**
	 * @param queryDO
	 * @return
	 *
	 */
	List<TaskDO> queryTaskById(TaskDO queryDO);
	
	/**
	 * @param queryDO
	 * @return
	 *
	 */
	List<TaskDO> queryTaskByStatus(TaskDO queryDO);

}
