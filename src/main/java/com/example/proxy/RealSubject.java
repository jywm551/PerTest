package com.example.proxy;

/**
 * Created By Yu On 2018/09/18
 * Description：
 **/
public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: "+ str);
    }
}
