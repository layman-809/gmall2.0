package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.pms.entity.SpuAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
public interface SpuAttrValueService extends IService<SpuAttrValueEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

