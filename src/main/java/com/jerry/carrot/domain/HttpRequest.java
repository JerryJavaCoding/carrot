package com.jerry.carrot.domain;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jerry on 2018/7/8 0008.
 */
public class HttpRequest {
    public static String parse(InputStream inputStream) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] buffer = new byte[1024];
        StringBuilder stringBuilder = new StringBuilder();
        int length = 0;
        while (true) {
            try {
                length = bufferedInputStream.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(new String(buffer, 0, length));

            if (length <= 0 || length < 1024) {
                break; // 如果没有读取到内容就跳出循环
            }

        }
//        try {
////            bufferedInputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return stringBuilder.toString();
    }
}
