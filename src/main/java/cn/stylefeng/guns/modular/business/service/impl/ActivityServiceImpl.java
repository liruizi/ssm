package cn.stylefeng.guns.modular.business.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.guns.modular.business.entity.ActivityTotal;
import cn.stylefeng.guns.modular.business.mapper.ActivitMapper;
import cn.stylefeng.guns.modular.business.pojo.ActivityRequest;
import cn.stylefeng.guns.modular.business.service.ActivityNumService;
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
public class ActivityServiceImpl extends ServiceImpl<ActivitMapper, ActivityTotal> implements ActivityService {

	@Autowired
	ActivityNumService activityNumService;

	@Override
	public ActivityTotal findActivtyInfo(String area, String type) {
		Calendar cal = Calendar.getInstance();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("area", area);
		map.put("type", type);
		map.put("year", cal.get(Calendar.YEAR));
		List<ActivityTotal> activity = this.baseMapper.selectByMap(map);
		List<ActivityTotal> activity2 = activity;
		if (activity2.isEmpty()) {
			ActivityTotal activityInfo = new ActivityTotal();
			activityInfo.setArea(area);
			activityInfo.setNumber(1);
			activityInfo.setTotal(1);
			activityInfo.setCreateTime(new Date());
			activityInfo.setUpdateTime(new Date());
			activityInfo.setYear(cal.get(Calendar.YEAR) + "");
			this.save(activityInfo);
			return activityInfo;
		} else {
			ActivityTotal activityInfo = activity2.get(0);
			activityInfo.setNumber(activityInfo.getNumber() + 1);
			activityInfo.setTotal(activityInfo.getTotal() + 1);
			activityInfo.setUpdateTime(new Date());
			activityInfo.setId(activityInfo.getId());
			this.updateById(activityInfo);
			return activityInfo;
		}
	}

	@Override
	public PageResult<ActivityTotal> findPage(ActivityRequest activityRequest) {
		LambdaQueryWrapper<ActivityTotal> wrapper = createWrapper(activityRequest);
		Page<ActivityTotal> page = this.page(PageFactory.defaultPage(), wrapper);
		return PageResultFactory.createPageResult(page);
	}

	/**
	 * 创建wrapper
	 *
	 * @author fengshuonan
	 * @date 2020/11/6 10:16
	 */
	private LambdaQueryWrapper<ActivityTotal> createWrapper(ActivityRequest activityRequest) {
		LambdaQueryWrapper<ActivityTotal> queryWrapper = new LambdaQueryWrapper<>();

		if (ObjectUtil.isEmpty(activityRequest)) {
			return queryWrapper;
		}

		// 城区
		queryWrapper.eq(ObjectUtil.isNotEmpty(activityRequest.getArea()), ActivityTotal::getArea,
				activityRequest.getArea());

		// 根据资源名称
//        queryWrapper.like(ObjectUtil.isNotEmpty(resourceRequest.getResourceName()), SysResource::getResourceName, resourceRequest.getResourceName());

		// 根据资源url
//        queryWrapper.like(ObjectUtil.isNotEmpty(resourceRequest.getUrl()), SysResource::getUrl, resourceRequest.getUrl());

		return queryWrapper;
	}
}
