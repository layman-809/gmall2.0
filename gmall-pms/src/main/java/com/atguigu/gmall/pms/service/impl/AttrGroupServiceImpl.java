package com.atguigu.gmall.pms.service.impl;

import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.mapper.AttrMapper;
import com.atguigu.gmall.pms.vo.GroupVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @Resource
    private AttrMapper attrMapper;
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

    @Override
    public List<GroupVo> queryAttributeInfo(Long catId) {
        log.info("==================== 查询分类下的分组及其规格参数接口start ======================");
        // 查询所有的分组
        List<AttrGroupEntity> attrGroupEntities = this.list(new QueryWrapper<AttrGroupEntity>().eq("category_id", catId));
        // 查询出每组下的规格参数
        return attrGroupEntities.stream().map(attrGroupEntity -> {
            GroupVo groupVo = new GroupVo();
            BeanUtils.copyProperties(attrGroupEntity, groupVo);
            // 查询规格参数，只需查询出每个分组下的通用属性就可以了（不需要销售属性）
            List<AttrEntity> attrEntities = this.attrMapper.selectList(new QueryWrapper<AttrEntity>().eq("group_id", attrGroupEntity.getId()).eq("type", 1));
            groupVo.setAttrEntities(attrEntities);
            return groupVo;
        }).collect(Collectors.toList());
    }

}