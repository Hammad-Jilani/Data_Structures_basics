package Hashing;

class Node{
    int value,key;
    Node next;
    public Node(int key, int value) {
        this.value = value;
        this.key = key;
    }
}
class linkedList{
    Node head;
    int size = 0;
    public linkedList(){}
    public void add(int key,int value){
        Node node = new Node(key,value);
        if (head == null){
            head = node;
            size++;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }
    public Node get(int index){
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }
    public Node getKey(int key) {
        Node curr = head;
        while (curr!=null){
            if (key == curr.key){
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
    public Node delete(int key) {
        Node curr = head;
        int i = 0;
        while (curr!=null){
            if (key == curr.key){
                deleteNode(i);
                return curr;
            }
            curr = curr.next;
            i++;
        }
        return null;
    }

    private void deleteNode(int i) {
        Node curr= head;
        for (int j = 0; j < i-1; j++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
    }

}
class HashMap{
    linkedList[] buckets;
    int sizeBuckets;
    int NumberOfNodes;
    //        int[] b;
    public HashMap(int capacity){
        this.sizeBuckets = capacity;
//            b = new int[capacity];
        buckets = new linkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new linkedList();
        }
    }
    public int hashFunction(int key){
        return Math.abs(key%sizeBuckets);
    }
    public Node get(int key){
        int bi = hashFunction(key);
        Node node  = buckets[bi].getKey(key);
        return node;
    }
    public void put(int key,int value){
        int bi = hashFunction(key);
        int di = searchInLinkedList(bi,key);
        if (di==-1){
            buckets[bi].add(key,value);
            NumberOfNodes++;
        }else{
            Node node = buckets[bi].get(di);
            node.value = value;
        }
//            double lamda = (double) NumberOfNodes
    }
    public Node delete(int key){
        int bi = hashFunction(key);
        Node node = buckets[bi].delete(key);
        return node;
    }
    private int searchInLinkedList(int bi, int key) {
        linkedList ll = buckets[bi];
        for (int i = 0; i < ll.size; i++) {
            if (ll.get(i).key==key){
                return i;
            }
        }
        return -1;
    }
    public void display(){
        for (int i = 0; i < sizeBuckets; i++) {
            for (int j = 0; j < buckets[i].size; j++) {
                if (buckets[i].get(j)!=null) {
                    System.out.printf(buckets[i].get(j).key + " " + buckets[i].get(j).value + " -> ");
                }
            }
            System.out.println(" null");
        }
    }
}
public class p1 {

    public static void main(String[] args) {
        HashMap map = new HashMap(3);
        map.put(20,199);
        map.put(34,299);
        map.put(45,399);
        map.put(70,499);
        map.put(56,599);
        map.display();
//        part b
        System.out.println(map.get(20).key+" "+map.get(20).value);
        System.out.println(map.delete(34).key+" "+" is deleted");
        map.display();
    }
}
