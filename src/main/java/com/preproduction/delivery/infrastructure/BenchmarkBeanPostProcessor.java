/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.infrastructure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *
 * @author Irbis
 */
public class BenchmarkBeanPostProcessor implements BeanPostProcessor{

    public Object postProcessBeforeInitialization(Object o, String string) throws BeansException {
        System.out.println("Before: " + string);
//        o = new BenchmarkProxyCreator().getProxy(o);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String string) throws BeansException {
        System.out.println("After: " + string);
        o = new BenchmarkProxyCreator().checkForAnnotExisting(o);
        return o;
    }
    
}
