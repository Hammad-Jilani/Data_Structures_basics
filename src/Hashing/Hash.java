package Hashing;

public class Hash {
    static class hashMap<K,V>{
        private static class MapNode<K,V>{
            K key;
            V value;
            MapNode<K,V> next;
            public MapNode(K key, V value) {
                this.key = key;
                this.value = value;
                next = null;
            }
        }
        static class linkedList<K,V>{
            MapNode head;
            int size=0;
            public void add(K key,V value){
                if (head==null){
                    MapNode node = new MapNode(key,value);
                    head = node;
                    size++;
                    return;
                }
                MapNode node = new MapNode(key,value);
                node.next = head;
                head = node;
                size++;
            }
            public MapNode<K,V> get(int index){
                MapNode curr = head;
                for (int i = 0; i < index; i++) {
                    if (curr!=null){
                        curr = curr.next;
                    }
                }
                return curr;
            }
            public MapNode remove(int di) {
                MapNode node = head;
                for (int i = 0; i < di-1; i++) {
                    node = node.next;
                }
                MapNode delete = node.next;
                node.next = node.next.next;
                return delete;
            }
        }
        private int n;
        private final int N;
        private linkedList[] bucket;
        public hashMap(){
            this.N = 4;
            this.bucket = new linkedList[4];
            for (int i = 0; i < 4; i++) {
                this.bucket[i] = new linkedList();
            }
//            this.buckets = new LinkedList[4];
        }
        public void put(K key,V value){
            int bucketIndex = hashFunction(key);
            int di = searchInLinkedList(key,bucketIndex);
            if (di == -1){
                bucket[bucketIndex].add(key,value);
                n++;
            }else{
                MapNode node = bucket[bucketIndex].get(di);
                node.value = value;
            }
            double lambda = (double) n/N;
            if (lambda>2){
//                rehashing
                rehash();
            }
        }

        private void rehash() {
            linkedList[] oldBucket = bucket;
            bucket= new linkedList[N*2];
            for (int i = 0; i < N*2; i++) {
                bucket[i] = new linkedList();
            }
            for (int i = 0; i < oldBucket.length ; i++) {
                linkedList ll = oldBucket[i];
                for (int j = 0; j <ll.size ; j++) {
                    MapNode node = ll.get(j);
                    put((K)node.key, (V) node.value);
                }
            }
        }
        public void display(){
            for (int i=0;i< bucket.length;i++) {
                linkedList l = bucket[i];
                for (int j = 0; j < l.size; j++) {
                    System.out.printf("Key "+l.get(j).key + " Value "+l.get(j).value+"->");
                }
                System.out.print("null ");
                System.out.println();
            }
        }
        private int searchInLinkedList(K key, int bucketIndex) {
            linkedList ll = bucket[bucketIndex];
            int di = 0;
            for (int i = 0; i < ll.size; i++) {
                if (ll.get(i).key==key) {
                    return i;
                }
            }
            return -1;
        }
        private int hashFunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi%N);
        }
        public V get(K key){
            int bucketIndex = hashFunction(key);
            int di = searchInLinkedList(key,bucketIndex);
            if (di == -1){
                return null;
            }else{
                MapNode node = bucket[bucketIndex].get(di);
                return (V) node.value;
            }
        }
        public boolean containsKey(K key){
            int bucketIndex = hashFunction(key);
            int di = searchInLinkedList(key,bucketIndex);
            return di != -1;
        }
        public V remove(K key){
            int bucketIndex = hashFunction(key);
            int di = searchInLinkedList(key,bucketIndex);
            if (di == -1){
                return null;
            }else{
                MapNode node = bucket[bucketIndex].remove(di);
                return (V) node.value;
            }
        }
    }

    public static void main(String[] args) {
        hashMap<String,Integer> map = new hashMap<>();
        map.put("India",142);
        map.put("China",141);
        map.put("USA",33);
        map.put("Pakistan",24);
        map.put("Iran",8);
        System.out.println(map.get("India"));
        map.display();
    }
}
