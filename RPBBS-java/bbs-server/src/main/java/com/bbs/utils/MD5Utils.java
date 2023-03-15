package com.bbs.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    /** @param source 需要加密的字符串
     * @return
     */
    public static String getHash(String source) {
        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(source.getBytes());
            byte[] encryptStr = md.digest();

            char str[] = new char[16 * 2];

            int k = 0;
            // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) {
            // 从第一个字节开始，对每一个字节,转换成 16 进制字符的转换
                byte byte0 = encryptStr[i];
                // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf];
            // 取字节中低 4 位的数字转换
            }
            return new String(str);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
