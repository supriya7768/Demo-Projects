package com.demo;

import com.hazelcast.collection.IQueue;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.UUID;

public class HazelcastDemo {

    public static void main(String[] args) throws Exception {

        MapStoreConfig mapStoreConfig = new MapStoreConfig()
                .setImplementation(new MessageMapStore())
                .setWriteDelaySeconds(0)
                .setEnabled(true);

        MapConfig mapConfig = new MapConfig("message-map")
                .setMapStoreConfig(mapStoreConfig);

        Config config = new Config();
        config.addMapConfig(mapConfig);

        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);

        IQueue<Message> queue1 = hazelcastInstance.getQueue("queue-1");
        IQueue<Message> queue2 = hazelcastInstance.getQueue("queue-2");
        IMap<String, Message> messageMap = hazelcastInstance.getMap("message-map");

        //Consumer thread
        new Thread(() -> {
            while(true){
                try{
                    Message message = queue1.take();
                    System.out.println("[Consumer] Received from queue-1 : " + message);
                    //Save to Map
                    messageMap.put(message.getId(), message);
                    //Forward to queue-2
                    queue2.put(message);
                    System.out.println("[Consumer] Forwarded to queue-2: " + message);
                }catch (InterruptedException e){
                    break;
                }
        }
        }).start();

        // Let us send 3 message in queue-1
        for (int i = 1; i <= 3; i++) {
            Message message = new Message(UUID.randomUUID().toString(), "Message # " + i);
            queue1.put(message);
            System.out.println("[Producer] Sent to queue-1: " + message);
            Thread.sleep(500);
        }
        Thread.sleep(3000);
        System.out.println("Final queue-2 size : " + queue2.size());
        System.out.println("Map contains :" + messageMap.size() + " entries");

        hazelcastInstance.shutdown();
    }
}
