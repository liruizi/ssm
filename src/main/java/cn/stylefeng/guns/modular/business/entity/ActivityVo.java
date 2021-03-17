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

	// 活动编号
	private String activityNum;

	// 活动类型编号
	private String activityTypeNum;

	// 活动主办单位
	private String activityHost;

	// 活动主题
	private String activityTitle;

	// 活动类型
	private String activityType;

	// 活动指导
	private String activityGuide;


	// 累计次数
	private String cumulateTimes;


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

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getCumulateTimes() {
		return cumulateTimes;
	}

	public void setCumulateTimes(String cumulateTimes) {
		this.cumulateTimes = cumulateTimes;
	}

	public String getActivityTypeNum() {
		return activityTypeNum;
	}

	public void setActivityTypeNum(String activityTypeNum) {
		this.activityTypeNum = activityTypeNum;
	}

}
