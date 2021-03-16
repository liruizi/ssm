package cn.stylefeng.guns.modular.business.entity;

import java.io.Serializable;

/***
 * 
 * @ClassName: Activity
 * @Description:返回前端页面总分类
 * @author: David
 * @date: Mar 15, 2021 6:26:37 PM
 *
 */
public class ActivityVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4794684330067412443L;

	// 活动名称
	private String activityName;
	// 活动场次
	private String activitySession;

	// 活动编号
	private String activityNum;

	// 活动主办单位
	private String activityHost;

	// 活动主题
	private String activityTitle;

	// 活动类型
	private String activityType;

	// 活动指导
	private String activityGuide;

	// 执行单位
	private String executiveUnit;

	// 执行地址
	private String executiveAddress;

	public String getActivitySession() {
		return activitySession;
	}

	public void setActivitySession(String activitySession) {
		this.activitySession = activitySession;
	}

	public String getActivityNum() {
		return activityNum;
	}

	public void setActivityNum(String activityNum) {
		this.activityNum = activityNum;
	}

	public String getActivityHost() {
		return activityHost;
	}

	public void setActivityHost(String activityHost) {
		this.activityHost = activityHost;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getActivityGuide() {
		return activityGuide;
	}

	public void setActivityGuide(String activityGuide) {
		this.activityGuide = activityGuide;
	}

	public String getExecutiveUnit() {
		return executiveUnit;
	}

	public void setExecutiveUnit(String executiveUnit) {
		this.executiveUnit = executiveUnit;
	}

	public String getExecutiveAddress() {
		return executiveAddress;
	}

	public void setExecutiveAddress(String executiveAddress) {
		this.executiveAddress = executiveAddress;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

}
