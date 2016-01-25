/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preproduction.delivery.infrastructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Irbis
 */
public class JavaConfigApplicationContext implements ApplicationContext {

    private final Config config;
    private final Map<String, Object> beans = new HashMap<String, Object>();

    public JavaConfigApplicationContext(Config config) {
        this.config = config;
    }

    public Object getBean(String beanName) throws Exception {
        Class<?> type = config.getImpl(beanName);
        Object bean = beans.get(beanName);
        if (bean != null) {
            return bean;
        }

        BeanBuilder builder = new BeanBuilder(type);
        builder.construct();
        builder.afterConstruct();
        builder.createProxy();
        bean = builder.build();

        beans.put(beanName, bean);
        return bean;
    }

    class BeanBuilder {

        Class<?> type;
        Object bean;

        public BeanBuilder(Class<?> type) {
            this.type = type;
        }                
        
        public void construct() throws Exception {
            Constructor<?> constructor = type.getConstructors()[0];
            Parameter[] parameters = constructor.getParameters();
            if (parameters.length == 0) {
                bean = type.newInstance();
            } else {
                int counter = 0;
                Object[] params = new Object[parameters.length];
                for (Parameter p : parameters) {
                    String typeName = p.getType().getSimpleName();
                    String nameOfBean = Character.toLowerCase(typeName.charAt(0)) + typeName.substring(1);
                    params[counter++] = getBean(nameOfBean);
                }
                bean = constructor.newInstance(params);
            }
        }

        public void afterConstruct() throws Exception {
            Class<?> clazz = bean.getClass();
            Method method = null;
            try {
                method = clazz.getMethod("init");
            } catch(NoSuchMethodException ex) {}            
            if(method != null) {
                method.invoke(bean);
            }
        }

        public void preDestroy() {

        }

        public void createProxy() {

        }

        public Object build() {
            return bean;
        }
    }

}
