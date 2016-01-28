/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.infrastructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author Irbis
 */
public class BenchmarkProxyCreator {

    public Object getProxy(final Object o) {

        final Class<?> type = o.getClass();

        return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(),
                new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (type.getMethod(method.getName(), method.getParameterTypes()).
                        isAnnotationPresent(Benchmark.class)) {                    
                    System.out.println("Method " + method.getName() + "is started");
                    long startTime = System.nanoTime();
                    Object result = method.invoke(o, args);
                    System.out.println("Method " + method.getName() + "is finished");
                    System.out.println("Total time: " + 
                            (System.nanoTime() - startTime) + " nanosecconds");
                    return result;
                } else {
                    return method.invoke(o, args);
                }
            }
            
        });
    }
}
