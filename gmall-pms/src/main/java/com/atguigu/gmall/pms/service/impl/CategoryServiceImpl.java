package com.atguigu.gmall.pms.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;

import com.atguigu.gmall.pms.mapper.CategoryMapper;
import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.atguigu.gmall.pms.service.CategoryService;


@Service("categoryService")
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<CategoryEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageResultVo(page);
    }

    @Override
    public List<CategoryEntity> querySortByParentId(Long parentId) {
        log.info("入参："+parentId);
        log.info("===================== 查询分类接口start =====================");
        List<CategoryEntity> categoryEntitys = new ArrayList<CategoryEntity>();
        try {
            // 如果parentId为-1，说明用户没有传该字段，分页查询所有
            if (parentId == -1) {
                categoryEntitys = categoryMapper.querySort();
            } else {
                categoryEntitys = categoryMapper.querySortByParentId(parentId);
            }
        } catch (Exception e) {
            log.error("查询分类接口报错：",e);
        }
        log.info("===================== 查询分类接口end =====================");
        return categoryEntitys;
    }

}