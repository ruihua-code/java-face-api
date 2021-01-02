package com.zrh.face;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.zrh.face.mapper"})
public class JavaFeceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaFeceApiApplication.class, args);
    }

}
