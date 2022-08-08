package com.atguigu.gmall.pms.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;

import com.atguigu.gmall.pms.mapper.SpuMapper;
import com.atguigu.gmall.pms.entity.SpuEntity;
import com.atguigu.gmall.pms.service.SpuService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("spuService")
public class SpuServiceImpl extends ServiceImpl<SpuMapper, SpuEntity> implements SpuService {

    @Resource
    private SpuMapper spuMapper;

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<SpuEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<SpuEntity>()
        );

        return new PageResultVo(page);
    }

    @Override
    public PageResultVo queryProductList(PageParamVo pageParamVo, Long categoryId) {
        log.info("=================== 查询商品列表start ====================");
        ArrayList<SpuEntity> spuEntities = new ArrayList<>();
        PageResultVo pageResultVo = null;
        Long count = 0L;
        try {
            Long pageNum = Long.valueOf((pageParamVo.getPageNum() -1) * pageParamVo.getPageSize());
            Long pageSize = Long.valueOf(pageParamVo.getPageSize());
            // 如果key不为空，按照key进行查询，否则按照categoryId查询
            String key = pageParamVo.getKey();
            if(StringUtils.isNotBlank(key)){
                //查询总记录数
                count = spuMapper.queryProductCountByKey(pageNum,pageSize,key);
                spuEntities = spuMapper.queryProductListByKey(pageNum,pageSize,key);
            }
            // 如果分类id不为0，要根据分类id查，否则查全部
            else {
                //查询总记录数
                count = spuMapper.queryProductCountBycCategoryId(pageNum,pageSize,categoryId);
                spuEntities = spuMapper.queryProductListBycCategoryId(pageNum,pageSize,categoryId);
            }
            if(!spuEntities.isEmpty()){
                pageResultVo = new PageResultVo(spuEntities, count, pageNum, pageSize);
            }
        } catch (Exception e) {
            log.error("查询商品列表报错：",e);
        }
        log.info("=================== 查询商品列表end ====================");
        return pageResultVo;
    }


}