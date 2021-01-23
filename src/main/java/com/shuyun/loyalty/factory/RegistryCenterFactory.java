package com.shuyun.loyalty.factory;

import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

public class RegistryCenterFactory {

    public static CoordinatorRegistryCenter create() {
        ZookeeperConfiguration configuration = new ZookeeperConfiguration("127.0.0.1:2181", "gradeJob");
        CoordinatorRegistryCenter registryCenter = new ZookeeperRegistryCenter(configuration);
        registryCenter.init();
        return registryCenter;
    }
}
