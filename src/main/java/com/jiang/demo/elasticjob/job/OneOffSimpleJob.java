//package com.jiang.demo.elasticjob.job;
//
//import com.dangdang.ddframe.job.api.AbstractOneOffElasticJob;
//import com.dangdang.ddframe.job.api.JobConfiguration;
//import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
//import com.dangdang.ddframe.job.schedule.JobController;
//import com.dangdang.ddframe.reg.base.CoordinatorRegistryCenter;
//import com.dangdang.ddframe.reg.zookeeper.ZookeeperConfiguration;
//import com.dangdang.ddframe.reg.zookeeper.ZookeeperRegistryCenter;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Component;
//
///**
// * @description: 类似Quartz 的简单定时任务
// * @author:
// * @create: 2019-11-11 00:19
// */
//
//@Component
//@PropertySource("classpath:/jobConfig/job.properties")
//@ConfigurationProperties(prefix="oneoffsimplejob")
//public class OneOffSimpleJob extends AbstractOneOffElasticJob implements InitializingBean {
//
//    // 注册中心 host&port  192.168.44.100:2181
//    private String zkHostAndPort;
//
//    // job 命名空间
//    private String nameSpace;
//
//    private int baseSleepTimeMilliseconds = 1000;
//
//    private int maxSleepTimeMilliseconds = 1000;
//
//    private int maxRetries = 3;
//
//    // 定义Zookeeper注册中心配置对象
//    private ZookeeperConfiguration zkConfig;
//
//    @Override
//    protected void process(JobExecutionMultipleShardingContext jobExecutionMultipleShardingContext) {
//
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        this.zkConfig = new ZookeeperConfiguration(zkHostAndPort, "elastic-job-example", baseSleepTimeMilliseconds, maxSleepTimeMilliseconds, maxRetries);
//    }
//
//
//
//
//    // 定义Zookeeper注册中心
//    private CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(zkConfig);
//
//    // 定义作业1配置对象
//    private JobConfiguration jobConfig1 = new JobConfiguration("oneOffElasticDemoJob", OneOffSimpleJob.class, 10, "0/5 * * * * ?");
//
//    // 定义作业2配置对象
//    // private JobConfiguration jobConfig2 = new JobConfiguration("perpetualElasticDemoJob", PerpetualElasticDemoJob.class, 10, "0/5 * * * * ?");
//
//    // 定义作业3配置对象
//    // private JobConfiguration jobConfig3 = new JobConfiguration("sequencePerpetualElasticDemoJob", SequencePerpetualElasticDemoJob.class, 10, "0/5 * * * * ?");
//
//
//
//    public void setZkHostAndPort(String zkHostAndPort) {
//        this.zkHostAndPort = zkHostAndPort;
//    }
//
//    public void setNameSpace(String nameSpace) {
//        this.nameSpace = nameSpace;
//    }
//
//
//}
