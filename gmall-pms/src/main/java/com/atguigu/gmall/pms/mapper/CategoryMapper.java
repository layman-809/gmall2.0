package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品三级分类
 * 
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryEntity> {

    /**
     * @Author 于明岩
     * @Description 根据父id查询分类
     * @Date 2022/8/3 10:23
     * @Param [parentId]
     * @return com.atguigu.gmall.pms.entity.CategoryEntity
     **/
    List<CategoryEntity> querySortByParentId(Long parentId);

    /**
     * @Author 于明岩
     * @Description 查询所有分类
     * @Date 2022/8/3 11:18
     * @Param [page, pageSize]
     * @return java.util.List<com.atguigu.gmall.pms.entity.CategoryEntity>
     **/
    List<CategoryEntity> querySort();
}
