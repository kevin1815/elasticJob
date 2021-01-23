package com.shuyun.loyalty.factory;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.strategy.impl.AverageAllocationJobShardingStrategy;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.shuyun.loyalty.job.GradeKeepingDataflowJob;
import com.shuyun.loyalty.job.GradeKeepingSimpleJob;

import java.util.ArrayList;
import java.util.List;

public class JobConfigurationFactory {

    public static LiteJobConfiguration create() {
        // List<Long> cards = new ArrayList<>(3);
        // cards.add(1001L);
        // cards.add(1002L);
        // cards.add(1003L);
        // StringBuilder shardingItemParameters = new StringBuilder();
        // for (int i = 0; i < cards.size(); i++) {
        // if (i != 0) {
        // shardingItemParameters.append(",");
        // }
        // shardingItemParameters.append(i).append("=").append(cards.get(i));
        // }
        // System.out.println("shardingItemParameters [" + shardingItemParameters + "]");
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(
                JobCoreConfiguration.newBuilder("simpleGradeKeeping", "0/10 * * * * ?", 3)
                        .shardingItemParameters("0=1001,1=1002,2=1003").jobParameter("1").build(),
                GradeKeepingSimpleJob.class.getCanonicalName()))
                .jobShardingStrategyClass(
                        AverageAllocationJobShardingStrategy.class.getCanonicalName())
                .overwrite(true).build();
    }

    public static LiteJobConfiguration createDataFlowConfig() {
        List<Long> cards = new ArrayList<>(3);
        cards.add(1001L);
        cards.add(1002L);
        cards.add(1003L);
        StringBuilder shardingItemParameters = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            if (i != 0) {
                shardingItemParameters.append(",");
            }
            shardingItemParameters.append(i).append("=").append(cards.get(i));
        }
        System.out.println("shardingItemParameters [" + shardingItemParameters + "]");
        return LiteJobConfiguration.newBuilder(new DataflowJobConfiguration(
                JobCoreConfiguration.newBuilder("gradeKeeping", "0/5 * * * * ?", cards.size())
                        .shardingItemParameters(shardingItemParameters.toString()).build(),
                GradeKeepingDataflowJob.class.getCanonicalName(), false))
                .jobShardingStrategyClass(
                        AverageAllocationJobShardingStrategy.class.getCanonicalName())
                .build();
    }

}
