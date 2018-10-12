package com.demo.netty.decorator;

/**
 * 装饰角色：
 * 1.实现构建角色
 * 2.持有构建角色
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}
