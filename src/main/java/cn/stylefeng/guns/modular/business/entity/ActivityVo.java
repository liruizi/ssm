package cn.stylefeng.guns.modular.business.entity;

import java.io.Serializable;

import lombok.Data;

/***
 * 
 * @ClassName: Activity
 * @Description:返回前端页面总分类
 * @author: David
 * @date: Mar 15, 2021 6:26:37 PM
 *
 */
@Data
public class ActivityVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4794684330067412443L;

	// 活动名称
	private String area;

	// 活动编号
	private String number;

	// 活动类型编号
	private String typeNumber;

	// 活动主办单位
	private String organizer;

	// 活动主题
	private String title;

	// 活动类型
	private String type;

	// 活动指导
	private String guide;

	// 累计次数
	private String sessions;

	// 返回编号
	private String code;
}
