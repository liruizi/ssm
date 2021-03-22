package cn.stylefeng.guns.modular.business.service.impl;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.stylefeng.guns.modular.business.Enum.ActivityNumEnum;
import cn.stylefeng.guns.modular.business.Util.SnUtils;
import cn.stylefeng.guns.modular.business.entity.Activity;
import cn.stylefeng.guns.modular.business.entity.ActivityCumulateTimes;
import cn.stylefeng.guns.modular.business.entity.ActivityNum;
import cn.stylefeng.guns.modular.business.entity.ActivityTotal;
import cn.stylefeng.guns.modular.business.entity.ActivityVo;
import cn.stylefeng.guns.modular.business.mapper.ActivitMapper;
import cn.stylefeng.guns.modular.business.pojo.ActivityParam;
import cn.stylefeng.guns.modular.business.pojo.ActivityResult;
import cn.stylefeng.guns.modular.business.service.ActivityCumulateTimesService;
import cn.stylefeng.guns.modular.business.service.ActivityNumService;
import cn.stylefeng.guns.modular.business.service.ActivityService;
import cn.stylefeng.guns.modular.business.service.ActivityTotalService;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.system.exception.SystemModularException;

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

	@Resource
	private ActivityCumulateTimesService activityCumulateTimesService;

	@Resource
	private ActivityTotalService activityTotalService;

	@Resource
	private ActivityNumService activityNumService;

	@Override
	public PageResult<Activity> findPage(ActivityResult activityResult) {
		LambdaQueryWrapper<Activity> wrapper = createWrapper(activityResult);
		Page<Activity> page = this.page(PageFactory.defaultPage(), wrapper);
		return PageResultFactory.createPageResult(page);
	}

	/**
	 * 创建wrapper
	 *
	 * @author fengshuonan
	 * @date 2020/11/6 10:16
	 */
	private LambdaQueryWrapper<Activity> createWrapper(ActivityResult activityResult) {
		LambdaQueryWrapper<Activity> queryWrapper = new LambdaQueryWrapper<>();

		if (ObjectUtil.isEmpty(activityResult)) {
			return queryWrapper;
		}
		// 行政单位
		queryWrapper.eq(ObjectUtil.isNotEmpty(activityResult.getArea()), Activity::getArea,activityResult.getArea());
		//活动方式
		queryWrapper.eq(ObjectUtil.isNotEmpty(activityResult.getType()), Activity::getType,activityResult.getType());
		//活动时长
		queryWrapper.eq(ObjectUtil.isNotEmpty(activityResult.getDuration()), Activity::getDuration,activityResult.getDuration());
		//活动负责人
		queryWrapper.eq(ObjectUtil.isNotEmpty(activityResult.getLeader()), Activity::getLeader,activityResult.getLeader());
		//活动司机
		queryWrapper.eq(ObjectUtil.isNotEmpty(activityResult.getDriver()), Activity::getDriver,activityResult.getDriver());
		//活动时间
		queryWrapper.ge(StrUtil.isNotBlank(activityResult.getBeginTime()), Activity::getTimes, activityResult.getBeginTime());
        queryWrapper.le(StrUtil.isNotBlank(activityResult.getEndTime()), Activity::getTimes, activityResult.getEndTime());

		return queryWrapper;
	}

	@Override
	public ActivityVo getActivityInfo(String area, String type) {

		ActivityVo vo = new ActivityVo();

		Calendar rightNow = Calendar.getInstance();
		Integer year = rightNow.get(Calendar.YEAR);
		vo.setActivityType(type);
		vo.setActivityName(area);

		// 活动累计次数
		ActivityCumulateTimes findTimes = activityCumulateTimesService.findTimes(year.toString());
		if (ObjectUtil.isEmpty(findTimes)) {
			throw new SystemModularException(ActivityNumEnum.TIMES_NOT_EXIST, area);
		}
		vo.setCumulateTimes(findTimes.getNumbers().toString());

		// 活动编号相关
		ActivityTotal findActivityTotal = activityTotalService.findActivityTotal(year.toString(), area);
		if (ObjectUtil.isEmpty(findActivityTotal)) {
			throw new SystemModularException(ActivityNumEnum.ACTIVITY_NOT_EXIST, area);
		}
		vo.setActivityNum(findActivityTotal.getPrefix() + SnUtils.getSn(findActivityTotal.getNumber(), 3));

		// 活动主题 主办 协办 等相关
		ActivityNum findActivity = activityNumService.findActivity(year.toString(), area, type);
		if (ObjectUtil.isEmpty(findActivity)) {
			throw new SystemModularException(ActivityNumEnum.TITLE_NOT_EXIST, area);
		}
		vo.setActivityTypeNum(findActivity.getTypeSerial() + SnUtils.getSn(findActivity.getSerial(), 3));
		vo.setActivityHost(findActivity.getHost());
		vo.setActivityGuide(findActivity.getGuide());
		vo.setActivityTitle(findActivity.getTitle());

		ActivityCumulateTimes activityCumulateTimes = new ActivityCumulateTimes();
		activityCumulateTimes.setId(findTimes.getId());
		activityCumulateTimes.setNumbers(findTimes.getNumbers() + 1);
		activityCumulateTimesService.updateById(activityCumulateTimes);

		ActivityNum activityNum = new ActivityNum();
		activityNum.setId(findActivity.getId());
		activityNum.setSerial(findActivity.getSerial() + 1);
		activityNumService.updateById(activityNum);

		ActivityTotal activityTotal = new ActivityTotal();
		activityTotal.setId(findActivityTotal.getId());
		activityTotal.setNumber(findActivityTotal.getNumber() + 1);
		activityTotalService.updateById(activityTotal);

		return vo;
	}

	@Override
	public void add(ActivityParam activityParam) {

		String centent = "";
		if (!StringUtils.isEmpty(activityParam.getContent_o())) {
			centent += activityParam.getContent_o() + ",";
		}
		if (!StringUtils.isEmpty(activityParam.getContent_t())) {
			centent += activityParam.getContent_t() + ",";
		}
		if (!StringUtils.isEmpty(activityParam.getContent_s())) {
			centent += activityParam.getContent_s() + ",";
		}
		if (!StringUtils.isEmpty(activityParam.getContent_f())) {
			centent += activityParam.getContent_f();
		}
		String object = "";
		if (!StringUtils.isEmpty(activityParam.getObject_o())) {
			object += activityParam.getObject_o() + ",";
		}
		if (!StringUtils.isEmpty(activityParam.getObject_t())) {
			object += activityParam.getObject_t() + ",";
		}
		if (!StringUtils.isEmpty(activityParam.getObject_s())) {
			object += activityParam.getObject_s() + ",";
		}
		if (!StringUtils.isEmpty(activityParam.getObject_f())) {
			object += activityParam.getObject_f();
		}

		
		
	    String str=activityParam.getTimes();
	    String[] arr=str.split("\\s+");
	    activityParam.setHour(arr[1]);
	    activityParam.setTimes(arr[0]);
		activityParam.setContent(centent);
		activityParam.setObject(object);
		// 将dto转为实体
		Activity activity = new Activity();
		BeanUtil.copyProperties(activityParam, activity);
		this.save(activity);
	}
	
	public static void main(String[] args) {
		String str="2021年03月22日 15:45";
		String[] arr=str.split("\\s+");
		System.err.println(arr[1]);
	}
	
}
