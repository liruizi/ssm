package cn.stylefeng.guns.modular.business.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.guns.modular.business.Enum.ActivityNumEnum;
import cn.stylefeng.guns.modular.business.entity.ActivityCumulateTimes;
import cn.stylefeng.guns.modular.business.mapper.ActivitCumulateTimesMapper;
import cn.stylefeng.guns.modular.business.pojo.ActivityCumulateTimesRequest;
import cn.stylefeng.guns.modular.business.service.ActivityCumulateTimesService;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.system.exception.SystemModularException;


@Service
public class ActivityCumulateTimesServiceImpl extends ServiceImpl<ActivitCumulateTimesMapper, ActivityCumulateTimes>
		implements ActivityCumulateTimesService {

	@Override
	public void add(ActivityCumulateTimesRequest activityRequest) {
		ActivityCumulateTimes activityCumulate = new ActivityCumulateTimes();
		BeanUtil.copyProperties(activityRequest, activityCumulate);
		this.save(activityCumulate);
	}

	@Override
	public void del(ActivityCumulateTimesRequest activityRequest) {
		ActivityCumulateTimes activityCumulate = this.querySysActivityNumById(activityRequest);
		this.removeById(activityCumulate.getId());
	}

	@Override
	public void edit(ActivityCumulateTimesRequest activityRequest) {
		ActivityCumulateTimes activityCumulate = this.querySysActivityNumById(activityRequest);
		BeanUtil.copyProperties(activityRequest, activityCumulate);
		this.updateById(activityCumulate);

	}

	@Override
	public ActivityCumulateTimes detail(ActivityCumulateTimesRequest activityRequest) {
		return this.querySysActivityNumById(activityRequest);

	}

	/**
	 * 根据主键id获取对象信息
	 *
	 * @return 实体对象
	 * @author chenjinlong
	 * @date 2021/2/2 10:16
	 */
	private ActivityCumulateTimes querySysActivityNumById(ActivityCumulateTimesRequest activityRequest) {
		ActivityCumulateTimes activity = this.getById(activityRequest.getId());
		if (ObjectUtil.isEmpty(activity)) {
			throw new SystemModularException(ActivityNumEnum.ACTIVITY_ORG_NOT_EXIST, activityRequest.getId());
		}
		return activity;
	}

	@Override
	public PageResult<ActivityCumulateTimes> findPage(ActivityCumulateTimesRequest activityRequest) {
		LambdaQueryWrapper<ActivityCumulateTimes> wrapper = createWrapper(activityRequest);
		Page<ActivityCumulateTimes> page = this.page(PageFactory.defaultPage(), wrapper);
		return PageResultFactory.createPageResult(page);
	}

	/**
	 * 创建wrapper
	 *
	 * @author fengshuonan
	 * @date 2020/11/6 10:16
	 */
	private LambdaQueryWrapper<ActivityCumulateTimes> createWrapper(ActivityCumulateTimesRequest activityRequest) {
		LambdaQueryWrapper<ActivityCumulateTimes> queryWrapper = new LambdaQueryWrapper<>();

		if (ObjectUtil.isEmpty(activityRequest)) {
			return queryWrapper;
		}

		//年限
		queryWrapper.eq(ObjectUtil.isNotEmpty(activityRequest.getYear()), ActivityCumulateTimes::getYear,activityRequest.getYear());
		return queryWrapper;
	}

}
