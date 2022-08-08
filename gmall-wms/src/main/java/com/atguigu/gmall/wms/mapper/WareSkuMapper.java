package com.atguigu.gmall.wms.mapper;

import com.atguigu.gmall.wms.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

/**
 * 商品库存
 * 
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:16:19
 */
@Mapper
public interface WareSkuMapper extends BaseMapper<WareSkuEntity> {

    /**
     * @Author 于明岩
     * @Description 查询商品库存
     * @Date 2022/8/8 11:19
     * @Param [skuId]
     * @return java.util.ArrayList<com.atguigu.gmall.wms.entity.WareSkuEntity>
     **/
    ArrayList<WareSkuEntity> queryCommodityStocks(Long skuId);
}
