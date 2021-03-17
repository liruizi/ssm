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
@TableName("tb_activity")
public class Activity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	//
	@TableId(value = "id")
	private Long id;

	// 编号
	@TableField("number")
	private Integer number;
	// 年
	@TableField("year")
	private String year;

	// 城区
	@TableField("area")
	private String area;

	// 前缀
	@TableField("prefix")
	private String prefix;

}
