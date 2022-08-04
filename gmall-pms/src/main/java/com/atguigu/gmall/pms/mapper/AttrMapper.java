package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * 商品属性
 * 
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
@Mapper
public interface AttrMapper extends BaseMapper<AttrEntity> {

    ArrayList<AttrEntity> querySpecifications(Long groupId);
}
