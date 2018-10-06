package com.demo.netty.sixth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int i = new Random().nextInt(3);

        DataInfo.MyMessage message = null;

        if (i == 0) {
            message = DataInfo.MyMessage.newBuilder()
                    .setDataType(DataInfo.MyMessage.DataType.StudentType)
                    .setStudent(
                            DataInfo.Student.newBuilder()
                                    .setName("张三").setAge(20).setAddress("北京")
                                    .build()
                    ).build();
        } else if (i == 1) {
            message = DataInfo.MyMessage.newBuilder()
                    .setDataType(DataInfo.MyMessage.DataType.TeacherType)
                    .setTeacher(
                            DataInfo.Teacher.newBuilder().setName("李四").setAge(35).build()
                    ).build();
        } else {
            message = DataInfo.MyMessage.newBuilder()
                    .setDataType(DataInfo.MyMessage.DataType.DogType)
                    .setDog(
                            DataInfo.Dog.newBuilder().setName("哈士奇").build()
                    ).build();
        }

        ctx.writeAndFlush(message);
    }
}
