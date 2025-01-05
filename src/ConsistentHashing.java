import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {
    private final TreeMap<Integer, CacheNode> ring;
    private final int ringSize;

    public ConsistentHashing(int ringSize) {
        this.ring = new TreeMap<>();
        this.ringSize = ringSize;
    }

    public void addNode(CacheNode node, int virtualNodeCount) {
        for (int i = 0; i < virtualNodeCount; i++) {
            int hash = getHash(node.getNodeId() + "#" + i);
            ring.put(hash, node);
        }
    }

    public void removeNode(CacheNode node) {
        ring.values().removeIf(value -> value.equals(node));
    }

    public CacheNode getNode(String key) {
        if (ring.isEmpty()) return null;

        int hash = getHash(key);
        SortedMap<Integer, CacheNode> tailMap = ring.tailMap(hash);
        int nodeHash = tailMap.isEmpty() ? ring.firstKey() : tailMap.firstKey();

        return ring.get(nodeHash);
    }

    private int getHash(String key) {
        return Math.abs(key.hashCode()) % ringSize; // Custom hash function for better distribution
    }

    public void debugRing() {
        System.out.println("Hash Ring:");
        for (var entry : ring.entrySet()) {
            System.out.println("Hash: " + entry.getKey() + " -> Node: " + entry.getValue().getNodeId());
        }
    }
}
