package org.maker.controller.task;

import org.maker.service.Adverservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeTask {
    @Autowired
    private Adverservice adverservice;
    @Scheduled(cron= "0 0 1 * * ?") //每天上午1.00触发
    public void statusCheck() {
        adverservice.updateadStatus();
    }


}
