package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.CommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 * 
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
@Mapper
public interface CommentMapper extends BaseMapper<CommentEntity> {
	
}
