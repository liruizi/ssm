package cn.stylefeng.guns.modular.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.stylefeng.guns.modular.business.Enum.ActivityUitl;
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
		if (type.equals("undefined") || area==null) {
			return new ErrorResponseData("400", "请选择合适的行政单位！");
		}
		if (area.equals("undefined") || type==null) {
			return new ErrorResponseData("400", "请选择合适的活动方式！");
		}
		ActivityVo vo = activityService.getActivityInfo(ActivityUitl.getName(area), ActivityUitl.getName(type));
		
		if(vo.getCode().equals("1004")) {
			return new ErrorResponseData("1004", "请选择合适的活动方式！");
		}else if(vo.getCode().equals("1003")) {
			return new ErrorResponseData("1003", "请选择合适的活动方式！");
		}else if(vo.getCode().equals("1002")) {
			return new ErrorResponseData("1002", "请选择合适的活动方式！");
		}
		return new SuccessResponseData(vo);
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

	/**
	 * 业务日志详情-视图
	 *
	 * @author chenjinlong
	 * @date 2021/1/13 19:45
	 */
	@GetResource(name = "我的活动详情-视图", path = "/view/activity/detailView")
	public String detailView() {
		return "/modular/business/activity/activity_detail.html";
	}

	@GetResource(name = "我的活动详情-视图", path = "/activityManager/detail")
	@ResponseBody
	public ResponseData detail(@Validated(ActivityParam.detail.class) ActivityParam activityParam) {
		return new SuccessResponseData(activityService.detail(activityParam));
	}

	/**
	 * 添加区域
	 *
	 * @author chenjinlong
	 * @date 2021/1/13 19:45
	 */
	@GetResource(name = "我的活动新增-视图", path = "/view/activity/addView")
	public String addArea() {
		return "/modular/business/activity/activity_edit.html";
	}

	/**
	 * 删除tb_activity
	 *
	 * @author fengshuonan
	 * @date 2021/03/22 14:07
	 */
	@PostResource(name = "我的活动删除-视图", path ="/activity/delete")
	@ResponseBody
	public ResponseData delete(@RequestBody @Validated(ActivityParam.delete.class) ActivityParam activityParam) {
		activityService.delete(activityParam);
		return new SuccessResponseData();
	}

}
