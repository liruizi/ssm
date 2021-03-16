package cn.stylefeng.guns.modular.business.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.stylefeng.guns.modular.business.entity.ActivityTotal;


public interface ActivitMapper extends BaseMapper<ActivityTotal>  {
	
	ActivityTotal findActivtyInfo(Map<String, Object> map);
}
