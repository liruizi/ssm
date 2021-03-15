package cn.stylefeng.guns.modular.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.stylefeng.guns.modular.business.entity.Activity;
import cn.stylefeng.guns.modular.business.pojo.ActivityRequest;
import cn.stylefeng.guns.modular.business.service.ActivityService;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.resource.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.resource.api.annotation.GetResource;
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
	public Object list(ActivityRequest activityRequest) {
		PageResult<Activity> result = this.activityService.findPage(activityRequest);
		return new SuccessResponseData(result);
	}
	


    /**
     * 示例方法
     *
     * @author fengshuonan
     * @date 2021/1/24 10:5
     */
//    @GetResource(name = "示例方法", path = "/activity/test")
//    @ResponseBody
//    public String renderSuccess() {
//        String str="?number=1&total=1&type=123&area=SSSS";
////        String str="{'number':1,'total':1,'type':123,'area':'SSSS'}";
//        System.out.println(str);
//        return str;
//    }
    
    @GetResource(name = "示例方法", path = "/activity/test")
    @ResponseBody
    public ResponseData renderSuccess(String area,String type) {
    	System.out.println(area);
    	System.out.println(type);
    	String str="{'number':1,'total':1,'type':123,'area':'SSSS'}";
        return new SuccessResponseData(str);
    }
}
