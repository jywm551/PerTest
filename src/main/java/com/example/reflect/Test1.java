package com.example.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created By Yu On 2018/09/18
 * Description：
 **/
public class Test1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> c = MethodClass.class;
        Object object = c.newInstance();
        Method[] methods = c.getMethods();
        Method[] declaredMethods = c.getDeclaredMethods();
        // 获取MethodClass类的add方法
        Method add = c.getMethod("add", int.class, int.class);
        // getMethods()方法获取的所有方法
        System.out.println("getMethods获取的方法： ");
        for (Method m : methods) {
            System.out.println(m);
        }
        // getDeclaredMethods()方法获取的所有方法
        System.out.println("getDeclaredMethods获取的方法： ");
        for (Method m : declaredMethods) {
            System.out.println(m);
        }

    }
}

class Test2 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = MethodClass.class;
        // 创建MethodClass的实例
        Object o = c.newInstance();
        // 获取MethodClass类的add方法
        Method add = c.getMethod("add", int.class, int.class);
        // 调用method对应的方法 => add(1,4)
        Object invoke = add.invoke(o, 1, 4);
        System.out.println(invoke);
    }
}

class MethodClass {
    public final int num = 3;

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a + b;
    }
}