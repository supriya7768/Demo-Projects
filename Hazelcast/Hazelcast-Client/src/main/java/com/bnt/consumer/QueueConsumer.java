package com.bnt.consumer;

import com.hazelcast.collection.IQueue;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Slf4j
public class QueueConsumer {

    @Autowired
    HazelcastInstance hazelcastInstance;

    public void startConsumer(){
        new Thread(()-> {
            try{
                IQueue<String> queue = hazelcastInstance.getQueue("my-queen");
                while(true) {
                    String message = queue.take();
                    log.info("Task received from my-queue: " + message);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
