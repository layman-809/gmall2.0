package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * 属性分组
 * 
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
@Mapper
public interface AttrGroupMapper extends BaseMapper<AttrGroupEntity> {

    /**
     * @Author 于明岩
     * @Description 查询规格分组
     * @Date 2022/8/3 16:49
     * @Param []
     * @return java.util.ArrayList<com.atguigu.gmall.pms.entity.AttrGroupEntity>
     *
     * @param parentId*/
    ArrayList<AttrGroupEntity> queryAttrGroup(Long parentId);
	
}
