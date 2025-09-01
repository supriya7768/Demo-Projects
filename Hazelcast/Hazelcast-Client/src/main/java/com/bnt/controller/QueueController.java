package com.bnt.controller;

import com.bnt.consumer.QueueConsumer;
import com.bnt.producer.QueueProducer;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class QueueController {

    @Autowired
    QueueProducer queueProducer;

    @Autowired
    QueueConsumer queueConsumer;

    @PostMapping("/{message}")
    public String sendTask(@PathVariable String message) {
        return queueProducer.sendTask(message);
    }

    @GetMapping("/start-consumer")
    public String startConsumer(){
        queueConsumer.startConsumer();
        return "Consumer started";
    }
}
