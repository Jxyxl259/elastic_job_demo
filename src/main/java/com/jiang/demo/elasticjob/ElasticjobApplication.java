package com.jiang.demo.elasticjob;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan({
        "com.jiang.demo.elasticjob.dao"
})
@ComponentScan({
        "com.jiang.demo.elasticjob"
})
public class ElasticjobApplication {


    private static Logger log = LoggerFactory.getLogger(ElasticjobApplication.class);



    public static void main(String[] args) {
        SpringApplication.run(ElasticjobApplication.class, args);
        log.info("started ...");

    }


}
