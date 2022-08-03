package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.pms.entity.CategoryEntity;

import java.util.List;
/**
 * 商品三级分类
 *
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
    /**@Author 于明岩 @Description 根据父id查询分类 @Date 2022/8/3 10:17 @Param [parentId] @return com.atguigu.gmall.pms.entity.CategoryEntity*/
    List<CategoryEntity> querySortByParentId(Long parentId);

}

