package com.demo.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        //1.构造Student对象
        DataInfo.Student student = DataInfo.Student.newBuilder()
                .setName("张三").setAge(20).setAddress("北京").build();

        //2.生成字节数组
        byte[] toByteArray = student.toByteArray();

        //3.从字节数组中将对象反序列化出来
        DataInfo.Student student2 = DataInfo.Student.parseFrom(toByteArray);

        System.out.println(student2);
    }
}
