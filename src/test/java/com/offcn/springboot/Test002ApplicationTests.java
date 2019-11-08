package com.offcn.springboot;



import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
class Test002ApplicationTests {

    @Resource
    private DataSource dataSource;


    void contextLoads() {
        System.out.println(dataSource+"========");
    }

}
