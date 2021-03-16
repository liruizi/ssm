package cn.stylefeng.guns.modular.business.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.stylefeng.guns.modular.business.entity.ActivityTotal;
import cn.stylefeng.guns.modular.business.pojo.ActivityRequest;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;

/**
 * 
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2021-03-08 16:17:44
 */
public interface ActivityService extends IService<ActivityTotal> {

	// 通过城区查询
	ActivityTotal findActivtyInfo(String area,String type);
	
	  /**
     * 获取资源分页列表
     *
     * @param resourceRequest 请求参数
     * @return 返回结果
     * @author fengshuonan
     * @date 2020/11/24 20:45
     */
    PageResult<ActivityTotal> findPage(ActivityRequest activityRequest);

}
