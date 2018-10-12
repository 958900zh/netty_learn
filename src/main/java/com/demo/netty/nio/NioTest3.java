package com.demo.netty.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest3 {

    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/com/demo/netty/nio/test2.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        String str = "learn nio";
        byteBuffer.put(str.getBytes());

        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            int write = channel.write(byteBuffer);
        }

        fileOutputStream.close();
    }
}
