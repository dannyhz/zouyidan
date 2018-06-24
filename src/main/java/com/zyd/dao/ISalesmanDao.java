package com.zyd.dao;

import java.util.List;

import com.zyd.model.SalesmanDO;

/**
 * @author Zhu Xiang
 */
public interface ISalesmanDao {
	
	int insert(SalesmanDO salesmanDo);
	
	int update(SalesmanDO salesmanDo);
	
	List<SalesmanDO> queryList(SalesmanDO salesmanDo);
}
