package Graphs;
public class Main {
    static class Edge{
        int src;
        int des;
        Edge next;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }
    static class linkedList{
        Edge head;
        int size;
        public Edge get(int index){
            Edge temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
        public Edge get(){
            Edge temp = head;
            if (head.next!=null) {
                head = head.next;
            }
            return temp;
        }
        public  void add(Edge e){
            if (head == null){
                head = e;
                size++;
                return;
            }
//            e.next = head;
//            head=e;
//            size++;
            if (size==1){
                head.next = e;
                size++;
                return;
            }
            if (size>1){
                Edge temp = head;
                while (temp.next!=null){
                    temp = temp.next;
                }
                temp.next = e;
                size++;
            }
        }
    }
    static void createGraph(linkedList graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new linkedList();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
//        graph[1].add(new Edge(0,1));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));
//        graph[2].add(new Edge(3,2));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,5));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }
    static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    static class Queue{
        Node head,tail;
        int size=0;
        Queue(){}
        public void enqueue(int value){
            Node node = new Node(value);
            if (head==null){
                head=tail=node;
                size++;
                return;
            }
            size++;
            node.next = head;
            head = node;
        }
        public int deque(){
            Node temp = head;
            for (int i = 0; i < size-1; i++) {
                temp = temp.next;
            }
            Node newTemp = tail;
            tail = temp;
            size--;
            return newTemp.value;
        }
    }
    public static void bfs(linkedList[] graph,int V){
        Queue q = new Queue();
        boolean[] visited = new boolean[V];
        q.enqueue(0);
        while (q.size+1!=0){
            int curr = q.deque();
            if (!visited[curr]){
                System.out.print(curr+" ");
                visited[curr]=true;
                for (int i = 0; i < graph[curr].size; i++) {
                    int e = graph[curr].get().des;
                    q.enqueue(e);
                }
            }
        }
    }
    static void printNeighbours(linkedList graph[],int e){
        for (int i = 0; i < graph[e].size; i++) {
            System.out.println(graph[e].get().des);
        }
    }
    static void dfs(linkedList graph[],int curr,boolean[] visited){
        System.out.printf(curr+" ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size; i++) {
            Edge e = graph[curr].get(i);
            if (e!=null) {
                if (!visited[e.des]) {
                    dfs(graph, e.des, visited);
                }
            }
        }
    }
    public static void main(String[] args) {
        linkedList graph[] = new linkedList[7];
        createGraph(graph);
        printNeighbours(graph,2);
        bfs(graph,7);
        System.out.println();
        boolean[] visited = new boolean[7];
//        dfs(graph,0,visited);
    }
}
