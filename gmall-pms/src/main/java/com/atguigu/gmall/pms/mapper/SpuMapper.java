package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.SpuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * spu信息
 * 
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
@Mapper
public interface SpuMapper extends BaseMapper<SpuEntity> {

    /**
     * @Author 于明岩
     * @Description 查询商品总条数
     * @Date 2022/8/4 11:18
     * @Param [pageNum, pageSize, categoryId, key]
     * @return java.lang.Long
     **/
    Long queryProductCountBycCategoryId(Long pageNum, Long pageSize, Long categoryId);

    /**
     * @Author 于明岩
     * @Description 查询商品列表
     * @Date 2022/8/4 11:21
     * @Param [pageNum, pageSize, categoryId, key]
     * @return java.util.ArrayList<com.atguigu.gmall.pms.entity.SpuEntity>
     **/
    ArrayList<SpuEntity> queryProductListBycCategoryId(Long pageNum, Long pageSize, Long categoryId);

    /**
     * @Author 于明岩
     * @Description 根据key查询商品总条数
     * @Date 2022/8/4 14:15
     * @Param [pageNum, pageSize, key]
     * @return java.lang.Long
     **/
    Long queryProductCountByKey(Long pageNum, Long pageSize, String key);

    /**
     * @Author 于明岩
     * @Description 根据key查询商品列表
     * @Date 2022/8/4 14:16
     * @Param [pageNum, pageSize, key]
     * @return java.util.ArrayList<com.atguigu.gmall.pms.entity.SpuEntity>
     **/
    ArrayList<SpuEntity> queryProductListByKey(Long pageNum, Long pageSize, String key);
}
