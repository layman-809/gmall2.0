package com.atguigu.gmall.ums.mapper;

import com.atguigu.gmall.ums.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:14:27
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
	
}
