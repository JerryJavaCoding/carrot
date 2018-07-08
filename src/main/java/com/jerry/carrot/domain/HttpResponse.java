package com.jerry.carrot.domain;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Jerry on 2018/7/8 0008.
 */
public class HttpResponse {
    public static void returnDemoStr(OutputStream outputStream){
        String str = "HTTP/1.1 200 OK\n" +
                "Server: carrot/4.0\n" +
                "Date: Sun, 08 Jul 2018 20:22:33 GMT\n" +
                "Content-Type: text/html\n" +
                "Last-Modified: Tue, 19 May 2018 13:15:42 GMT\n" +
//                    "Content-Length: 85\n" +
                "\n" +
                "<html>" +
                "<head>" +
                "<title>解读HTTP包示例</title>" +
                "<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>" +
                "</head>" +
                "<body>" +
                "Hello WORLD!" +
                "</body>" +
                "</html>";

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        try {
            bufferedOutputStream.write(str.getBytes());
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
