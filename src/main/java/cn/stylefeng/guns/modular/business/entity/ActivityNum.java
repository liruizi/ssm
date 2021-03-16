package cn.stylefeng.guns.modular.business.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @ClassName: Activity
 * @Description:TODO
 * @author: David
 * @date: Mar 11, 2021 6:26:56 PM
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_activity_num")
public class ActivityNum extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@TableId(value = "id")
	private Long id;

	// 年
	@TableField("year")
	private String year;

	// 城区
	@TableField("area")
	private String area;

	// 活动类型
	@TableField("type")
	private String type;

	// 编号
	@TableField("serial")
	private Integer serial;

	// 编号前缀
	@TableField("type_serial")
	private String type_serial;

	// 活动主办
	@TableField("host")
	private String host;

	// 活动协办
	@TableField("guide")
	private String guide;

	// 活动主题
	@TableField("title")
	private String title;

}
