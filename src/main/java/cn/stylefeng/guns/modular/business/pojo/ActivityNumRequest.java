package cn.stylefeng.guns.modular.business.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActivityNumRequest extends BaseRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "主键不能为空", groups = { edit.class, detail.class, delete.class })
	private Integer id;

	@NotBlank(message = "活动年限不能为空", groups = { add.class, edit.class })
	private String year;

	@NotBlank(message = "活动城区不能为空", groups = { add.class, edit.class })
	private String area;

	@NotBlank(message = "活动类型不能为空", groups = { add.class, edit.class })
	private String type;

	@NotBlank(message = "活动类型编号前缀不能为空", groups = { add.class, edit.class })
	private String type_serial;

	@NotBlank(message = "活动主办不能为空", groups = { add.class, edit.class })
	private String host;

	@NotBlank(message = "活动协办不能为空", groups = { add.class, edit.class })
	private String guide;

	@NotBlank(message = "活动标题不能为空", groups = { add.class, edit.class })
	private String title;

}
