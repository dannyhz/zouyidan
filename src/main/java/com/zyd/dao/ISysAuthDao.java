package com.zyd.dao;

import com.zyd.model.auth.SysAuth;
import com.zyd.model.auth.SysRole;

/**
 * @author Zhu Xiang
 */
public interface ISysAuthDao {
	
	int insert(SysAuth sysAuth);
	
	int deleteAuthByRole(SysRole sysRole);
}
