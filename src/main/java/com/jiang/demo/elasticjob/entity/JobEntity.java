package com.jiang.demo.elasticjob.entity;

import java.util.Date;

/**
 * @description:
 * @author:
 * @create: 2019-11-11 11:27
 */
public class JobEntity {

    private Long id;

    private String ip;

    private Date createTime;

    public JobEntity() {
    }

    public JobEntity(String ip, Date createTime) {
        this.ip = ip;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("JobEntity{");
        sb.append("id=").append(id);
        sb.append(", ip='").append(ip).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}
