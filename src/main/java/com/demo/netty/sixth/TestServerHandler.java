package com.demo.netty.sixth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage msg) throws Exception {
        DataInfo.MyMessage.DataType dataType = msg.getDataType();
        if (dataType == DataInfo.MyMessage.DataType.StudentType) {
            System.out.println("来自客户端[student]: " + msg.getStudent().getName());
            System.out.println("来自客户端[student]: " + msg.getStudent().getAge());
            System.out.println("来自客户端[student]: " + msg.getStudent().getAddress());
        } else if (dataType == DataInfo.MyMessage.DataType.TeacherType) {
            System.out.println("来自客户端[teacher]: " + msg.getTeacher().getName());
            System.out.println("来自客户端[teacher]: " + msg.getTeacher().getAge());
        } else {
            System.out.println("来自客户端[dog]: " + msg.getDog().getName());
        }

    }
}
