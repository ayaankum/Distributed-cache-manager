# **Distributed Caching System**

A Java-based implementation of a distributed caching system using consistent hashing to manage the distribution of data across multiple cache nodes.

---

## **Features**
- **Consistent Hashing:** Ensures even distribution of keys across nodes while minimizing data movement when nodes are added or removed.
- **Scalability:** Supports adding/removing nodes dynamically.
- **Virtual Nodes:** Improves key distribution by using multiple hash points per physical node.
- **Fault Tolerance:** Handles scenarios where a node fails or is removed.

---

## **Project Structure**

The project consists of the following components:

1. **`CacheNode`**
   - Represents an individual cache node.
   - Stores key-value pairs in an internal map.
   - Provides methods to add, retrieve, and inspect cached data.

2. **`ConsistentHashing`**
   - Implements the consistent hashing algorithm.
   - Manages the hash ring and maps keys to appropriate cache nodes.
   - Supports virtual nodes for better distribution.

3. **`CacheManager`**
   - Acts as the controller for the caching system.
   - Interfaces with `ConsistentHashing` and `CacheNode` to handle key-value operations.
   - Provides methods to add/remove nodes and debug the hash ring.

4. **`DistributedCache`**
   - The main class to demonstrate the system in action.
   - Adds nodes, performs cache operations, and inspects node contents.

---

## **Setup and Usage**

### Prerequisites
- Java Development Kit (JDK) 8 or higher.
- A terminal or IDE to run the Java files.

### Steps to Run
1. **Clone or Download the Project:**
   ```bash
   git clone <repository-url>
   cd distributed-caching
