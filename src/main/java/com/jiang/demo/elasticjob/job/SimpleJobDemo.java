package com.jiang.demo.elasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.jiang.demo.elasticjob.dao.EjobMapper;
import com.jiang.demo.elasticjob.entity.JobEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * @description: 类似Quartz 的简单定时任务
 * @author:
 * @create: 2019-11-11 00:19
 */

/**
 * class_name: SimpleJobDemo
 * package:  com.yto.springbooteljob.job
 *
 * @param
 * @Description:
 * @author: Mr.Cui
 * @Date: 2018/12/05
 * @time: 15:12
 **/
@Component("simpleJob")
public class SimpleJobDemo implements SimpleJob {

    @Autowired
    private EjobMapper ejobMaper;


    private static Logger log = LoggerFactory.getLogger(SimpleJobDemo.class);

    private static String ip;

    static {
        try {
            String address = InetAddress.getLocalHost().getHostAddress();
            log.info("get localhost address : {}", address);
            ip = address;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(String.format("------Thread ID: %s, 任务分片数: %s, " +
                        "当前分片项: %s.当前参数: %s," +
                        "当前任务名称: %s.当前任务参数: %s"
                ,
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()

        ));
        log.info("start job ...");
        JobEntity jobEntity = new JobEntity(ip, new Date());
        ejobMaper.insertJob(jobEntity);
        log.info("end job : {}", jobEntity.getId());
    }
}
