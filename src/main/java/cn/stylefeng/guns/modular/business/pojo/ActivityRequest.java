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

	private String title;

	private String data;

	private String address;

	private String content;

	private String object;
}
