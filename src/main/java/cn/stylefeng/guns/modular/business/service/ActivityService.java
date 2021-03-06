package cn.stylefeng.guns.modular.business.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.stylefeng.guns.modular.business.entity.Activity;
import cn.stylefeng.guns.modular.business.entity.ActivityVo;
import cn.stylefeng.guns.modular.business.pojo.ActivityParam;
import cn.stylefeng.guns.modular.business.pojo.ActivityResult;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;

/**
 * 
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2021-03-08 16:17:44
 */
public interface ActivityService extends IService<Activity> {
	
	ActivityVo getActivityInfo(String area, String type);
	
	  /**
     * 获取资源分页列表
     *
     * @param resourceRequest 请求参数
     * @return 返回结果
     * @author fengshuonan
     * @date 2020/11/24 20:45
     */
    PageResult<Activity> findPage(ActivityResult activityResult);
    
    /**
     * 添加tb_activity
     *
     * @author fengshuonan
     * @date 2021/03/22 14:07
     */
    void add(ActivityParam activityParam);
    
    /**
     * 查看详情tb_activity
     *
     * @author fengshuonan
     * @date 2021/03/22 14:07
     */
    Activity detail(ActivityParam activityParam);
    

    /**
     * 删除tb_activity
     *
     * @author fengshuonan
     * @date 2021/03/22 14:07
     */
    void delete(ActivityParam activityParam);
    
    void edit(ActivityParam activityParam);
  
}
