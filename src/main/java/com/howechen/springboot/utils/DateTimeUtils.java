package com.howechen.springboot.utils;

import java.sql.Date;
import java.sql.Timestamp;

public class DateTimeUtils {

  public static Timestamp getCurrentTimestamp() {
    return new Timestamp(System.currentTimeMillis());
  }

  public static Date getCurrentDate() {
    return new Date(System.currentTimeMillis());
  }
}
