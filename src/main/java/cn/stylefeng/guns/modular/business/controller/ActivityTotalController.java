package cn.stylefeng.guns.modular.business.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.stylefeng.guns.modular.business.entity.ActivityTotal;
import cn.stylefeng.guns.modular.business.pojo.ActivityTotalRequest;
import cn.stylefeng.guns.modular.business.service.ActivityTotalService;
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
public class ActivityTotalController {

	@Resource
	private ActivityTotalService activityService;

	/**
	 * 详情
	 */
	@GetResource(name = "我的活动相关-首页-视图", path = "/view/activityTotal")
	public String indexView() {
		return "/modular/business/activityTotal/activityTotal.html";
	}
	/**
	 * 首页-视图
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@GetResource(name = "我的活动相关-首页-视图", path = "/view/activityTotal/addView")
	public String addView() {
		return "/modular/business/activityTotal/activityTotal_add.html";
	}

	/**
	 * 首页-视图
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@GetResource(name = "我的活动相关-首页-视图", path = "/view/activityTotal/editView")
	public String editView() {
		return "/modular/business/activityTotal/activityTotal_edit.html";
	}

	/**
	 * 查询管理员列表
	 *
	 * @author fengshuonan
	 * @Date 2018/12/24 22:43
	 */
	@RequestMapping("/activityTotal/page")
	@ResponseBody
	public Object list(ActivityTotalRequest activityRequest) {
		PageResult<ActivityTotal> result = this.activityService.findPage(activityRequest);
		return new SuccessResponseData(result);
	}

	/**
	 * 添加活动相关内容
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@PostResource(name = "添加活动相关内容", path = "/activityTotal/add")
	@ResponseBody
	public ResponseData add(@RequestBody @Validated(ActivityTotalRequest.add.class) ActivityTotalRequest activityRequest) {
		activityService.add(activityRequest);
		return new SuccessResponseData();
	}

	/**
	 * 删除活动相关内容
	 * 
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@PostResource(name = "删除活动相关内容", path = "/activityTotal/delete")
	@ResponseBody
	public ResponseData delete(
			@RequestBody @Validated(ActivityTotalRequest.delete.class) ActivityTotalRequest activityRequest) {
		activityService.del(activityRequest);
		return new SuccessResponseData();
	}

	/**
	 * 编辑活动相关内容
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@PostResource(name = "编辑活动相关内容", path = "/activityTotal/edit")
	@ResponseBody
	public ResponseData edit(
			@RequestBody @Validated(ActivityTotalRequest.edit.class) ActivityTotalRequest activityRequest) {
		activityService.edit(activityRequest);
		return new SuccessResponseData();
	}
	
	 /**
     * 查看详情
     *
     * @author chenjinlong
     * @date 2020/11/04 11:07
     */
    @GetResource(name = "查看详情", path = "/activityTotal/detail")
    @ResponseBody
    public ResponseData detail(@Validated(ActivityTotalRequest.detail.class) ActivityTotalRequest activityRequest) {
    	ActivityTotal detail = activityService.detail(activityRequest);
        return new SuccessResponseData(JSON.toJSON(detail));
    }


}
