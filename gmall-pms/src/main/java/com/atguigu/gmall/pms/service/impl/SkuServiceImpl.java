package com.atguigu.gmall.pms.service.impl;

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

import com.atguigu.gmall.pms.mapper.SkuMapper;
import com.atguigu.gmall.pms.entity.SkuEntity;
import com.atguigu.gmall.pms.service.SkuService;

import javax.annotation.Resource;

@Slf4j
@Service("skuService")
public class SkuServiceImpl extends ServiceImpl<SkuMapper, SkuEntity> implements SkuService {

    @Resource
    private SkuMapper skuMapper;

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<SkuEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<SkuEntity>()
        );

        return new PageResultVo(page);
    }

    @Override
    public List<SkuEntity> querySkuBySpuId(Long spuId) {
        log.info("==================== 查询库存列表接口start ====================");
        ArrayList<SkuEntity> skuEntities = new ArrayList<>();
        try {
            if(spuId != null){
                skuEntities = skuMapper.querySkuBySpuId(spuId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("==================== 查询库存列表接口end ====================");
        return skuEntities;
    }

}