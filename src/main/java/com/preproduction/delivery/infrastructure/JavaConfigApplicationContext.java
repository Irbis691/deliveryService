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
        builder.createProxy();
        builder.callPostCreateAnnotatedMethod();
        builder.afterConstruct();
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
            if (constructor.getParameterCount() == 0) {
                bean = type.newInstance();
            } else {
                bean = recurConstruct(constructor);
            }
        }

        private Object recurConstruct(Constructor<?> constructor) throws Exception {
            Parameter[] parameters = constructor.getParameters();
            Object[] params = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {                
                String nameOfBean = getBeanNameByType(parameters[i]);
                params[i] = getBean(nameOfBean);
            }
            return constructor.newInstance(params);
        }

        private String getBeanNameByType(Parameter parameter) {
            String typeName = parameter.getType().getSimpleName();
            String nameOfBean = Character.toLowerCase(typeName.charAt(0)) +
                    typeName.substring(1);
            return nameOfBean;
        }

        public void afterConstruct() throws Exception {
            Class<?> clazz = bean.getClass();
            Method method = null;
            try {
                method = clazz.getMethod("init");
            } catch(NoSuchMethodException ex) {
                return;
            }            
            if(method != null) {
                method.invoke(bean);
            }
        }
        
        private void callPostCreateAnnotatedMethod() throws Exception {            
            for (Method method : bean.getClass().getMethods()) {
                if (method.isAnnotationPresent(PostCreate.class)) {
                    method.invoke(bean);
                }
            }
                    
        }

        public void preDestroy() {

        }

        public void createProxy() {
            for(Method method: bean.getClass().getMethods()) {
                if(method.isAnnotationPresent(Benchmark.class)) {
                    bean = new BenchmarkProxyCreator().getProxy(bean);
                    break;
                }
            }            
        }

        public Object build() {
            return bean;
        }
    }

}
