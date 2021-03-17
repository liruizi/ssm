package cn.stylefeng.guns.modular.business.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.guns.modular.business.Enum.ActivityNumEnum;
import cn.stylefeng.guns.modular.business.entity.ActivityTotal;
import cn.stylefeng.guns.modular.business.mapper.ActivitTotalMapper;
import cn.stylefeng.guns.modular.business.pojo.ActivityTotalRequest;
import cn.stylefeng.guns.modular.business.service.ActivityTotalService;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.system.exception.SystemModularException;


@Service
public class ActivityTotalServiceImpl extends ServiceImpl<ActivitTotalMapper, ActivityTotal> implements ActivityTotalService {

	@Override
	public void add(ActivityTotalRequest activityRequest) {
		ActivityTotal activity = new ActivityTotal();
		BeanUtil.copyProperties(activityRequest, activity);
		this.save(activity);
	}

	@Override
	public void del(ActivityTotalRequest activityRequest) {
		ActivityTotal activity = this.querySysActivityNumById(activityRequest);
		this.removeById(activity.getId());
	}

	@Override
	public void edit(ActivityTotalRequest activityRequest) {
		ActivityTotal activity = this.querySysActivityNumById(activityRequest);
		BeanUtil.copyProperties(activityRequest, activity);
		this.updateById(activity);

	}

	@Override
	public ActivityTotal detail(ActivityTotalRequest activityRequest) {
		return this.querySysActivityNumById(activityRequest);

	}

	/**
	 * 根据主键id获取对象信息
	 *
	 * @return 实体对象
	 * @author chenjinlong
	 * @date 2021/2/2 10:16
	 */
	private ActivityTotal querySysActivityNumById(ActivityTotalRequest activityRequest) {
		ActivityTotal activity = this.getById(activityRequest.getId());
		if (ObjectUtil.isEmpty(activity)) {
			throw new SystemModularException(ActivityNumEnum.ACTIVITY_ORG_NOT_EXIST, activityRequest.getId());
		}
		return activity;
	}

	@Override
	public PageResult<ActivityTotal> findPage(ActivityTotalRequest activityRequest) {
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
	private LambdaQueryWrapper<ActivityTotal> createWrapper(ActivityTotalRequest activityRequest) {
		LambdaQueryWrapper<ActivityTotal> queryWrapper = new LambdaQueryWrapper<>();

		if (ObjectUtil.isEmpty(activityRequest)) {
			return queryWrapper;
		}

		//年限
		queryWrapper.eq(ObjectUtil.isNotEmpty(activityRequest.getYear()), ActivityTotal::getYear,activityRequest.getYear());
		return queryWrapper;
	}

}
