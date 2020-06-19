package com.howechen.springboot;

import com.howechen.springboot.service.ThreadService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ThreadServiceTest extends BaseSpringBootTest {

  @Autowired
  private ThreadService threadService;

  @Test
  public void test() {
    Thread t1 = new Thread(() -> threadService.threadSleep());
    Thread t2 = new Thread(() -> threadService.threadSleep());
    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
