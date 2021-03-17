package cn.stylefeng.guns.modular.business.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.guns.modular.business.Enum.ActivityNumEnum;
import cn.stylefeng.guns.modular.business.entity.ActivityNum;
import cn.stylefeng.guns.modular.business.mapper.ActivitNumMapper;
import cn.stylefeng.guns.modular.business.pojo.ActivityNumRequest;
import cn.stylefeng.guns.modular.business.service.ActivityNumService;
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
public class ActivityNumServiceImpl extends ServiceImpl<ActivitNumMapper, ActivityNum> implements ActivityNumService {

	@Override
	public void add(ActivityNumRequest activityNumRequest) {
		ActivityNum activityNum = new ActivityNum();
		BeanUtil.copyProperties(activityNumRequest, activityNum);
		this.save(activityNum);
	}

	@Override
	public void del(ActivityNumRequest activityNumRequest) {
		ActivityNum activityNum = this.querySysActivityNumById(activityNumRequest);
		// 逻辑删除
//		activityNum.setDelFlag(YesOrNotEnum.Y.getCode());
		this.removeById(activityNum.getId());
	}

	@Override
	public void edit(ActivityNumRequest activityNumRequest) {
		ActivityNum activityNum = this.querySysActivityNumById(activityNumRequest);
		BeanUtil.copyProperties(activityNumRequest, activityNum);
		this.updateById(activityNum);
	}



	@Override
	public ActivityNum detail(ActivityNumRequest activityNumRequest) {
		return this.querySysActivityNumById(activityNumRequest);
	}

	/**
     * 根据主键id获取对象信息
     *
     * @return 实体对象
     * @author chenjinlong
     * @date 2021/2/2 10:16
     */
    private ActivityNum querySysActivityNumById(ActivityNumRequest activityNumRequest) {
    	ActivityNum activityNum = this.getById(activityNumRequest.getId());
        if (ObjectUtil.isEmpty(activityNum)) {
            throw new SystemModularException(ActivityNumEnum.ACTIVITY_ORG_NOT_EXIST, activityNumRequest.getId());
        }
        return activityNum;
    }
	
	
	@Override
	public PageResult<ActivityNum> findPage(ActivityNumRequest activityNumRequest) {
		LambdaQueryWrapper<ActivityNum> wrapper = createWrapper(activityNumRequest);
		Page<ActivityNum> page = this.page(PageFactory.defaultPage(), wrapper);
		return PageResultFactory.createPageResult(page);
	}

	/**
	 * 创建wrapper
	 *
	 * @author fengshuonan
	 * @date 2020/11/6 10:16
	 */
	private LambdaQueryWrapper<ActivityNum> createWrapper(ActivityNumRequest activityNumRequest) {
		LambdaQueryWrapper<ActivityNum> queryWrapper = new LambdaQueryWrapper<>();

		if (ObjectUtil.isEmpty(activityNumRequest)) {
			return queryWrapper;
		}

		// 城区
		queryWrapper.eq(ObjectUtil.isNotEmpty(activityNumRequest.getArea()), ActivityNum::getArea,activityNumRequest.getArea());
		queryWrapper.eq(ObjectUtil.isNotEmpty(activityNumRequest.getYear()), ActivityNum::getYear,activityNumRequest.getYear());
		queryWrapper.like(ObjectUtil.isNotEmpty(activityNumRequest.getType()), ActivityNum::getType,activityNumRequest.getType());

		// 根据资源名称
//        queryWrapper.like(ObjectUtil.isNotEmpty(resourceRequest.getResourceName()), SysResource::getResourceName, resourceRequest.getResourceName());

		// 根据资源url
//        queryWrapper.like(ObjectUtil.isNotEmpty(resourceRequest.getUrl()), SysResource::getUrl, resourceRequest.getUrl());

		return queryWrapper;
	}

	@Override
	public ActivityNum findActivity(String year, String area, String type) {
		// TODO Auto-generated method stub
		return null;
	}
}
