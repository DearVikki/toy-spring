package com.minis.beans;

import com.minis.BeanDefinition;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
//    Boolean containsBean(String name);
    void registerBeanDefinition(BeanDefinition bean);
}
