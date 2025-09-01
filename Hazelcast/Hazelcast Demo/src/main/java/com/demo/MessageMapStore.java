package com.demo;

import com.hazelcast.map.MapStore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageMapStore implements MapStore<String, Message> {

    private final Map<String, Message> simulatedDb = new ConcurrentHashMap<>();

    @Override
    public void store(String s, Message message) {
        System.out.println("[MapStore] Storing: " + message);
        simulatedDb.put(s,message);
    }

    @Override
    public void storeAll(Map<String, Message> map) {
        simulatedDb.putAll(map);
    }

    @Override
    public void delete(String s) {
        simulatedDb.remove(s);
    }

    @Override
    public void deleteAll(Collection<String> collection) {

    }

    @Override
    public Message load(String s) {
        System.out.println("[Mapstore] Loading: " + s);
        return simulatedDb.get(s);
    }

    @Override
    public Map<String, Message> loadAll(Collection<String> collection) {
        Map<String, Message> loaded = new HashMap<>();
        for (String key : collection) {
            if (simulatedDb.containsKey(key)) {
                loaded.put(key, simulatedDb.get(key));
            }
        }
        return loaded;
    }

    @Override
    public Iterable<String> loadAllKeys() {
        return simulatedDb.keySet();
    }
}
