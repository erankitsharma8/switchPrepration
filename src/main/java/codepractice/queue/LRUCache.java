package codepractice.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int capacity;

    // Stores key-value pairs
    private Map<Integer, Integer> cacheMap;

    // Stores keys in the order of access
    private LinkedList<Integer> lruList;

    // Constructor to initialize the cache with a given
    // capacity
    LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.lruList = new LinkedList<>();
    }

    // Function to get the value for a given key
    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }

        // Move the accessed key to the front (most recently
        // used position)
        lruList.remove(Integer.valueOf(key));

        // Add key to the front
        lruList.addFirst(key);

        return cacheMap.get(key);
    }

    // Function to put a key-value pair into the cache
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {

            // Update the value
            cacheMap.put(key, value);

            // Move the accessed key to the front
            lruList.remove(Integer.valueOf(key));

        }
        else {

            // Add new key-value pair
            if (cacheMap.size() >= capacity) {

                // Remove the least recently used item
                int leastUsedKey = lruList.removeLast();
                cacheMap.remove(leastUsedKey);
            }
            cacheMap.put(key, value);
        }
        // Add the key to the front (most recently used
        // position)
        lruList.addFirst(key);
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println( cache.get(4));
    }
}
