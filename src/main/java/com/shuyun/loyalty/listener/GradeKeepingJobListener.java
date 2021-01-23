package com.shuyun.loyalty.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GradeKeepingJobListener extends AbstractDistributeOnceElasticJobListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(GradeKeepingJobListener.class);

    public GradeKeepingJobListener() {
        super(100, 100);
    }

    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
        LOGGER.info("doBeforeJobExecutedAtLastStarted");
    }

    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
        LOGGER.info("doAfterJobExecutedAtLastCompleted");
    }

}
