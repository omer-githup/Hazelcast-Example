package org.example;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class sample {
    public static void main(String[] args) {

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("localhost:5701"); // assuming Hazelcast is running locally
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

        IMap<Integer, Person> map = client.getMap("My map");

        for (int i = 0; i < 10000; i++) {
            map.put(i, new Person(i, "Person"));
        }
        System.out.println("Inserted 10,000 Person objects.");

        Person person = map.get(5000); // Retrieve Person with key 5000
        System.out.println("Retrieved: " + person);

        client.shutdown();
    }
}
