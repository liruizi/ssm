package cn.stylefeng.guns.modular.business.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.stylefeng.guns.modular.business.entity.ActivityNum;
import cn.stylefeng.guns.modular.business.pojo.ActivityNumRequest;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;

/**
 * 
 * 
 * @author zhiqiu
 * @email fei6751803@163.com
 * @date 2021-03-08 16:17:44
 */
public interface ActivityNumService extends IService<ActivityNum> {

	/**
	 * 添加
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	void add(ActivityNumRequest activityNumRequest);

	/**
	 * 删除
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	void del(ActivityNumRequest activityNumRequest);

	/**
	 * 编辑
	 *
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	void edit(ActivityNumRequest activityNumRequest);

	/**
	 * 查看详情
	 *
	 * @param activityNumRequest 请求参数
	 * @return 职位详情
	 * @author chenjinlong
	 * @date 2020/11/04 11:07
	 */
	ActivityNum detail(ActivityNumRequest activityNumRequest);

	/**
	 * 获取资源分页列表
	 *
	 * @param resourceRequest 请求参数
	 * @return 返回结果
	 * @author fengshuonan
	 * @date 2020/11/24 20:45
	 */
	PageResult<ActivityNum> findPage(ActivityNumRequest activityRequest);

	/***
	 * 通过年限\城区\类型 获得当前类型最新编号
	 * 
	 * @param year
	 * @param area
	 * @return
	 */
	ActivityNum findActivity(String year, String area, String type);

}
