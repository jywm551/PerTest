package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created By Yu On 2018/09/18
 * Description：
 **/
public class DynamicProxy implements InvocationHandler {

    // 要代理的真实对象
    private Object subject;

    // 构造方法，给代理的真实对象赋初值
    DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before rent house");

        System.out.println("Method:" + method);
        // 当代理对象调用真实对象的方法时，会自动跳转到对象的handler对象的invoke方法
        method.invoke(subject,args);
        // 在代理真实对象后添加自己的操作
        System.out.println("after rent house");
        return null;
    }
}
