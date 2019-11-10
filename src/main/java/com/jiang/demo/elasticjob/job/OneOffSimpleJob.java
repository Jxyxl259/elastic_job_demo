package com.jiang.demo.elasticjob.job;

import com.dangdang.ddframe.job.api.AbstractOneOffElasticJob;
import com.dangdang.ddframe.job.api.JobConfiguration;
import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.schedule.JobController;
import com.dangdang.ddframe.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description: 类似Quartz 的简单定时任务
 * @author:
 * @create: 2019-11-11 00:19
 */

@Component
@PropertySource("classpath:/jobConfig/job.properties")
@ConfigurationProperties(prefix="oneoffsimplejob")
public class OneOffSimpleJob extends AbstractOneOffElasticJob {

    // 注册中心 host&port  192.168.44.100:2181
    private String zkHostAndPort;

    // job 命名空间
    private String nameSpace;

    @Override
    protected void process(JobExecutionMultipleShardingContext jobExecutionMultipleShardingContext) {

    }


    // 定义Zookeeper注册中心配置对象
    private ZookeeperConfiguration zkConfig = new ZookeeperConfiguration("localhost:2181", "elastic-job-example", 1000, 3000, 3);

    // 定义Zookeeper注册中心
    private CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(zkConfig);

    // 定义作业1配置对象
    private JobConfiguration jobConfig1 = new JobConfiguration("oneOffElasticDemoJob", OneOffSimpleJob.class, 10, "0/5 * * * * ?");

    // 定义作业2配置对象
    // private JobConfiguration jobConfig2 = new JobConfiguration("perpetualElasticDemoJob", PerpetualElasticDemoJob.class, 10, "0/5 * * * * ?");

    // 定义作业3配置对象
    // private JobConfiguration jobConfig3 = new JobConfiguration("sequencePerpetualElasticDemoJob", SequencePerpetualElasticDemoJob.class, 10, "0/5 * * * * ?");





}
