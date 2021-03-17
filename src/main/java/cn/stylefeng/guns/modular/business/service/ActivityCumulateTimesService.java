package cn.stylefeng.guns.modular.business.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.stylefeng.guns.modular.business.entity.ActivityCumulateTimes;
import cn.stylefeng.guns.modular.business.pojo.ActivityCumulateTimesRequest;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;

/**
 * 
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2021-03-08 16:17:44
 */
public interface ActivityCumulateTimesService extends IService<ActivityCumulateTimes> {

	
	/**
     * 添加
     *
     * @author chenjinlong
     * @date 2020/11/04 11:07
     */
    void add(ActivityCumulateTimesRequest activityRequest);

    /**
     * 删除
     *
     * @author chenjinlong
     * @date 2020/11/04 11:07
     */
    void del(ActivityCumulateTimesRequest activityRequest);

    /**
     * 编辑
     *
     * @author chenjinlong
     * @date 2020/11/04 11:07
     */
    void edit(ActivityCumulateTimesRequest activityRequest);


    /**
     * 查看详情
     *
     * @param activityRequest 请求参数
     * @author chenjinlong
     * @date 2020/11/04 11:07
     */
    ActivityCumulateTimes detail(ActivityCumulateTimesRequest activityRequest);
	
	  /**
     * 获取资源分页列表
     *
     * @param resourceRequest 请求参数
     * @return 返回结果
     * @author fengshuonan
     * @date 2020/11/24 20:45
     */
    PageResult<ActivityCumulateTimes> findPage(ActivityCumulateTimesRequest activityRequest);

}
