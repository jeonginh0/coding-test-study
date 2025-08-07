package beakjun.hashmap_only_array;

public class SeniorSolution {
}

class SeniorHashMap {
    private static final int SIZE = 10000;
    private Node[] buckets;

    private static class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public SeniorHashMap() {
        buckets = new Node[SIZE];
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int idx = getIndex(key);
        if (buckets[idx] == null) {
            buckets[idx] = new Node(key, value);
            return;
        }

        Node curr = buckets[idx];
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        prev.next = new Node(key, value);
    }

    public int get(int key) {
        int idx = getIndex(key);
        Node curr = buckets[idx];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = getIndex(key);
        Node curr = buckets[idx];
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[idx] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}