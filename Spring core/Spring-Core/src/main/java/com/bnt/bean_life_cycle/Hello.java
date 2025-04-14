package com.bnt.bean_life_cycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("This is init method present in InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("This is destroy method present in DisposableBean");
    }
}
