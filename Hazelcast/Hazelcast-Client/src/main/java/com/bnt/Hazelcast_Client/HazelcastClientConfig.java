package com.bnt.Hazelcast_Client;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.config.NearCacheConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class HazelcastClientConfig {

//    @Bean
//    public HazelcastInstance hazelcastInstance(){
//        ClientConfig config = new ClientConfig();
//        config.setClusterName("hazelcast-cluster-demo");
//        config.getNetworkConfig().addAddress("localhost:5701","localhost:5702");
//
//        NearCacheConfig nearCacheConfig = new NearCacheConfig();
//        nearCacheConfig.setInvalidateOnChange(true);                              //This keeps the server in sync
//        nearCacheConfig.setName("employeMap");
//        nearCacheConfig.setTimeToLiveSeconds(0);                                 //This will remove the near cache in the second provided
//
//        config.addNearCacheConfig(nearCacheConfig);
//
//        return HazelcastClient.newHazelcastClient(config);
//    }

    @Value("${hazelcast.cluster.name:hazelcast-cluster-demo}")
    private String clusterName;

    @Value("${hazelcast.near.cache:employeeMap}")
    private String nearCacheName;

    @Bean
    public HazelcastInstance hazelcastInstance() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("hazelcast.cluster.name", clusterName);
        properties.setProperty("hazelcast.near.cache", nearCacheName);

        XmlClientConfigBuilder builder = new XmlClientConfigBuilder("hazelcast-client-config.xml");
        builder.setProperties(properties); // inject values

        ClientConfig config = builder.build();
        return HazelcastClient.newHazelcastClient(config);
    }
}
