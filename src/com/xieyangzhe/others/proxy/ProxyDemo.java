package com.xieyangzhe.others.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Yangzhe Xie
 * @date 20/4/20
 */
public class ProxyDemo {
    public static void main(String[] args) {
        IUserDao target = new UserDaoImpl();
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), UserDaoImpl.class.getInterfaces(),
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
                System.out.println("Before invocation");
                Object ret = method.invoke(target, args);
                System.out.println("After invocation");
                System.out.println(method.getName());
                return 100;
            }
        });
        System.out.println(userDao.insertUser("Joseph"));
    }
}
