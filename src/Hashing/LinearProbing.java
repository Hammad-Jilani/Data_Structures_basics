package Hashing;

import java.util.Arrays;

public class LinearProbing {
    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    static class linkedList{
        Node head;
        int size;
        public void add(int value){
            Node node = new Node(value);
            if (head ==null){
                head = node;
                size++;
                return;
            }
            node.next = head;
            head = node;
            size++;
        }
        public Node get(int value){
            Node curr = head;
            while (curr!=null){
                if (curr.value == value){
                    return curr;
                }
                curr = curr.next;
            }
            return null;
        }
    }
    static class hashMap{
        int[] map;
        private int BucketSize,hashFactor;
        public hashMap(int size){
            map = new int[size];
            Arrays.fill(map,-1);
            this.BucketSize = size;
        }
        public int hashFunction(int value){
            int cycle = 0;
            int key = value%BucketSize;
            if (map[key]==-1 || map[key]==value){
                return key;
            }else{
                while (map[key + hashFactor] != -1 && key + hashFactor < BucketSize) {
                    if (cycle<=1) {
                        hashFactor++;
                        if (key+hashFactor > BucketSize) {
                            key = hashFactor = 0;
                            cycle++;
                        }
                    }
                    else{
                        break;
                    }
                }
                int temp = hashFactor;
                hashFactor=0;
                return key + temp;
            }
        }
        public void addToMap(int value){
            int bi =hashFunction(value);
            map[bi] = value;
        }
        public int search(int value){
            int bi = hashFunction(value);
            if (map[bi]==value){
                return bi;
            }
            else{
                return -1;
            }
        }
        public int delete(int value){
            int bi = hashFunction(value);
            map[bi] = -1;
            return bi;
        }
        public void display(){
            for (int i = 0; i < BucketSize; i++) {
                System.out.printf(map[i]+" ");
            }
        }
    }
    public static void main(String[] args) {
        int[] value = {3, 2, 9, 6, 11, 13, 7, 12, 23, 22, 26};
        hashMap map = new hashMap(value.length);
        for (int i = 0; i < value.length; i++) {
            map.addToMap(value[i]);
        }
        System.out.println(map.search(9));
        map.display();
    }
}
