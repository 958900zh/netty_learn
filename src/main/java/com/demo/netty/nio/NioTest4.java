package com.demo.netty.nio;

import java.nio.ByteBuffer;

public class NioTest4 {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        byteBuffer.putInt(15);
        byteBuffer.putLong(10000000000L);
        byteBuffer.putDouble(1.23456789);
        byteBuffer.putChar('你');
        byteBuffer.putShort((short) 5);
        byteBuffer.putChar('好');

        byteBuffer.flip();

        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getChar());
    }
}
