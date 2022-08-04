package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;

import java.util.List;

/**
 * 属性分组
 *
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageResultVo queryPage(PageParamVo paramVo);

    /**
     * @Author 于明岩
     * @Description 查询规格分组
     * @Date 2022/8/3 16:43
     * @Param []
     * @return java.util.List<com.atguigu.gmall.pms.entity.AttrGroupEntity>
     *
     * @param parentId*/
    List<AttrGroupEntity> queryAttrGroup(Long parentId);

}

