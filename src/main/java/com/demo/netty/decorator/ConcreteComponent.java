package com.demo.netty.decorator;

/**
 * 具体构建角色
 * 相当于FileInputStream
 */
public class ConcreteComponent implements Component {

    @Override
    public void doSomething() {
        System.out.println("功能A");
    }
}
