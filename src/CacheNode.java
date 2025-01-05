import java.util.HashMap;
import java.util.Map;

public class CacheNode {
    private final String nodeId;
    private final Map<String, String> cache;

    public CacheNode(String nodeId) {
        this.nodeId = nodeId;
        this.cache = new HashMap<>();
    }

    public String getNodeId() {
        return nodeId;
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public Map<String, String> getCacheContents() {
        return cache;
    }

    @Override
    public String toString() {
        return nodeId;
    }
}
