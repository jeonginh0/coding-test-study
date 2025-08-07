package beakjun.hashmap_only_array;

public class MySolution {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));  // 1
        System.out.println(myHashMap.get(3));  // -1

        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));  // 1

        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));  // -1
    }
}

class MyHashMap {
    private final int[] map;

    public MyHashMap() {
        map = new int[1_000_001];
        // 모든 값을 -1로 초기화 (key가 없음을 의미)
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}