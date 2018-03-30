package com.lckiss.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserJob {

    @Scheduled(cron = "0 0 9 * * ?")
    public void dailyJob(){
        System.out.println("每天上午9点执行一次");
    }

    @Scheduled(fixedRate = 1000)
    public void birthdayJob(){
        System.out.println("每一秒种执行一次");
    }
}
