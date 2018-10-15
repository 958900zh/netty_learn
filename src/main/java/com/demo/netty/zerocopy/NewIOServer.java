package com.demo.netty.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer {

    public static void main(String[] args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = socketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {
            SocketChannel accept = socketChannel.accept();
            accept.configureBlocking(true);

            int readCount = 0;

            while (-1 != readCount) {
                readCount = accept.read(byteBuffer);

                byteBuffer.rewind();
            }
        }
    }
}
