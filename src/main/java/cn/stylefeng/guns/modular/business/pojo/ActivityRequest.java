package cn.stylefeng.guns.modular.business.pojo;

import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ActivityRequest extends BaseRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//
	private Integer id;

	// 编号
	private Integer number;
	// 年
	private String year;

	// 城区
	private String area;

	// 总次数
	private Integer total;

	// 活动类型
	private String type;
}
