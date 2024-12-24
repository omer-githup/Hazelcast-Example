package org.example;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class MainClass {
    public static void main(String[] args) {
        // Connect to Hazelcast server
        HazelcastInstance client = HazelcastClient.newHazelcastClient();

        // Create a Hazelcast map
        IMap<Integer, Person> map = client.getMap("people");

        // Put 10,000 Person objects into the map
        for (int i = 1; i <= 10000; i++) {
            map.put(i, new Person(i, "Person " + i));
        }

        // Retrieve and print a few entries
        for (int i = 1; i <= 10; i++) {
            System.out.println("Key: " + i + ", Value: " + map.get(i));
        }

        // Shutdown the client
        client.shutdown();
    }
}
