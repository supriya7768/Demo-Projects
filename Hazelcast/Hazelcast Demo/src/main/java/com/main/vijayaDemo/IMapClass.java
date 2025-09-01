package com.main.vijayaDemo;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IMapClass {

    @Autowired
    HazelcastInstance hazelcastInstance;

    @PostConstruct
    public void initData(){
        IMap<String, String> map = hazelcastInstance.getMap("my-map");
        System.out.println("Preloaded data into Map");
        map.put("fruit", "apple");
        map.put("color", "blue");
    }

}
