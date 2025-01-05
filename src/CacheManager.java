public class CacheManager {
    private final ConsistentHashing consistentHashing;

    public CacheManager(int ringSize) {
        this.consistentHashing = new ConsistentHashing(ringSize);
    }

    public void addNode(CacheNode node, int virtualNodeCount) {
        consistentHashing.addNode(node, virtualNodeCount);
    }

    public void removeNode(CacheNode node) {
        consistentHashing.removeNode(node);
    }

    public void put(String key, String value) {
        CacheNode node = consistentHashing.getNode(key);
        if (node != null) {
            System.out.println("Key: " + key + " (Hash: " + key.hashCode() + ") -> Node: " + node.getNodeId());
            node.put(key, value);
        }
    }

    public String get(String key) {
        CacheNode node = consistentHashing.getNode(key);
        if (node != null) {
            return node.get(key);
        }
        return null;
    }

    public void debugRing() {
        consistentHashing.debugRing();
    }
}
