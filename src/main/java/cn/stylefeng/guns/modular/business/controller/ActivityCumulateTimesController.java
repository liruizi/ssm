package cn.stylefeng.guns.modular.business.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.stylefeng.guns.modular.business.entity.ActivityCumulateTimes;
import cn.stylefeng.guns.modular.business.pojo.ActivityCumulateTimesRequest;
import cn.stylefeng.guns.modular.business.service.ActivityCumulateTimesService;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.resource.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.resource.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.resource.api.annotation.PostResource;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;

/***
 * 
 * @ClassName:  ActivityCumulateTimesController   
 * @Description:获取累计次数
 * @author: David
 * @date:   Mar 17, 2021 2:38:30 PM   
 *
 */
@Controller
@ApiResource(name = "活动累计次数页面渲染")
public class ActivityCumulateTimesController {

	@Resource
	private ActivityCumulateTimesService activityService;

	/**
	 * 详情
	 */
	@GetResource(name = "活动累计次数-首页-视图", path = "/view/activityCumulateTimes")
	public String indexView() {
		return "/modular/business/activityCumulateTimes/activityCumulateTimes.html";
	}
	/**
	 * 首页-视图
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@GetResource(name = "活动累计次数-新增-视图", path = "/view/activityCumulateTimes/addView")
	public String addView() {
		return "/modular/business/activityCumulateTimes/activityCumulateTimes_add.html";
	}

	/**
	 * 首页-视图
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@GetResource(name = "活动累计次数-编辑-视图", path = "/view/activityCumulateTimes/editView")
	public String editView() {
		return "/modular/business/activityCumulateTimes/activityCumulateTimes_edit.html";
	}

	/**
	 * 查询管理员列表
	 *
	 * @author fengshuonan
	 * @Date 2018/12/24 22:43
	 */
	@RequestMapping("/activityCumulateTimes/page")
	@ResponseBody
	public Object list(ActivityCumulateTimesRequest activityRequest) {
		PageResult<ActivityCumulateTimes> result = this.activityService.findPage(activityRequest);
		return new SuccessResponseData(result);
	}

	/**
	 * 添加活动相关内容
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@PostResource(name = "活动累计次数-新增", path = "/activityCumulateTimes/add")
	@ResponseBody
	public ResponseData add(@RequestBody @Validated(ActivityCumulateTimesRequest.add.class) ActivityCumulateTimesRequest activityRequest) {
		activityService.add(activityRequest);
		return new SuccessResponseData();
	}

	/**
	 * 删除活动相关内容
	 * 
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@PostResource(name = "活动累计次数-删除", path = "/activityCumulateTimes/delete")
	@ResponseBody
	public ResponseData delete(
			@RequestBody @Validated(ActivityCumulateTimesRequest.delete.class) ActivityCumulateTimesRequest activityRequest) {
		activityService.del(activityRequest);
		return new SuccessResponseData();
	}

	/**
	 * 编辑活动相关内容
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	@PostResource(name = "活动累计次数-编辑", path = "/activityCumulateTimes/edit")
	@ResponseBody
	public ResponseData edit(
			@RequestBody @Validated(ActivityCumulateTimesRequest.edit.class) ActivityCumulateTimesRequest activityRequest) {
		activityService.edit(activityRequest);
		return new SuccessResponseData();
	}
	
	 /**
     * 查看详情
     *
     * @author chenjinlong
     * @date 2020/11/04 11:07
     */
    @GetResource(name = "活动累计次数-详情", path = "/activityCumulateTimes/detail")
    @ResponseBody
    public ResponseData detail(@Validated(ActivityCumulateTimesRequest.detail.class) ActivityCumulateTimesRequest activityRequest) {
    	ActivityCumulateTimes detail = activityService.detail(activityRequest);
        return new SuccessResponseData(JSON.toJSON(detail));
    }


}
