package Hashing;

public class p4 {
    static class Node{
        int value;
        p3.Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    static class LinkedList{
        p3.Node head;
        int size = 0;
        public LinkedList(){}
        public void add(int value){
            p3.Node node = new p3.Node(value);
            if (head == null){
                head = node;
                size++;
                return;
            }
            node.next = head;
            head = node;
            size++;
        }
        public void display(){
            p3.Node curr = head;
            while (curr!=null){
                System.out.printf(curr.value+"->");
                curr = curr.next;
            }
            System.out.println(" null");
        }
        public void sorting(){
            int[] array = new int[size];
            p3.Node curr = head;
            for (int i = 0; i < size; i++) {
                array[i] = curr.value;
                curr = curr.next;
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = i+1; j < array.length; j++) {
                    if (array[j]<array[i]){
                        int temp = array[i];
                        array[i] = array[j];
                        array[j]=temp;
                    }
                }
            }
            curr = head;
            int count = 0;
            while (curr!=null){
                curr.value= array[count];
                count++;
                curr = curr.next;
            }
        }
    }
    static int HashFunction(int value){
        if (value<0){
            return (value*-1)+4;
        }
        return value%10;
    }
    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        LinkedList[] map  = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            map[i] = new LinkedList();
        }
        for (int i = 0; i < arr.length; i++) {
            int bi = HashFunction(arr[i]);
            map[bi].add(arr[i]);
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                int x = -arr[i]-arr[j];
                int xi = HashFunction(x);
                if (map[xi].head != null) {
                    if (map[xi].head.value == x) {
                        count++;
                    }
                }
            }
            break;
        }
        count/=2;
        System.out.println(count);
    }
}
