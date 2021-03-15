package cn.stylefeng.guns.modular.business.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.stylefeng.guns.modular.business.entity.Activity;


public interface ActivitMapper extends BaseMapper<Activity>  {
	
	Activity findActivtyInfo(Map<String, Object> map);
}
