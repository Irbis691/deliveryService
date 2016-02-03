/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.infrastructure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;

/**
 *
 * @author Irbis
 */
public class CustomBeanFactoryPostprocessor implements BeanFactoryPostProcessor{

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("newCustomer");
        ConstructorArgumentValues argValues = bd.getConstructorArgumentValues();
        System.out.println(argValues.getArgumentCount());
        System.out.println(argValues.getArgumentValue(0, null));
//        System.out.println(o.getValue().toString());
//        o.setValue("Nik");
//        bd.setScope("singleton");
    }
    
}
