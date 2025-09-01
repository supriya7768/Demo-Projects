package com.bnt.producer;

import com.hazelcast.collection.IQueue;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.logging.Logger;

@Component
@Slf4j
public class QueueProducer {

    @Autowired
    HazelcastInstance hazelcastInstance;

    public String sendTask(String task) {
        IQueue<String> queue = hazelcastInstance.getQueue("my-queue");
        queue.offer(task);
        log.info("Task sent to my-queue: " + task);
        return task;
    }
}
