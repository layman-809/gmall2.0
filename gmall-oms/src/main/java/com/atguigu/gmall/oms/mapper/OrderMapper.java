package com.atguigu.gmall.oms.mapper;

import com.atguigu.gmall.oms.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:09:05
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {
	
}
