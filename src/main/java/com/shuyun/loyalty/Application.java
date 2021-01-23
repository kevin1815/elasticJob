package com.shuyun.loyalty;

import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.shuyun.loyalty.factory.JobConfigurationFactory;
import com.shuyun.loyalty.factory.RegistryCenterFactory;
import com.shuyun.loyalty.job.GradeKeepingSimpleJob;
import com.shuyun.loyalty.listener.GradeKeepingJobListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> new SpringJobScheduler(new GradeKeepingSimpleJob(),
                RegistryCenterFactory.create(), JobConfigurationFactory.create(),
                new GradeKeepingJobListener()).init();
    }

}
