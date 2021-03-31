package cn.stylefeng.guns.modular.business.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * tb_activity
 *
 * @author fengshuonan
 * @date 2021/03/22 14:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_activity")
public class Activity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7032957009379944260L;

	/**
	 * id
	 */
	@TableId("id")
	private Long id;

	/**
	 * 制表日期
	 */
	@TableField("tabulation_date")
	private String tabulationDate;

	/**
	 * 行政单位
	 */
	@TableField("area")
	private String area;
	/**
	 * 活动编号
	 */
	@TableField("number")
	private String number;

	/**
	 * 类型编号
	 */
	@TableField("type_number")
	private String typeNumber;

	/**
	 * 活动主办
	 */
	@TableField("organizer")
	private String organizer;

	/**
	 * 指导协办
	 */
	@TableField("guide")
	private String guide;

	/**
	 * 活动时间
	 */
	@TableField("times")
	private String times;
	/**
	 * 活动时间
	 */
	@TableField("hour")
	private String hour;

	/**
	 * 活动地点
	 */
	@TableField("address")
	private String address;

	/**
	 * 活动主题
	 */
	@TableField("title")
	private String title;

	/**
	 * 活动内容
	 */
	@TableField("content")
	private String content;
	
	/**
	 * 活动内容-知识普及
	 */
	@TableField("content_knowledge")
	private String contentKnowledge;
	
	/**
	 * 活动内容-专题指导
	 */
	@TableField("content_guidance")
	private String contentGuidance;
	
	/**
	 * 活动内容-互动交流
	 */
	@TableField("content_exchange")
	private String contentExchange;
	
	/**
	 * 活动内容-大型活动
	 */
	@TableField("content_event")
	private String contentEvent;
	
	/**
	 * 活动对象-学校
	 */
	@TableField("object_school")
	private String objectSchool;
	
	/***
	 * 活动对象-机关
	 */
	@TableField("object_office")
	private String objectOffice;
	
	/**
	 * 活动对象-社区
	 */
	@TableField("object_community")
	private String objectCommunity;
	
	/**
	 * 活动对象-部队
	 */
	@TableField("object_troops")
	private String objectTroops;
	

	/**
	 * 活动对象
	 */
	@TableField("object")
	private String object;

	/**
	 * 活动类型
	 */
	@TableField("type")
	private String type;

	/**
	 * 活动场次
	 */
	@TableField("sessions")
	private String sessions;

	/**
	 * 活动对接-对接单位
	 */
	@TableField("unit")
	private String unit;

	/**
	 * 活动对接-对应人员
	 */
	@TableField("people")
	private String people;

	/**
	 * 活动对接-联系方式
	 */
	@TableField("contact")
	private String contact;

	/**
	 * 活动联系
	 */
	@TableField("activity_contact")
	private String activityContact;

	/**
	 * 活动确认
	 */
	@TableField("activity_confir")
	private String activityConfir;

	/**
	 * 活动负责
	 */
	@TableField("activity_resp")
	private String activityResp;

	/**
	 * 服务人员
	 */
	@TableField("service_personnel")
	private String servicePersonnel;

	/**
	 * 车辆保障
	 */
	@TableField("vehicle_security")
	private String vehicleSecurity;

	/**
	 * 司机
	 */
	@TableField("driver")
	private String driver;

	/**
	 * 邀请媒体
	 */
	@TableField("invite_media")
	private String inviteMedia;

	/**
	 * 执行单位
	 */
	@TableField("executive_unit")
	private String executiveUnit;

	/**
	 * 笔记本电脑
	 */
	@TableField("laptop")
	private String laptop;
	
	/**
	 * 基本情况
	 */
	@TableField("basic")
	private String basic;

	/**
	 * 活动道具
	 */
	@TableField("props")
	private String props;

	/**
	 * 活动背景
	 */
	@TableField("background")
	private String background;

	/**
	 * 宣传展览
	 */
	@TableField("propaganda_exhibition")
	private String propagandaExhibition;

	/**
	 * 音响器材
	 */
	@TableField("audio")
	private String audio;

	/**
	 * 摄录器材
	 */
	@TableField("video_recording")
	private String videoRecording;

	/**
	 * 急救器材
	 */
	@TableField("first_aid")
	private String firstAid;

	/**
	 * 宣传资料
	 */
	@TableField("propaganda")
	private String propaganda;

	/**
	 * 图书绘本
	 */
	@TableField("book_picture")
	private String bookPicture;

	/**
	 * 活动赠品
	 */
	@TableField("gifts")
	private String gifts;

	/**
	 * 出发时间
	 */
	@TableField("departure_time")
	private String departureTime;

	/**
	 * 活动时长
	 */
	@TableField("duration")
	private String duration;

	/**
	 * 照片数量
	 */
	@TableField("picture_num")
	private String pictureNum;

	/**
	 * 视频资料
	 */
	@TableField("video_material")
	private String videoMaterial;

	/**
	 * 信息采集
	 */
	@TableField("information")
	private String information;

	/**
	 * 物品维护
	 */
	@TableField("item")
	private String item;

	/**
	 * 典型案例
	 */
	@TableField("cases")
	private String cases;

	/**
	 * 问题与建议
	 */
	@TableField("questions")
	private String questions;

	/**
	 * 参加人数
	 */
	@TableField("the_number")
	private String theNumber;

	/**
	 * 人员类型
	 */
	@TableField("person_type")
	private String personType;

	/**
	 * 完成情况
	 */
	@TableField("completion")
	private String completion;

	/**
	 * 活动负责人
	 */
	@TableField("leader")
	private String leader;

}
