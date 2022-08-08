package com.atguigu.gmall.pms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gmall.pms.entity.SkuEntity;
import com.atguigu.gmall.pms.service.SkuService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.common.bean.PageParamVo;

/**
 * sku信息
 *
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
@Api(tags = "sku信息 管理")
@RestController
@RequestMapping("pms/sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public ResponseVo<PageResultVo> querySkuByPage(PageParamVo paramVo){
        PageResultVo pageResultVo = skuService.queryPage(paramVo);

        return ResponseVo.ok(pageResultVo);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseVo<SkuEntity> querySkuById(@PathVariable("id") Long id){
		SkuEntity sku = skuService.getById(id);

        return ResponseVo.ok(sku);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseVo<Object> save(@RequestBody SkuEntity sku){
		skuService.save(sku);

        return ResponseVo.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseVo update(@RequestBody SkuEntity sku){
		skuService.updateById(sku);

        return ResponseVo.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseVo delete(@RequestBody List<Long> ids){
		skuService.removeByIds(ids);

        return ResponseVo.ok();
    }

    /**
     * @Author 于明岩
     * @Description 根据spuId查询sku列表
     * @Date 2022/8/8 10:05
     * @Param [spuId]
     * @return com.atguigu.gmall.common.bean.ResponseVo<java.util.List<com.atguigu.gmall.pms.entity.SkuEntity>>
     **/
    @ApiOperation("根据spuId查询sku列表")
    @RequestMapping(value = "spu/{spuId}",method = RequestMethod.GET)
    public ResponseVo<List<SkuEntity>> querySku(@PathVariable("spuId") Long spuId){
        List<SkuEntity> skuEntityList = skuService.querySkuBySpuId(spuId);
        return ResponseVo.ok(skuEntityList);
    }

}
