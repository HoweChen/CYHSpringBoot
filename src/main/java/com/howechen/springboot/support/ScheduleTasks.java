package com.howechen.springboot.support;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduleTasks {

  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

//  @Scheduled(fixedRate = 10000)
//  public void reportCurrentTime() {
//    log.info("The time is now {}", DATE_FORMAT.format(new Date()));
//  }

}
