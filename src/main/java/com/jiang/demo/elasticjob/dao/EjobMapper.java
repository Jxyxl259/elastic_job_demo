package com.jiang.demo.elasticjob.dao;

import com.jiang.demo.elasticjob.entity.JobEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface EjobMapper {

    Long insertJob(JobEntity jobEntity);

}
