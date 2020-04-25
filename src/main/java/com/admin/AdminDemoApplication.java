package com.admin;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.tao.frameworks.admin.spring.ResponseHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.admin.dao")
public class AdminDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminDemoApplication.class, args);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        return page;
    }

    @Bean
    public ResponseHandler responseHandler(){
        return new ResponseHandler();
    }
}
