package LinkedList;

public class task1 {
    static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    static class SinglyList{
        Node head;
        public void add(int value){
            if (head==null){
                Node node = new Node(value);
                head = node;
                return;
            }
            Node node = new Node(value);
            node.next = head;
            head = node;
        }

    }
}
