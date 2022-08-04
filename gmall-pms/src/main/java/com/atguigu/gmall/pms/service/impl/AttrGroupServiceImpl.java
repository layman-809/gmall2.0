package com.atguigu.gmall.pms.service.impl;

import com.atguigu.gmall.pms.mapper.AttrMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;

import com.atguigu.gmall.pms.mapper.AttrGroupMapper;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.atguigu.gmall.pms.service.AttrGroupService;

import javax.annotation.Resource;

@Slf4j
@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroupEntity> implements AttrGroupService {

    @Resource
    private AttrGroupMapper attrGroupMapper;

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<AttrGroupEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageResultVo(page);
    }

    @Override
    public List<AttrGroupEntity> queryAttrGroup(Long parentId) {
        log.info("=================== 查询规格分组接口start ===================");
        ArrayList<AttrGroupEntity> attrGroupEntities = new ArrayList<>();
        try {
            if(null != parentId){
               attrGroupEntities = attrGroupMapper.queryAttrGroup(parentId);
            }
        } catch (Exception e) {
           log.error("查询规格分组接口报错：",e);
        }
        log.info("=================== 查询规格分组接口end ===================");
        return attrGroupEntities;
    }

}