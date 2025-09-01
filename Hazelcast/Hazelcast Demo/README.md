# Hazelcast Demo Project

# Dependency

Add dependency of hazelcast in build.gradle 

```bash
implementation 'com.hazelcast:hazelcast:5.3.6'
```

# Flow of Data in Hazelcast Demo

```bash
Step | Component | Action
1 | Producer (Main Thread) | Sends 3 Message objects to queue-1 using queue1.put()
2 | Consumer (New Thread) | Takes message from queue-1 using queue1.take()
3 | Consumer | Saves it to messageMap.put() → triggers MessageMapStore.store()
4 | MapStore.store() | Simulated DB stores the message using an in-memory ConcurrentHashMap
5 | Consumer | Forwards the same message to queue-2 using queue2.put()
6 | Main Thread | Prints final sizes of queue-2 and messageMap before shutdown
```

# Configuration chain

```bash
Component | Configured By | Purpose
message-map (IMap) | MapConfig | Tells Hazelcast to use this map with a MapStore
MapConfig | config.addMapConfig() | Includes MapStoreConfig
MapStoreConfig | Points to MessageMapStore | Ensures custom logic is used to persist and load data
MessageMapStore | Implements MapStore | Provides in-memory persistence simulation (you can replace it with DB/File)
HazelcastInstance | Hazelcast.newHazelcastInstance(config) | Bootstraps Hazelcast with your config
```












