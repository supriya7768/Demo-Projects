package com.configLoader;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
    public class ConfigLoader {

        private final ConfigEntryRepository repository;
        private final IMap<String, String> configMap;

        public ConfigLoader(ConfigEntryRepository repository, HazelcastInstance hazelcastInstance) {
            this.repository = repository;
            this.configMap = hazelcastInstance.getMap("configMap");
        }

        @PostConstruct
        public void loadConfigFromDb() {
            List<ConfigEntry> entries = repository.findAll();
            entries.forEach(entry -> configMap.put(entry.getKey(), entry.getValue()));
        }

        public void put(String key, String value) {
            configMap.put(key, value);
            repository.save(new ConfigEntry(key, value));
        }

        public String get(String key) {
            return configMap.get(key);
        }

        public Map<String, String> getAll() {
            return new HashMap<>(configMap);
        }
    }

