class LRUCache {
    class Node{
            int key, value;
            Node prev, next;

            Node(int key, int value){
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final Map<Integer, Node> map = new HashMap<>();

        private final Node head = new Node(-1,-1);
        private final Node tail = new Node(-1,-1);

         public LRUCache(int capacity) {
     
            this.capacity = capacity;

            head.next = tail;
            tail.prev = head;
        }

        private void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    

        private void addFirst(Node node){
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }


    
    
    public int get(int key) {
        Node node = map.get(key);

        if(node == null) return -1;

        remove(node);
        addFirst(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        //update an existing key
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;

            remove(node);
            addFirst(node);
            return;
        }

        //Evict the least recently used key if full
        if(map.size() == capacity){
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }

        //Insert the new key as most recently used
        Node node = new Node(key,value);

        map.put(key, node);
        addFirst(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */