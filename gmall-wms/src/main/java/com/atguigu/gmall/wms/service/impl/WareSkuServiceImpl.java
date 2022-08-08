package com.atguigu.gmall.wms.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;

import com.atguigu.gmall.wms.mapper.WareSkuMapper;
import com.atguigu.gmall.wms.entity.WareSkuEntity;
import com.atguigu.gmall.wms.service.WareSkuService;

import javax.annotation.Resource;

@Slf4j
@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper, WareSkuEntity> implements WareSkuService {

    @Resource
    private WareSkuMapper wareSkuMapper;

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<WareSkuEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<WareSkuEntity>()
        );

        return new PageResultVo(page);
    }

    @Override
    public List<WareSkuEntity> queryCommodityStocks(Long skuId) {
        log.info("==================== 查询商品库存接口start ====================");
        ArrayList<WareSkuEntity> wareSkuEntities = new ArrayList<>();
        try {
            if(skuId != null){
                wareSkuEntities = wareSkuMapper.queryCommodityStocks(skuId);
            }
        } catch (Exception e) {
            log.error("查询商品库存接口报错：",e);
        }
        log.info("==================== 查询商品库存接口end ====================");
        return wareSkuEntities;
    }

}