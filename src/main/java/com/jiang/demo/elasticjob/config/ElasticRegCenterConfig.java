package com.jiang.demo.elasticjob.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * class_name: ElasticRegCenterConfig
 * package:  com.yto.springbooteljob.config
 *
 * @param
 * @Description:
 * @author: Mr.Cui
 * @Date: 2018/12/05
 * @time: 15:11
 **/
@Configuration
@PropertySource("classpath:/jobConfig/job.properties")
@ConfigurationProperties(prefix = "reg-center")
public class ElasticRegCenterConfig {

    private static Logger log = LoggerFactory.getLogger(ElasticRegCenterConfig.class);

    private String serverList;

    private String namespace;

    /**
     * 配置zookeeper
     * @return
     */
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter() {
        log.info("init ZookeeperRegistryCenter start, serverList:{}, nameSpace:{}", serverList, namespace);
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList, namespace));
    }

    public void setServerList(String serverList) {
        this.serverList = serverList;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
