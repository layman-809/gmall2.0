package com.atguigu.gmall.pms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gmall.pms.entity.SpuEntity;
import com.atguigu.gmall.pms.service.SpuService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.common.bean.PageParamVo;

/**
 * spu信息
 *
 * @author layman
 * @email layman@atguigu.com
 * @date 2022-07-28 09:00:02
 */
@Api(tags = "spu信息 管理")
@RestController
@RequestMapping("pms/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public ResponseVo<PageResultVo> querySpuByPage(PageParamVo paramVo){
        PageResultVo pageResultVo = spuService.queryPage(paramVo);

        return ResponseVo.ok(pageResultVo);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseVo<SpuEntity> querySpuById(@PathVariable("id") Long id){
		SpuEntity spu = spuService.getById(id);

        return ResponseVo.ok(spu);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseVo<Object> save(@RequestBody SpuEntity spu){
		spuService.save(spu);

        return ResponseVo.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseVo update(@RequestBody SpuEntity spu){
		spuService.updateById(spu);

        return ResponseVo.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseVo delete(@RequestBody List<Long> ids){
		spuService.removeByIds(ids);

        return ResponseVo.ok();
    }

    /**
     * @Author 于明岩
     * @Description 查询商品列表
     * @Date 2022/8/4 10:37
     * @Param [categoryId]
     * @return com.atguigu.gmall.common.bean.ResponseVo<java.util.List<com.atguigu.gmall.pms.entity.SpuEntity>>
     **/
    @RequestMapping(value = "/category/{categoryId}",method = RequestMethod.GET)
    @ApiOperation("查询商品列表")
    public ResponseVo<PageResultVo> queryProductList(PageParamVo pageParamVo , @PathVariable("categoryId") Long categoryId){
        PageResultVo pageResultVo = spuService.queryProductList(pageParamVo,categoryId);
        return ResponseVo.ok(pageResultVo);
    }

    @ApiOperation("spu商品信息查询")
//    @GetMapping("category/{categoryId}")
    public ResponseVo<PageResultVo> querySpuInfo(PageParamVo pageParamVo, @PathVariable("categoryId")Long categoryId){

        PageResultVo pageResultVo = this.spuService.querySpuInfo(pageParamVo, categoryId);
        return ResponseVo.ok(pageResultVo);
    }

}
