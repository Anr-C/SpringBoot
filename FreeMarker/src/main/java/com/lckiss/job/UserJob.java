package com.lckiss.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserJob {

    private final static Logger log= LoggerFactory.getLogger(UserJob.class);

//    @Scheduled(fixedRate = 1000) //每一秒种执行一次
    @Scheduled(cron = "0 0 9 * * ?")
    public void birthdayJob(){
        log.info("每一秒种执行一次");
    }
}
