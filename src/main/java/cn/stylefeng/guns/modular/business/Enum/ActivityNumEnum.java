package cn.stylefeng.guns.modular.business.Enum;

import cn.stylefeng.roses.kernel.rule.constants.RuleConstants;
import cn.stylefeng.roses.kernel.rule.exception.AbstractExceptionEnum;
import cn.stylefeng.roses.kernel.system.constants.SystemConstants;
import lombok.Getter;
@Getter
public enum ActivityNumEnum  implements AbstractExceptionEnum {
	/**
     * 活动内容不存在
     */
	ACTIVITY_ORG_NOT_EXIST(RuleConstants.USER_OPERATION_ERROR_TYPE_CODE + SystemConstants.SYSTEM_EXCEPTION_STEP_CODE + "1001", "活动相关内容不存在：内容id：{}"),
	
	/***
	 * 活动累计次数不能为空
	 */
	TIMES_NOT_EXIST(RuleConstants.USER_OPERATION_ERROR_TYPE_CODE + SystemConstants.SYSTEM_EXCEPTION_STEP_CODE + "1002", "activity add number is null：lei ji ci shu 1002"),
	
	/***
	 * 活动编号
	 */
	ACTIVITY_NOT_EXIST(RuleConstants.USER_OPERATION_ERROR_TYPE_CODE + SystemConstants.SYSTEM_EXCEPTION_STEP_CODE + "1003", "activity number is null：1003"),
	
	
	/***
	 * 活动主题 主办 协办 等相关
	 */
	TITLE_NOT_EXIST(RuleConstants.USER_OPERATION_ERROR_TYPE_CODE + SystemConstants.SYSTEM_EXCEPTION_STEP_CODE + "1004", "activity title is null : 1004");

    /**
     * 错误编码
     */
    private final String errorCode;

    /**
     * 提示用户信息
     */
    private final String userTip;

    ActivityNumEnum(String errorCode, String userTip) {
        this.errorCode = errorCode;
        this.userTip = userTip;
    }

	

}
