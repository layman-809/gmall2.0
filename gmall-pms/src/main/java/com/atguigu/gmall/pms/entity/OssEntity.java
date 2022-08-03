package com.atguigu.gmall.pms.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author 于明岩
 * @Description 阿里云参数
 * @Date 2022/8/1 16:27
 * @Param
 * @return
 **/
@Component
@PropertySource(value = {"classpath:application.properties"})
public class OssEntity {
    /**访问Id*/
    @Value("${oss.accessId}")
    private String accessId;
    /**秘钥*/
    @Value("${oss.accessKey}")
    private String accessKey;
    /**oss服务器坐在区域*/
    @Value("${oss.endpoint}")
    private String endpoint;
    /**桶*/
    @Value("${oss.bucket}")
    private String bucket;
    /**地址*/
    @Value("${oss.host}")
    private String host;

    public String getAccessId() {
        return accessId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getBucket() {
        return bucket;
    }

    public String getHost() {
        return host;
    }
}
