package com.gyl.collect.collect.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.gyl")
@MapperScan("com.gyl.collect.collect.biz.mapper")
@EnableTransactionManagement
public class WorkcollectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkcollectApplication.class, args);
    }

}
