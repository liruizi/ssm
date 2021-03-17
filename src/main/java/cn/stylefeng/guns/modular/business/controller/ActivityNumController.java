package cn.stylefeng.guns.modular.business.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.stylefeng.guns.modular.business.entity.ActivityNum;
import cn.stylefeng.guns.modular.business.pojo.ActivityNumRequest;
import cn.stylefeng.guns.modular.business.service.ActivityNumService;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.resource.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.resource.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.resource.api.annotation.PostResource;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;

/**
 * 
 * @ClassName: ActivityController
 * @Description:TODO
 * @author: 活动管理
 * @date: Mar 11, 2021 6:25:32 PM
 *
 */
@Controller
@ApiResource(name = "活动管理我的活动页面渲染")
public class ActivityNumController {

	@Resource
	private ActivityNumService activityNumService;

	/**
	 * 详情
	 */
	@GetResource(name = "我的活动相关-首页-视图", path = "/view/activityNum")
	public String indexView() {
		return "/modular/business/activityNum/activityNum.html";
	}

	/**
	 * 职位管理-首页-视图
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@GetResource(name = "我的活动相关-首页-视图", path = "/view/activityNum/addView")
	public String addView() {
		return "/modular/business/activityNum/activityNum_add.html";
	}

	/**
	 * 职位管理-首页-视图
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@GetResource(name = "我的活动相关-首页-视图", path = "/view/activityNum/editView")
	public String editView() {
		return "/modular/business/activityNum/activityNum_edit.html";
	}

	/**
	 * 查询管理员列表
	 *
	 * @author fengshuonan
	 * @Date 2018/12/24 22:43
	 */
	@RequestMapping("/activityNum/page")
	@ResponseBody
	public Object list(ActivityNumRequest activityRequest) {
		PageResult<ActivityNum> result = this.activityNumService.findPage(activityRequest);
		return new SuccessResponseData(result);
	}

	/**
	 * 添加活动相关内容
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@PostResource(name = "添加活动相关内容", path = "/activityNum/add")
	@ResponseBody
	public ResponseData add(@RequestBody @Validated(ActivityNumRequest.add.class) ActivityNumRequest activityNumRequest) {
		activityNumService.add(activityNumRequest);
		return new SuccessResponseData();
	}

	/**
	 * 删除活动相关内容
	 * 
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@PostResource(name = "删除活动相关内容", path = "/activityNum/delete")
	@ResponseBody
	public ResponseData delete(
			@RequestBody @Validated(ActivityNumRequest.delete.class) ActivityNumRequest activityNumRequest) {
		activityNumService.del(activityNumRequest);
		return new SuccessResponseData();
	}

	/**
	 * 编辑活动相关内容
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@PostResource(name = "编辑活动相关内容", path = "/activityNum/edit")
	@ResponseBody
	public ResponseData edit(
			@RequestBody @Validated(ActivityNumRequest.edit.class) ActivityNumRequest activityNumRequest) {
		activityNumService.edit(activityNumRequest);
		return new SuccessResponseData();
	}
	
	 /**
     * 查看详情
     *
     * @author chenjinlong
     * @date 2020/11/04 11:07
     */
    @GetResource(name = "查看详情系统职位", path = "/activityNum/detail")
    @ResponseBody
    public ResponseData detail(@Validated(ActivityNumRequest.detail.class) ActivityNumRequest activityNumRequest) {
    	ActivityNum detail = activityNumService.detail(activityNumRequest);
        return new SuccessResponseData(JSON.toJSON(detail));
    }


}
