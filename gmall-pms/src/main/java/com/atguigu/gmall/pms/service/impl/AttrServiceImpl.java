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

import com.atguigu.gmall.pms.mapper.AttrMapper;
import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.service.AttrService;

import javax.annotation.Resource;

@Slf4j
@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrMapper, AttrEntity> implements AttrService {

    @Resource
    private AttrMapper attrMapper;

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<AttrEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<AttrEntity>()
        );

        return new PageResultVo(page);
    }

    @Override
    public List<AttrEntity> querySpecifications(Long groupId) {
        log.info("================== 查询分组下的规格参数接口start =====================");
        ArrayList<AttrEntity> attrEntities = new ArrayList<>();
        try {
            if(groupId != null){
               attrEntities = attrMapper.querySpecifications(groupId);
            }
        } catch (Exception e) {
            log.error("查询分组下的规格参数接口报错：",e);
        }
        log.info("================== 查询分组下的规格参数接口end =====================");
        return attrEntities;
    }

}