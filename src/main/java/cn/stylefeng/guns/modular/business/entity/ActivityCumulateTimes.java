package cn.stylefeng.guns.modular.business.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * 
 * @ClassName:  ActivityCumulateTimes   
 * @Description:活动累计次数
 * @author: David
 * @date:   Mar 17, 2021 2:36:14 PM   
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_activity_cumulate_times")
public class ActivityCumulateTimes extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@TableId(value = "id")
	private Long id;

	// 年
	@TableField("year")
	private String year;


	//累计次数
	@TableField("numbers")
	private Integer numbers;


}
