package cn.stylefeng.guns.modular.business.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * tb_activity
 *
 * @author fengshuonan
 * @date 2021/03/22 14:07
 */
@Data
public class ActivityResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Long id;

	/**
	 * 行政单位
	 */
	private String area;
	/**
	 * 制表日期
	 */
	private String tabulationDate;

	/**
	 * 活动编号
	 */
	private String number;

	/**
	 * 类型编号
	 */
	private String typeNumber;

	/**
	 * 活动主办
	 */
	private String organizer;

	/**
	 * 指导协办
	 */
	private String guide;

	/**
	 * 活动时间
	 */
	private String times;
	/**
	 * 活动时间
	 */
	private String hour;

	/**
	 * 活动地点
	 */
	private String address;

	/**
	 * 活动主题
	 */
	private String title;

	/**
	 * 活动内容
	 */
	private String content;

	/**
	 * 活动内容-知识普及
	 */
	private String contentKnowledge;
	
	/**
	 * 活动内容-专题指导
	 */
	private String contentGuidance;
	
	/**
	 * 活动内容-互动交流
	 */
	private String contentExchange;
	
	/**
	 * 活动内容-大型活动
	 */
	private String contentEvent;
	
	/**
	 * 活动对象-学校
	 */
	private String objectSchool;
	
	/***
	 * 活动对象-机关
	 */
	private String objectOffice;
	
	/**
	 * 活动对象-社区
	 */
	private String objectCommunity;
	
	/**
	 * 活动对象-部队
	 */
	private String objectTroops;

	/**
	 * 活动对象
	 */
	private String object;

	/**
	 * 活动类型
	 */
	private String type;

	/**
	 * 活动场次
	 */
	private String sessions;

	/**
	 * 活动对接-对接单位
	 */
	private String unit;

	/**
	 * 活动对接-对应人员
	 */
	private String people;

	/**
	 * 活动对接-联系方式
	 */
	private String contact;

	/**
	 * 活动联系
	 */
	private String activityContact;

	/**
	 * 活动确认
	 */
	private String activityConfir;

	/**
	 * 活动负责
	 */
	private String activityResp;

	/**
	 * 服务人员
	 */
	private String servicePersonnel;

	/**
	 * 车辆保障
	 */
	private String vehicleSecurity;

	/**
	 * 司机
	 */
	private String driver;

	/**
	 * 邀请媒体
	 */
	private String inviteMedia;

	/**
	 * 执行单位
	 */
	private String executiveUnit;

	/**
	 * 基本情况
	 */
	private String basic;
	
	/**
	 * 笔记本电脑
	 */
	private String laptop;

	/**
	 * 活动道具
	 */
	private String props;

	/**
	 * 活动背景
	 */
	private String background;

	/**
	 * 宣传展览
	 */
	private String propagandaExhibition;

	/**
	 * 音响器材
	 */
	private String audio;

	/**
	 * 摄录器材
	 */
	private String videoRecording;

	/**
	 * 急救器材
	 */
	private String firstAid;

	/**
	 * 宣传资料
	 */
	private String propaganda;

	/**
	 * 图书绘本
	 */
	private String bookPicture;

	/**
	 * 活动赠品
	 */
	private String gifts;

	/**
	 * 出发时间
	 */
	private String departureTime;

	/**
	 * 活动时长
	 */
	private String duration;

	/**
	 * 照片数量
	 */
	private String pictureNum;

	/**
	 * 视频资料
	 */
	private String videoMaterial;

	/**
	 * 信息采集
	 */
	private String information;

	/**
	 * 物品维护
	 */
	private String item;

	/**
	 * 典型案例
	 */
	private String cases;

	/**
	 * 问题与建议
	 */
	private String questions;

	/**
	 * 参加人数
	 */
	private String theNumber;

	/**
	 * 人员类型
	 */
	private String personType;

	/**
	 * 完成情况
	 */
	private String completion;

	/**
	 * 活动负责人
	 */
	private String leader;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 创建人
	 */
	private Long createUser;

	/**
	 * 更新人
	 */
	private Long updateUser;
	
	
	 /**
     * 开始时间
     */
    private String beginTime;

    /**
     * 结束时间
     */
    private String endTime;

}
