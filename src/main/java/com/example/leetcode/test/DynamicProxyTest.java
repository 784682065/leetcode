package com.example.leetcode.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: hzp
 * @date: 2022/3/19
 * @description:
 */
public class DynamicProxyTest {
    interface IHello{
        void hello();
        void saysomething(String something);

    }

    static class Hello implements  IHello{

        @Override
        public void hello() {
            System.out.println("hello");
        }

        @Override
        public void saysomething(String something) {
            System.out.println(something);
        }
    }


    static class  DynamicProxy implements InvocationHandler{

        Object originalObj;

        Object bind(Object originalObj){
            this.originalObj = originalObj;

            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),
                    originalObj.getClass().getInterfaces(),this);
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //这里可以判断method name
            if (method.getName().equals("saysomething")){
                System.out.println("before");
            }
            return method.invoke(originalObj,args);
        }
    }

    public static void main(String[] args) {
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.hello();
        hello.saysomething("ahah ");
    }

}