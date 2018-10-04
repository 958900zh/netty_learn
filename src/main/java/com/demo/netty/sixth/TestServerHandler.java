package com.demo.netty.sixth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<DataInfo.Student> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {
        System.out.println("来自客户端: " + msg.getName());
        System.out.println("来自客户端: " + msg.getAge());
        System.out.println("来自客户端: " + msg.getAddress());
    }
}
