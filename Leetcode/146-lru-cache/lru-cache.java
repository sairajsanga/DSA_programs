class LRUCache {
    LinkedHashMap<Integer,Integer> map;
    int capacity;
    public LRUCache(int capacity) {
       this.map=new LinkedHashMap<>(capacity,0.75f,true);
       this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
       map.put(key,value);
       if (map.size() > capacity) {
            map.remove(map.keySet().iterator().next());
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */