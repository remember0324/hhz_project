package com.hhz.jdk8_newFeature.Base64;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

/**
 * @Author Rem
 * @Date 2019-09-04
 * @Version 1.0
 */

public class Demo {
    public static void main(String[] args) {

        //编码前语句
        String word = "java-世界上最好的编程语言,没有之一";
        // 使用基本编码生成加密
        String key1 = Base64.getEncoder().encodeToString(word.getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 编码字符串 (基本) :" + key1);

        // 根据得到的key解码
        byte[] base64decodedBytes = Base64.getDecoder().decode(key1);
        System.out.println("原始字符串: " + new String(base64decodedBytes, StandardCharsets.UTF_8));

        //对URl进行加密
        String key2 = Base64.getUrlEncoder().encodeToString("https://www.baidu.com".getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 编码字符串 (URL) :" + key2);
        //根据密文解密URl
        base64decodedBytes = Base64.getUrlDecoder().decode(key2);
        System.out.println("原始URL: " + new String(base64decodedBytes, StandardCharsets.UTF_8));


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            stringBuilder.append(UUID.randomUUID().toString());
        }

        byte[] mimeBytes = stringBuilder.toString().getBytes(StandardCharsets.UTF_8);
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
        System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);
        byte[] decode = Base64.getMimeDecoder().decode(mimeEncodedString);
        System.out.println(Arrays.toString(decode));

    }
}
