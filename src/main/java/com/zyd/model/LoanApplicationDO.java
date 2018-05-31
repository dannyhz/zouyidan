package com.zyd.model;

/**
 * 借款申请
 * @author Zhu Xiang
 *
 */
public class LoanApplicationDO {
	
	private Long applyId; 
	private Long applyPersonId;
	private String applyStatus;
	
	public Long getApplyId() {
		return applyId;
	}
	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}
	public Long getApplyPersonId() {
		return applyPersonId;
	}
	public void setApplyPersonId(Long applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	public String getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	

}
