package Hashing;

import java.util.Scanner;

public class p3 {
    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    static class LinkedList{
        Node head;
        int size = 0;
        public LinkedList(){}
        public void add(int value){
            Node node = new Node(value);
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
            Node curr = head;
            while (curr!=null){
                System.out.printf(curr.value+"->");
                curr = curr.next;
            }
            System.out.println(" null");
        }
        public void sorting(){
            int[] array = new int[size];
            Node curr = head;
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
        return value%10;
    }
    public static void main(String[] args) {
        LinkedList map[] = new LinkedList[10];
        int array[] = {3,2,9,6,11,13,7,12,23,22,26};
        for (int i = 0; i < 10; i++) {
            map[i] = new LinkedList();
        }
        for (int i = 0; i < array.length; i++) {
            int bi = HashFunction(array[i]);
            map[bi].add(array[i]);
        }
        System.out.println("Enter the index of element");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        int bi = HashFunction(array[index]);
        map[bi].sorting();
        map[bi].display();
    }
}
