package Hashing;
public class Main {
    static class LinkedList {
        HashNode head;
        static class HashNode {
            int value;
            HashNode next;
            public HashNode( int value) {
                this.value = value;
                this.next = null;
            }
        }
        public void add(int value){
            if (head == null){
                head = new HashNode(value);
                return;
            }
            HashNode hashNode = new HashNode(value);
            HashNode curr = head;
            while (curr.next!=null){
                curr=curr.next;
            }
            curr.next =hashNode;
        }
        public void print(){
            HashNode curr = head;
            while (curr!=null){
                System.out.printf(curr.value+"->");
                curr = curr.next;
            }
        }
        public void sorting(){

        }
    }
    public static void main(String[] args) {
        int array[] = {13,7,12,23,22,26,3,2,9,6,11};
        LinkedList[] list = new LinkedList[10];
        for (int i = 0; i <array.length ; i++) {
            int j = array[i]%10;
            if (list[j]==null) {
                list[j]= new LinkedList();
            }
            list[j].add(array[i]);
        }
        for (int i = 0; i < 10; i++) {
            if (list[i]!=null){
                System.out.printf(i+" = ");
                list[i].print();
                System.out.println();

            }
        }
    }
}