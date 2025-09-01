package com.configLoader;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class HazelcastConfig {

        @Bean
        public Config hazelcastConfig() {
            MapConfig configMap = new MapConfig("configMap");
            configMap.setTimeToLiveSeconds(0);

            return new Config()
                    .setInstanceName("hazelcast-instance")
                    .setClusterName("hazelcast-cluster")
                    .addMapConfig(configMap);

        }

    }

