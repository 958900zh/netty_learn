package com.demo.netty.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class NioTest8 {

    public static void main(String[] args) throws IOException {
        String inputFile = "src/main/java/com/demo/netty/nio/NioTest8_In.txt";
        String outputFile = "src/main/java/com/demo/netty/nio/NioTest8_Out.txt";

        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile, "rw");

        long length = new File(inputFile).length();

        FileChannel inputChannel = inputRandomAccessFile.getChannel();
        FileChannel outputChannel = outputRandomAccessFile.getChannel();

        MappedByteBuffer inputData = inputChannel.map(FileChannel.MapMode.READ_ONLY, 0, length);

        Charset charset = Charset.forName("utf-8");

        CharsetDecoder decoder = charset.newDecoder(); //字节数组 -> 字符串
        CharsetEncoder encoder = charset.newEncoder(); //字符串 -> 字节数组

        CharBuffer charBuffer = decoder.decode(inputData);
        ByteBuffer outputData = encoder.encode(charBuffer);

        outputChannel.write(outputData);

        inputChannel.close();
        outputChannel.close();
    }
}
