package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.SkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * sku信息
 * 
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
@Mapper
public interface SkuMapper extends BaseMapper<SkuEntity> {

    /**
     * @Author 于明岩
     * @Description 根据spuId查询sku列表
     * @Date 2022/8/8 10:13
     * @Param [spuId]
     * @return java.util.ArrayList<com.atguigu.gmall.pms.entity.SkuEntity>
     **/
    ArrayList<SkuEntity> querySkuBySpuId(Long spuId);
}
