package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.pms.entity.AttrEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
public interface AttrService extends IService<AttrEntity> {

    PageResultVo queryPage(PageParamVo paramVo);

    /**
     * @Author 于明岩
     * @Description 查询分组下的规格参数
     * @Date 2022/8/3 17:05
     * @Param [groupId]
     * @return java.util.List<com.atguigu.gmall.pms.entity.AttrEntity>
     **/
    List<AttrEntity> querySpecifications(Long groupId);
}

