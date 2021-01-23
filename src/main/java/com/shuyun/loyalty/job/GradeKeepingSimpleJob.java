package com.shuyun.loyalty.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GradeKeepingSimpleJob implements SimpleJob {

    static final Logger LOGGER = LoggerFactory.getLogger(GradeKeepingSimpleJob.class);

    public void execute(ShardingContext shardingContext) {
        int item = shardingContext.getShardingItem();
        String card = shardingContext.getShardingParameter();
        LOGGER.info("fetch data by card {}, item {}", card, item);
    }

}
