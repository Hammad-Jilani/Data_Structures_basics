package Graphs;
public class task3 {
    static class Edge{
        int src,des;
        Edge next;
        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }
    static class linkedList{
        Edge head;
        int size=0;
        public void add(Edge e){
            if (head == null){
                head=e;
                size++;
                return;
            }
            Edge temp = head;
            size++;
            for (int i = 0; i < size-2; i++) {
                temp = temp.next;
            }

            temp.next = e;
        }
        public Edge get(){
            if (size==1){
                return head;
            }
            else{
                Edge e = head;
                if (head!=null) {
                    head = head.next;
                }
                return e;
            }
        }
    }
    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    static class Queue{
        Node head;
        int size;
        public void add(int value){
            Node e = new Node(value);
            if (head == null){
                head=e;
                size++;
                return;
            }
            Node temp = head;
            for (int i = 0; i < size-1; i++) {
                temp = temp.next;
            }
            size++;
            temp.next = e;
        }
        public int dequeue(){
            if (size==1){
                size--;
                Node temp = head;
                head = null;
                return temp.value;
            }
            else{
                Node e = head;
                head = head.next;
                size--;
                return e.value;
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        linkedList[] graph = new linkedList[V];
        createGraph(graph,5);
        list(graph,V);
    }
    static void list(linkedList[] graphs,int V){
        for (int i = 0; i <V ; i++) {
            for (int j = 0; j < graphs[i].size; j++) {
                Edge e = graphs[i].get();
                if (e!=null){
                    System.out.print(e.des+" ");
                }
            }
            System.out.println();
        }
    }

    private static void createGraph(linkedList[] graph, int v) {
        for (int i = 0; i < v; i++) {
            graph[i] = new linkedList();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,3));
    }
}
