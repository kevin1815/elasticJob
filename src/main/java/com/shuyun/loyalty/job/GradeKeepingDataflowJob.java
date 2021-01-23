package com.shuyun.loyalty.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.google.common.collect.Lists;
import com.shuyun.loyalty.entity.MemberGrade;

import java.util.List;

public class GradeKeepingDataflowJob implements DataflowJob<MemberGrade> {

    public List<MemberGrade> fetchData(ShardingContext shardingContext) {
        int item = shardingContext.getShardingItem();
        System.out.println("================" + shardingContext.getShardingParameter());
        // String[] cards = StringUtils.split(shardingContext.getShardingParameter(), ",");
        // for (int i = 0; i < cards.length; i++) {
        // System.out.println("========= " + i);
        // if (item == i) {
        // return Lists.newArrayList(new MemberGrade(Long.valueOf(cards[i]), 9000L + i));
        // }
        // }
        return Lists.newArrayList(new MemberGrade(1001L, 9001L));
    }

    public void processData(ShardingContext shardingContext, List<MemberGrade> list) {
        System.out.println("ShardingParameters = " + shardingContext.getShardingParameter());
        System.out.println("JobParameter = " + shardingContext.getJobParameter());
        System.out.println(list);
    }

}
