package cn.stylefeng.guns.modular.business.pojo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
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
public class ActivityParam extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6531250647846586184L;

	/**
	 * id
	 */
	@NotNull(message = "id不能为空", groups = { edit.class })
	private Long id;

	/**
	 * 制表日期
	 */
	@NotNull(message = "制表日期不能为空", groups = { add.class, edit.class })
	private String tabulationDate;

	/**
	 * 行政单位
	 */
	private String area;

	/**
	 * 活动编号
	 */
	@NotNull(message = "活动编号不能为空", groups = { add.class, edit.class })
	private String number;

	/**
	 * 类型编号
	 */
	@NotNull(message = "类型编号不能为空", groups = { add.class, edit.class })
	private String typeNumber;

	/**
	 * 活动主办
	 */
	@NotNull(message = "活动主办不能为空", groups = { add.class, edit.class })
	private String organizer;

	/**
	 * 指导协办
	 */
	@NotNull(message = "指导协办不能为空", groups = { add.class, edit.class })
	private String guide;

	/**
	 * 活动时间
	 */
	@NotNull(message = "活动时间不能为空", groups = { add.class, edit.class })
	private String times;

	/**
	 * 活动时间
	 */
	@NotNull(message = "活动时间不能为空", groups = { add.class, edit.class })
	private String hour;

	/**
	 * 活动地点
	 */
	@NotNull(message = "活动地点不能为空", groups = { add.class, edit.class })
	private String address;

	/**
	 * 活动主题
	 */
	@NotNull(message = "活动主题不能为空", groups = { add.class, edit.class })
	private String title;

	/**
	 * 活动内容
	 */
	@NotNull(message = "活动内容不能为空", groups = { add.class, edit.class })
	private String content;

	/**
	 * 活动对象
	 */
	@NotNull(message = "活动对象不能为空", groups = { add.class, edit.class })
	private String object;

	/**
	 * 活动类型
	 */
	@NotNull(message = "活动类型不能为空", groups = { add.class, edit.class })
	private String type;

	/**
	 * 活动场次
	 */
	@NotNull(message = "活动场次不能为空", groups = { add.class, edit.class })
	private String sessions;

	/**
	 * 活动对接-对接单位
	 */
	@NotNull(message = "活动对接-对接单位不能为空", groups = { add.class, edit.class })
	private String unit;

	/**
	 * 活动对接-对应人员
	 */
	@NotNull(message = "活动对接-对应人员不能为空", groups = { add.class, edit.class })
	private String people;

	/**
	 * 活动对接-联系方式
	 */
	@NotNull(message = "活动对接-联系方式不能为空", groups = { add.class, edit.class })
	private String contact;

	/**
	 * 活动联系
	 */
	@NotNull(message = "活动联系不能为空", groups = { add.class, edit.class })
	private String activityContact;

	/**
	 * 活动确认
	 */
	@NotNull(message = "活动确认不能为空", groups = { add.class, edit.class })
	private String activityConfir;

	/**
	 * 活动负责
	 */
	@NotNull(message = "活动负责不能为空", groups = { add.class, edit.class })
	private String activityResp;

	/**
	 * 服务人员
	 */
	@NotNull(message = "服务人员不能为空", groups = { add.class, edit.class })
	private String servicePersonnel;

	/**
	 * 车辆保障
	 */
	@NotNull(message = "车辆保障不能为空", groups = { add.class, edit.class })
	private String vehicleSecurity;

	/**
	 * 司机
	 */
	@NotNull(message = "司机不能为空", groups = { add.class, edit.class })
	private String driver;

	/**
	 * 邀请媒体
	 */
	@NotNull(message = "邀请媒体不能为空", groups = { add.class, edit.class })
	private String inviteMedia;

	/**
	 * 执行单位
	 */
	@NotNull(message = "执行单位不能为空", groups = { add.class, edit.class })
	private String executiveUnit;

	/**
	 * 基本情况
	 */
	@NotNull(message = "基本情况不能为空", groups = { add.class, edit.class })
	private String basic;

	/**
	 * 笔记本电脑
	 */
	@NotNull(message = "笔记本电脑不能为空", groups = { add.class, edit.class })
	private String laptop;

	/**
	 * 活动道具
	 */
	@NotNull(message = "活动道具不能为空", groups = { add.class, edit.class })
	private String props;

	/**
	 * 活动背景
	 */
	@NotNull(message = "活动背景不能为空", groups = { add.class, edit.class })
	private String background;

	/**
	 * 宣传展览
	 */
	@NotNull(message = "宣传展览不能为空", groups = { add.class, edit.class })
	private String propagandaExhibition;

	/**
	 * 音响器材
	 */
	@NotNull(message = "音响器材不能为空", groups = { add.class, edit.class })
	private String audio;

	/**
	 * 摄录器材
	 */
	@NotNull(message = "摄录器材不能为空", groups = { add.class, edit.class })
	private String videoRecording;

	/**
	 * 急救器材
	 */
	@NotNull(message = "急救器材不能为空", groups = { add.class, edit.class })
	private String firstAid;

	/**
	 * 宣传资料
	 */
	@NotNull(message = "宣传资料不能为空", groups = { add.class, edit.class })
	private String propaganda;

	/**
	 * 图书绘本
	 */
	@NotNull(message = "图书绘本不能为空", groups = { add.class, edit.class })
	private String bookPicture;

	/**
	 * 活动赠品
	 */
	@NotNull(message = "活动赠品不能为空", groups = { add.class, edit.class })
	private String gifts;

	/**
	 * 出发时间
	 */
	@NotNull(message = "出发时间不能为空", groups = { add.class, edit.class })
	private String departureTime;

	/**
	 * 活动时长
	 */
	@NotNull(message = "活动时长不能为空", groups = { add.class, edit.class })
	private String duration;

	/**
	 * 照片数量
	 */
	@NotNull(message = "照片数量不能为空", groups = { add.class, edit.class })
	private String pictureNum;

	/**
	 * 视频资料
	 */
	@NotNull(message = "视频资料不能为空", groups = { add.class, edit.class })
	private String videoMaterial;

	/**
	 * 信息采集
	 */
	@NotNull(message = "信息采集不能为空", groups = { add.class, edit.class })
	private String information;

	/**
	 * 物品维护
	 */
	@NotNull(message = "物品维护不能为空", groups = { add.class, edit.class })
	private String item;

	/**
	 * 典型案例
	 */
	@NotNull(message = "典型案例不能为空", groups = { add.class, edit.class })
	private String cases;

	/**
	 * 问题与建议
	 */
	@NotNull(message = "问题与建议不能为空", groups = { add.class, edit.class })
	private String questions;

	/**
	 * 参加人数
	 */
	@NotNull(message = "参加人数不能为空", groups = { add.class, edit.class })
	private String theNumber;

	/**
	 * 人员类型
	 */
	@NotNull(message = "人员类型不能为空", groups = { add.class, edit.class })
	private String personType;

	/**
	 * 完成情况
	 */
	@NotNull(message = "完成情况不能为空", groups = { add.class, edit.class })
	private String completion;

	/**
	 * 活动负责人
	 */
	@NotNull(message = "活动负责人不能为空", groups = { add.class, edit.class })
	private String leader;

	/**
	 * 活动内容-知识普及
	 */
	@NotNull(message = "活动内容-知识普及", groups = { add.class, edit.class })
	private String contentKnowledge;
	
	/**
	 * 活动内容-专题指导
	 */
	@NotNull(message = "活动内容-专题指导", groups = { add.class, edit.class })
	private String contentGuidance;
	
	/**
	 * 活动内容-互动交流
	 */
	@NotNull(message = "活动内容-互动交流", groups = { add.class, edit.class })
	private String contentExchange;
	
	/**
	 * 活动内容-大型活动
	 */
	@NotNull(message = "活动内容-大型活动", groups = { add.class, edit.class })
	private String contentEvent;
	
	/**
	 * 活动对象-学校
	 */
	@NotNull(message = "活动对象-学校", groups = { add.class, edit.class })
	private String objectSchool;
	
	/***
	 * 活动对象-机关
	 */
	@NotNull(message = "活动对象-机关", groups = { add.class, edit.class })
	private String objectOffice;
	
	/**
	 * 活动对象-社区
	 */
	@NotNull(message = "活动对象-社区", groups = { add.class, edit.class })
	private String objectCommunity;
	
	/**
	 * 活动对象-部队
	 */
	@NotNull(message = "活动对象-部队", groups = { add.class, edit.class })
	private String objectTroops;

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

}
