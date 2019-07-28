package com.gyl.workcollect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gyl.workcollect.*")
@MapperScan("com.gyl.workcollect.biz.mapper")
public class WorkcollectApplication {

    public static void main(String[] args) {

        SpringApplication.run(WorkcollectApplication.class, args);
    }

}
