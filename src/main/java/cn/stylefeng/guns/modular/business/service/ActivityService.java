package cn.stylefeng.guns.modular.business.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.stylefeng.guns.modular.business.entity.Activity;
import cn.stylefeng.guns.modular.business.pojo.ActivityRequest;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;

/**
 * 
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2021-03-08 16:17:44
 */
public interface ActivityService extends IService<Activity> {

	// 通过城区查询
	Activity findActivtyInfo(Activity activity);
	
	  /**
     * 获取资源分页列表
     *
     * @param resourceRequest 请求参数
     * @return 返回结果
     * @author fengshuonan
     * @date 2020/11/24 20:45
     */
    PageResult<Activity> findPage(ActivityRequest activityRequest);

}