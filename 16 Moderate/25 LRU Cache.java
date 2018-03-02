public class LRUCache { 
    public class DLNode{
        int key;
        int value;
        DLNode pre;
        DLNode post;
    }
    Map<Integer, DLNode> cache;
    DLNode head;
    DLNode tail;
    int count;
    int capacity;
    
    //Constructor for LRU Cache
    public LRUCache(int capacity) {
        cache = new HashMap();
        this.capacity = capacity;
        this.count = 0;
        head = new DLNode();
        tail = new DLNode();
        head.pre = null;
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }
    //4 Helper methods
    public DLNode poptail(){
        DLNode node = tail.pre;
        remove(node);
        return node;
    }
    public void refresh(DLNode node){
        remove(node);
        insert(node);
    }
    public void remove(DLNode node){
        DLNode pre = node.pre;
        DLNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }
    //Insert just after the head
    public void insert(DLNode node){
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }
    //Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    public int get(int key) {
        DLNode ret = cache.get(key);
        if(ret==null) return -1;
        refresh(ret);
        return ret.value;
    }
    //Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
    public void put(int key, int value) {
        DLNode ret = cache.get(key);
        if(ret==null){
            DLNode node = new DLNode();
            node.key = key;
            node.value = value;
            cache.put(key,node);
            insert(node);
            count++;
            if(count>capacity){
                DLNode un = poptail();
                cache.remove(un.key);
                count--;
            }
        }
        else{
            ret.value = value;
            refresh(ret);
        }
    }
}
