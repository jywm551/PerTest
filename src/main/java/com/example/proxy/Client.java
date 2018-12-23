package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created By Yu On 2018/09/18
 * Description：
 **/
public class Client {
    public static void main(String[] args) {
        // 代理的真实对象
        RealSubject realSubject = new RealSubject();
        // 要代理的对象，讲该对象传进去，最后通过该真实对象来调用其方法
        InvocationHandler handler = new DynamicProxy(realSubject);

        /**
         * 通过Proxy的newInstance方法来创建我们的代理对象，
         * 第一个参数 handler.getClass().getClassLoader() 使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数 realSubject.getClass().getInterfaces() 为代理对象提供的接口时真实对象所实行的接口，表示要代理的对象时该
         *  真实对象，可以调用接口中的方法
         * 第三个参数，handler 将代理对象关联到InvocationHandler对象
         */
        Subject subject = (Subject) Proxy
                .newProxyInstance(handler.getClass().getClassLoader(),
                        realSubject.getClass().getInterfaces(), handler);

        System.out.println(subject.getClass().getName());

        subject.rent();
        subject.hello("world");

    }
}
