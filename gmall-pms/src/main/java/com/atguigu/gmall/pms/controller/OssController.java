package com.atguigu.gmall.pms.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.pms.entity.OssEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @Author 于明岩
 * @Description 华为云图片上传接口
 * @Date 2022/8/1 15:59
 **/
@Api(tags = "阿里云图片上传")
@RestController
@RequestMapping("pms/oss")
@Slf4j
public class OssController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
    String prefix = sdf.format(new Date());
    @Resource
    private OssEntity ossEntity;
    /**
     * @Author 于明岩
     * @Description 图片上传
     * @Date 2022/8/1 16:15
     * @Param [request, response]
     * @return com.atguigu.gmall.common.bean.ResponseVo
     **/
    @ApiOperation("图片上传")
    @RequestMapping(value = "policy",method = RequestMethod.GET)
    public ResponseVo policy(){
        log.info("===================== 图片上传接口start =====================");
        Map<String, String> respMap = new LinkedHashMap<String, String>();
        try {
            OSSClient ossClient = new OSSClient(ossEntity.getEndpoint(), ossEntity.getAccessId(), ossEntity.getAccessKey());
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, prefix);

            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);

            respMap.put("accessid", ossEntity.getAccessId());
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", prefix );
            respMap.put("host", ossEntity.getHost());
            respMap.put("expire", String.valueOf(expireEndTime / 3000));
        } catch (Exception e) {
            log.error("图片上传接口报错：",e);
        }
        log.info("===================== 图片上传接口end =====================");
        return ResponseVo.ok(respMap);
    }




}
