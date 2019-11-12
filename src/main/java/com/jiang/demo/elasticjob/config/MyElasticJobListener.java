package com.jiang.demo.elasticjob.config;


import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * class_name: MyElasticJobListener
 * package:  com.yto.springbooteljob.job
 *
 * @param
 * @Description:
 * @author: Mr.Cui
 * @Date: 2018/12/05
 * @time: 15:12
 **/
public class MyElasticJobListener implements ElasticJobListener {
    private static final Logger logger = LoggerFactory.getLogger(MyElasticJobListener.class);

    private long beginTime = 0;
    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        beginTime = System.currentTimeMillis();

        logger.info("===>{} 执行开始时间 {} <===",shardingContexts.getJobName(), new Date());
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        long endTime = System.currentTimeMillis();
        logger.info("===>{} 执行结束时间:{} <===",shardingContexts.getJobName(), new Date());
    }
}
