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

	@TableField("title")
	private String title;

	@TableField("data")
	private String data;

	@TableField("address")
	private String address;

	@TableField("content")
	private String content;

	@TableField("object")
	private String object;

}
