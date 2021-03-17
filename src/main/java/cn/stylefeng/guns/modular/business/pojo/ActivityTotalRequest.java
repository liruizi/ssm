package cn.stylefeng.guns.modular.business.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActivityTotalRequest extends BaseRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "主键不能为空", groups = { edit.class, detail.class, delete.class })
	private Long id;

	@NotBlank(message = "活动年限不能为空", groups = { add.class, edit.class })
	private String year;

	@NotBlank(message = "活动编号不能为空", groups = { add.class, edit.class })
	private String number;

	@NotBlank(message = "活动前缀不能为空", groups = { add.class, edit.class })
	private String prefix;

	@NotBlank(message = "活动区域不能为空", groups = { add.class, edit.class })
	private String area;

}
