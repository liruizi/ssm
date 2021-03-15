package cn.stylefeng.guns.modular.business.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.guns.modular.business.entity.Activity;
import cn.stylefeng.guns.modular.business.mapper.ActivitMapper;
import cn.stylefeng.guns.modular.business.pojo.ActivityRequest;
import cn.stylefeng.guns.modular.business.service.ActivityService;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;

/**
 * <p>
 * 职位表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-27
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivitMapper, Activity> implements ActivityService {

	@Override
	public Activity findActivtyInfo(Activity activity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResult<Activity> findPage(ActivityRequest activityRequest) {
		LambdaQueryWrapper<Activity> wrapper = createWrapper(activityRequest);
		Page<Activity> page = this.page(PageFactory.defaultPage(), wrapper);
		return PageResultFactory.createPageResult(page);
	}

	/**
	 * 创建wrapper
	 *
	 * @author fengshuonan
	 * @date 2020/11/6 10:16
	 */
	private LambdaQueryWrapper<Activity> createWrapper(ActivityRequest activityRequest) {
		LambdaQueryWrapper<Activity> queryWrapper = new LambdaQueryWrapper<>();

		if (ObjectUtil.isEmpty(activityRequest)) {
			return queryWrapper;
		}

		// 城区
        queryWrapper.eq(ObjectUtil.isNotEmpty(activityRequest.getArea()), Activity::getArea, activityRequest.getArea());

		// 根据资源名称
//        queryWrapper.like(ObjectUtil.isNotEmpty(resourceRequest.getResourceName()), SysResource::getResourceName, resourceRequest.getResourceName());

		// 根据资源url
//        queryWrapper.like(ObjectUtil.isNotEmpty(resourceRequest.getUrl()), SysResource::getUrl, resourceRequest.getUrl());

		return queryWrapper;
	}
}
