package Hashing;

public class p2 {
    static class node{
        int value;
        node next;

        public node(int value) {
            this.value = value;
        }
    }
    static class linkedList{
        node head;
        int size = 0;
        public linkedList(){}
        public void add(int value){
            node node = new node(value);
            if (head == null){
                head = node;
                size++;
                return;
            }
            node.next = head;
            head = node;
            size++;
        }
        public node getKey(int value) {
            node curr = head;
            while (curr!=null){
                if (value== curr.value){
                    return curr;
                }
                curr = curr.next;
            }
            return null;
        }
        public node get(int index){
            node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr;
        }

        public void display() {
            node node = head;
            while (node!=null){
                System.out.printf(node.value+"->");
                node = node.next;
            }
            System.out.println("null");
        }
        public boolean isContain(int element) {
            node node = head;
            while (node!=null){
                if (node.value == element){
                    return true;
                }
                node = node.next;
            }
            return false;
        }
    }
    static int hashFunction(int index){
        int bi = (index%10);
        return bi;
    }
    public static void main(String[] args) {
        linkedList[] list = new linkedList[10];
        int[] array = {1,5,7,1};

//        final int k = 6;
        for (int i = 0; i < 10; i++) {
            list[i] = new linkedList();
        }

        for (int i = 0; i < 4; i++) {
            int bi = hashFunction(array[i]);
            if (list[bi].head==null){
                list[bi].add(array[i]);
            }
            else
                list[bi+1].add(array[i]);
        }
//        for (int i = 0; i < 10; i++) {
//            if (list[i].head!=null) {
//                list[i].display();
//            }
//        }
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int bi = hashFunction(array[i]);
            int c = 6 - array[i];
            if (c>0) {
                int ci = hashFunction(c);
                if (list[ci].head!=null) {
                    if (list[ci].head.value == c) {
                        count++;
                    }
                }
                if (list[ci].head!=null && list[ci+1].head!=null) {
                    if (list[ci].head.value == list[ci + 1].head.value) {
                        count--;
                    }
                }
            }
        }
        System.out.println("Total pairs "+count);
    }
}
