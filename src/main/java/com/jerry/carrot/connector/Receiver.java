package com.jerry.carrot.connector;

import com.jerry.carrot.domain.HttpRequest;
import com.jerry.carrot.domain.HttpResponse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Created by Jerry on 2018/6/19 0019.
 */
public class Receiver {
    private BlockingQueue blockingQueue=new LinkedBlockingQueue(100);
    ConnectorRejectedExecutionHandler rejectedExecutionHandler=new ConnectorRejectedExecutionHandler();
    private ExecutorService executorService= new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),200,10, TimeUnit.SECONDS,
            blockingQueue, rejectedExecutionHandler);
    public void receive() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        while (true) {
            Socket accept = serverSocket.accept();
            executorService.execute(() -> {
                try {
//                    InputStream inputStream = accept.getInputStream();
//                    String reqStr = HttpRequest.parse(inputStream);
//                    System.out.println("receive from" + accept.getInetAddress() + " for " + reqStr);
                    OutputStream outputStream = accept.getOutputStream();
                    HttpResponse.returnDemoStr(outputStream);
//                    inputStream.close();
                    outputStream.close();
                    accept.close();
                }catch (IOException ioException){
                    System.out.println(ioException);
                }
            });

        }

    }
}
