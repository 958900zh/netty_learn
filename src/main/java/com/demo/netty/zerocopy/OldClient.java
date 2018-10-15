package com.demo.netty.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

public class OldClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8899);

        String filePath = "E:\\NewFile\\LearningMaterials\\jdk-10.0.1_windows-x64_bin.exe";

        InputStream inputStream = new FileInputStream(filePath);

        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        byte[] byteArrays = new byte[4096];

        int readCount;
        int totalCount = 0;
        long start = System.currentTimeMillis();
        while ((readCount = inputStream.read(byteArrays)) >= 0) {
            totalCount += readCount;
            outputStream.write(byteArrays, 0, byteArrays.length);
        }

        System.out.println("发送总字节数：" + totalCount + "，总共耗时：" + (System.currentTimeMillis() - start));

        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
