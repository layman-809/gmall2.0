package com.atguigu.gmall.pms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.gmall.pms.mapper")
@EnableSwagger2
@RefreshScope
public class GmallPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallPmsApplication.class, args);
    }

   /* @Configuration
    public class MybatisPlusConfig {
        @Bean
        public PaginationInterceptor paginationInterceptor() {
            PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
            *//**
             * 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求 默认false
             * paginationInterceptor.setOverflow(false);
             * 设置最大单页限制数量，默认 500 条，-1 不受限制
             * paginationInterceptor.setLimit(500);
             * 开启 count 的 join 优化,只针对部分 left join
             *//*
            paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
            return paginationInterceptor;
        }
    }*/

}
