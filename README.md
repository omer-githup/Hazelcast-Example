# Hazelcast Example Project


A Java project demonstrating Hazelcast integration



This is a simple Java project that demonstrates the integration of Hazelcast, a distributed in-memory data grid. The project shows how to:
- Connect a Java client to a Hazelcast cluster.
- Store and retrieve data in a distributed map.
- Monitor operations via the Hazelcast Management Center.

## Features
- Inserts 10,000 `Person` objects into a Hazelcast distributed map.
- Retrieves and prints the first 10 entries.
- Monitors `put` and `get` operations using the Hazelcast Management Center.

## Technologies Used
- **Java**: JDK 17
- **Maven**: Dependency management and build automation.
- **Hazelcast**: Distributed data storage and clustering.
- **Docker**: Containerized Hazelcast Server and Management Center.
------------------------------------------------------------

## Setup Instructions

### 1. Run Hazelcast and Management Center
Run the following Docker commands to set up Hazelcast:
```bash
docker network create hazelcast-network

docker run -d --name hazelcast-node --network hazelcast-network -p 5701:5701 \
  -e "HZ_CLUSTER_NAME=dev" \
  -e "HZ_NETWORK_PUBLICADDRESS=hazelcast-node:5701" \
  hazelcast/hazelcast

docker run -d --name hazelcast-mancenter --network hazelcast-network -p 8080:8080 \
  -e "MC_INIT_CLUSTER=hazelcast-node:5701" \
  -e "MC_INIT_CLUSTER_NAME=dev" \
  hazelcast/management-center
---------------------------------------------------------------------

## 2.Build and Run the Java Program

Use Maven to clean and package the project:

mvn clean package

Run the Program
Execute the JAR file:

java -jar target/myproject-1.0-SNAPSHOT.jar

3. Open Hazelcast Management Center
Open the Hazelcast Management Center in your browser:

arduino
Copy code
http://localhost:8080
Verify the following:

The people map contains 10,000 entries.
The statistics for puts and gets are displayed.
The program prints the first 10 entries from the people map:
