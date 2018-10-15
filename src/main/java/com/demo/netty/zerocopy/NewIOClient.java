package com.demo.netty.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        socketChannel.configureBlocking(true);

        String filePath = "E:\\NewFile\\LearningMaterials\\jdk-10.0.1_windows-x64_bin.exe";

        FileChannel fileChannel = new FileInputStream(filePath).getChannel();

        long start = System.currentTimeMillis();
        long transferTo = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("发送总字节数：" + transferTo + "，总共耗时：" + (System.currentTimeMillis() - start));
    }
}
