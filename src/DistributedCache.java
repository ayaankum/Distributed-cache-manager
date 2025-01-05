public class DistributedCache {
    public static void main(String[] args) {
        CacheManager manager = new CacheManager(4);

        // Add nodes with virtual nodes
        CacheNode node1 = new CacheNode("Node1");
        CacheNode node2 = new CacheNode("Node2");
        CacheNode node3 = new CacheNode("Node3");

        manager.addNode(node1, 3);
        manager.addNode(node2, 3);
        manager.addNode(node3, 3);

        manager.debugRing();

        manager.put("key1", "value1");
        manager.put("key2", "value2");
        manager.put("key3", "value3");
        manager.put("key4", "value4");
        manager.put("key5", "value5");

        System.out.println("key1: " + manager.get("key1"));
        System.out.println("key2: " + manager.get("key2"));
        System.out.println("key3: " + manager.get("key3"));

        System.out.println("Node1 Cache: " + node1.getCacheContents());
        System.out.println("Node2 Cache: " + node2.getCacheContents());
        System.out.println("Node3 Cache: " + node3.getCacheContents());
    }
}
