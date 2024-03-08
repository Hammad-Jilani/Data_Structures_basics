package Hashing;

public class separateChaining {
    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    static class Linkedlist{
        Node head;
        int size;
        public void add(int value){
            Node node = new Node(value);
            if (head == null){
                head=node;
                size++;
                return;
            }
            size++;
            node.next = head;
            head=node;
        }
        public Node get(int index){
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr;
        }
        public Node search(int value){
            Node curr = head;
            while (curr!=null){
                if (curr.value == value){
                    return curr;
                }
                curr=curr.next;
            }
            return null;
        }

        public Node delete(int value) {
            Node curr =head;
            int i =0;
            while (curr!=null){
                if (curr.value == value){
                    deleteNode(i);
                    return curr;
                }
                curr = curr.next;
                i++;
            }
            return null;
        }

        private void deleteNode(int i) {
            Node curr = head;
            for (int j = 0; j < i-1; j++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
    }
    static class HashMap{
        Linkedlist[] map;
        int bucketSize,currSize;
        public Node delete(int value){
            int bi = hashFunction(value);
            Node delete = map[bi].delete(value);
            return delete;
        }
        public Node search(int value){
            int bi = hashFunction(value);
            Node search = map[bi].search(value);
            return search;
        }
        public HashMap(int bucketSize){
            map = new Linkedlist[bucketSize];
            for (int i = 0; i < bucketSize; i++) {
                map[i] = new Linkedlist();
            }
            this.bucketSize = bucketSize;
            this.currSize = 0;
        }
        public void display(){
            for (int i = 0; i < bucketSize; i++) {
                for (int j = 0; j < map[i].size; j++) {
                    if (map[i].get(j)!=null) {
                        System.out.print(map[i].get(j).value+"->");
                    }
                }
                System.out.println("null");
            }
        }
    }
    static int hashFunction(int value){
        return Math.abs(value%10);
    }
    public static void main(String[] args) {
        int[] value = {3, 2, 9, 6, 11, 13, 7, 12, 23, 22, 26};
        HashMap hashmap = new HashMap(value.length);
        for (int i = 0; i < value.length; i++) {
            int bi = hashFunction(value[i]);
            hashmap.map[bi].add(value[i]);
        }
        Node search = hashmap.search(9);
        System.out.println(search.value);
        hashmap.display();
        System.out.println("Deletion");
        System.out.println(hashmap.delete(3).value);
        hashmap.display();
    }
}
