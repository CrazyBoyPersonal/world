package org.crazy.world.uitls;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Create with IntelliJ IDEA
 * User : kevin
 * Dare : 2018/4/10
 * Time : 11:53
 * To change this template use File | Setting | File Template.
 * Description : MD5 加密算法工具
 * @author kevin
 */
public class Md5Uitl {
  public static String encodeByMD5(String string) {
    byte[] secretBytes = null;
    try {
      secretBytes = MessageDigest.getInstance("md5").digest(
          string.getBytes());
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("找不到md5算法");
    }
    String md5code = new BigInteger(1, secretBytes).toString(16);

    for (int i = 0; i < 32 - md5code.length(); i++) {
      md5code = "0" + md5code;
    }

    return md5code;
  }
}
