//Comment if using xml file of hazelcast-config.xml

//package com.main.vijayaDemo;
//
//import com.hazelcast.config.*;
//import com.hazelcast.core.Hazelcast;
//import com.hazelcast.core.HazelcastInstance;
//import com.main.vijayaDemo.mapstore.EmployeeMapstore;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//
//@Configuration
//public class HazelcastConfig {
//
//    @Bean
//    @Lazy
//    public HazelcastInstance hazelcastInstance(EmployeeMapstore employeeMapstore){
//        Config config = new Config();
//        config.setClusterName("hazelcast-cluster-demo");
//        config.setInstanceName("hazelcast-instance-demo");
//
//        //Here the network is in localhost
//        NetworkConfig networkConfig = config.getNetworkConfig();
//        JoinConfig joinConfig = networkConfig.getJoin();
//        joinConfig.getMulticastConfig().setEnabled(false);
//        joinConfig.getTcpIpConfig().setEnabled(true)
//                                    .addMember("localhost:5701")
//                                    .addMember("localhost:5702")
//                                    .addMember("localhost:5702");
//        networkConfig.setPortCount(2);
//
//        MapConfig myMapConfig = new MapConfig();
//        myMapConfig.setName("my-map");
//
//        MapConfig demoMapConfig = new MapConfig();
//        demoMapConfig.setName("demoMap");
//        demoMapConfig.setTimeToLiveSeconds(10);      //This will remove after 10 second
//        demoMapConfig.setMaxIdleSeconds(5);      //After fetching it will remain only for 5 seconds
//        config.addMapConfig(demoMapConfig);
//
//
//        //Mapstore config  ----for this in method argument write EmployeeMapstore employeeMapstore
//        MapStoreConfig empMapStoreConfig = new MapStoreConfig();
//        empMapStoreConfig.setImplementation(employeeMapstore).setWriteDelaySeconds(0)  //write Through it will add at that time only and if we write 5 in argument then that is write behind it will save all data in DB after 5 second
//                                                                                        //it will call store() for 0 second and storeAll() for any number of seconds
//                .setInitialLoadMode(MapStoreConfig.InitialLoadMode.EAGER);             //When we will start the application it will load and loadAllKeys method are called
//
//        MapConfig employeeMapConfig = new MapConfig();
//        employeeMapConfig.setMapStoreConfig(empMapStoreConfig).setName("employeeMap");
//
//        EvictionConfig evictionConfig = new EvictionConfig();                                //This is used for deleting any value in Map if it is full
//        evictionConfig.setEvictionPolicy(EvictionPolicy.LFU)                                 //LFU - Least Frequently used   LRU- Least recently used, RANDOM - any random value, NONE- No value
//                        .setMaxSizePolicy(MaxSizePolicy.ENTRY_COUNT)
//                                .setSize(5);
//
//        config.addMapConfig(employeeMapConfig);
//
//        return Hazelcast.newHazelcastInstance(config);
//
//    }
//}
//
