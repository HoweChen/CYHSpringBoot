package com.howechen.springboot.utils;

import io.netty.util.internal.StringUtil;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

public class PasswordUtils {

  public static byte[] generateSalt() {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);
    return salt;
  }

  @SneakyThrows
  public static String generatePassword(byte[] salt, String password) {
    MessageDigest md = MessageDigest.getInstance("SHA-512");
    md.update(salt);

    String result;
    if (StringUtils.isNotEmpty(password)) {
      byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
      result = Base64.getEncoder().encodeToString(hashedPassword);
    } else {
      throw new IllegalArgumentException("Password cannot be null or empty");
    }
    return result;
  }

  public static boolean verityPassword(String given, String dbSalt, String encrypted) {
    final byte[] salt = Base64.getDecoder().decode(dbSalt);
    return StringUtils.equals(encrypted, PasswordUtils.generatePassword(salt, given));
  }

}
