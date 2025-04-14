package com.bnt.ioc;

public class Airtel implements Sim{

    Airtel(){
        System.out.println("airtel constructor");
    }

    @Override
    public void calling() {
        System.out.println("calling using Airtel");
    }

    @Override
    public void data() {
        System.out.println("browsing internet using Airtel sim");
    }
}
