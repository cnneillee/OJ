package cn.neillee.topReview;

import java.util.HashMap;

/**
 * @author Neil
 * @date 2017/9/10.
 */
public class LRUCache {
    class Node {
        int val;
        int time;

        public Node(int val, int time) {
            this.val = val;
            this.time = time;
        }
    }

    int capacity = 0;
    int time = 0;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        time++;
        Node node = map.get(key);
        if (node == null) return -1;
        if (time - node.time >= capacity + 1) {// evicts
            map.remove(key);
            return -1;
        } else {
            return node.val;
        }
    }

    public void put(int key, int value) {
        time++;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.time = time;
        } else {
            map.put(key, new Node(value, time));
        }
    }
}