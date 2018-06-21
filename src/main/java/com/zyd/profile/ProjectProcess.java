package com.zyd.profile;

public class ProjectProcess {
	
	private int sequence;
	private String id;
	private String operator;
	private String scanPreStts;//进入模块的被扫描的状态
	private String waitStts;//进入模块的第一个被转化的状态 第一个都是等待 ， 等到处理完才是 pass ，如果失败终结 就是 fail
	private String passStts;
	private String failStts;
	private String unit;//角色  还是  某个人

}
