package com.jiang.demo.elasticjob.config;


import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.jiang.demo.elasticjob.job.SimpleJobDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * class_name: ElasticJobConfig
 * package:  com.yto.springbooteljob.config
 *
 * @param
 * @Description:
 * @author: Mr.Cui
 * @Date: 2018/12/05
 * @time: 15:14
 **/
@Configuration
@PropertySource("classpath:jobConfig/job.properties")
@ConfigurationProperties(prefix = "simple-job")
public class ElasticJobConfig {


    @Autowired
    private ZookeeperRegistryCenter regCenter;

    private String cron;

    private int shardingTotalCount;

    private String shardingItemParameters;

    /**
     * 配置任务监听器
     * @return
     */
    @Bean
    public ElasticJobListener elasticJobListener() {
        return new MyElasticJobListener();
    }

    /**
     * 配置任务详细信息
     * @param jobClass
     * @param cron
     * @param shardingTotalCount
     * @param shardingItemParameters
     * @return
     */
    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                         final String cron,
                                                         final int shardingTotalCount,
                                                         final String shardingItemParameters) {
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(
                JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount)
                        .shardingItemParameters(shardingItemParameters).build()
                , jobClass.getCanonicalName())
        ).overwrite(true).build();
    }


    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(@Autowired SimpleJobDemo simpleJob){
        MyElasticJobListener elasticJobListener = new MyElasticJobListener();
        return new SpringJobScheduler(simpleJob, regCenter,
                getLiteJobConfiguration(simpleJob.getClass(), cron, shardingTotalCount, shardingItemParameters),
                elasticJobListener);
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public void setShardingTotalCount(int shardingTotalCount) {
        this.shardingTotalCount = shardingTotalCount;
    }

    public void setShardingItemParameters(String shardingItemParameters) {
        this.shardingItemParameters = shardingItemParameters;
    }
}
