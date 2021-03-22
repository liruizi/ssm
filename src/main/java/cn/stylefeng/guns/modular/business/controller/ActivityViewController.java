package cn.stylefeng.guns.modular.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.stylefeng.guns.modular.business.entity.Activity;
import cn.stylefeng.guns.modular.business.entity.ActivityVo;
import cn.stylefeng.guns.modular.business.pojo.ActivityParam;
import cn.stylefeng.guns.modular.business.pojo.ActivityResult;
import cn.stylefeng.guns.modular.business.service.ActivityService;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.resource.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.resource.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.resource.api.annotation.PostResource;
import cn.stylefeng.roses.kernel.rule.pojo.response.ErrorResponseData;
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
public class ActivityViewController {

	@Autowired
	private ActivityService activityService;

	/**
	 * 详情
	 */
	@GetResource(name = "我的活动-首页-视图", path = "/view/activity")
	public String indexView() {
		return "/modular/business/activity/activity.html";
	}

	/**
	 * 查询管理员列表
	 *
	 * @author fengshuonan
	 * @Date 2018/12/24 22:43
	 */
	@RequestMapping("/activity/page")
	@ResponseBody
	public ResponseData list(ActivityResult activityResult) {
		PageResult<Activity> result = this.activityService.findPage(activityResult);
		return new SuccessResponseData(result);
	}

	/**
	 * 添加弹出层
	 * 
	 * @param area
	 * @param type
	 * @return
	 */
	@GetResource(name = "添加弹出层", path = "/activity/addType")
	@ResponseBody
	public ResponseData addType(String area, String type) {
		if (StringUtils.isEmpty(area)) {
			return new ErrorResponseData("400", "请选择合适的行政单位！");
		}
		if (StringUtils.isEmpty(type)) {
			return new ErrorResponseData("400", "请选择合适的活动方式！");
		}
		ActivityVo vo = activityService.getActivityInfo(area, type);
		return new SuccessResponseData(JSON.toJSON(vo));
	}

	/**
	 * 添加tb_activity
	 *
	 * @author fengshuonan
	 * @date 2021/03/22 14:07
	 */
	@PostResource(name = "我的活动新增", path = "/activity/add")
	@ResponseBody
	public ResponseData add(@RequestBody ActivityParam activityParam) {
		activityService.add(activityParam);
		return new SuccessResponseData();
	}

}
