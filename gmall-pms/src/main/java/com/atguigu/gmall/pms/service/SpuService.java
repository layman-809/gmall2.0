package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.pms.entity.SpuEntity;

/**
 * spu信息
 *
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
public interface SpuService extends IService<SpuEntity> {

    PageResultVo queryPage(PageParamVo paramVo);

    /**
     * @Author 于明岩
     * @Description 查询商品列表
     * @Date 2022/8/4 10:38
     * @Param [categoryId]
     * @return java.util.List<com.atguigu.gmall.pms.entity.SpuEntity>
     **/
    PageResultVo queryProductList(PageParamVo pageParamVo, Long categoryId);

}

