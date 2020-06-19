package com.howechen.springboot.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ThreadServiceImpl implements ThreadService {


  @Override
  public void threadSleep() {
    log.info("ThreadName: {}", Thread.currentThread().getName());
    log.info("ThreadId: {}", Thread.currentThread().getId());

    try {
      TimeUnit.SECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("Random double number: {}", new Random().nextDouble());
  }
}
