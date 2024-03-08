package Graphs;

public class practice2 {
    static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    static class queue{
        Node head;
        int size;
        public void enqueue(int value){
            Node node = new Node(value);
            if (head ==null){
                head = node;
                size++;
                return;
            }
            Node temp = head;
            for (int i = 0; i < size-1; i++) {
                temp = temp.next;
            }
            temp.next = node;
            size++;
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
    static class Edge{
        int src,des;
        Edge next;
        Edge(int src,int des){
            this.src = src;
            this.des = des;
        }
    }
    static class linkedList{
        Edge head;
        int size;
        public void add(Edge e){
            if (head==null){
                head=e;
                size++;
                return;
            }
            if (size==1){
                head.next = e;
                size++;
                return;
            }
            if (size>1){
                Edge temp = head;
                while (temp.next!=null){
                    temp=temp.next;
                }
                size++;
                temp.next = e;
            }
        }
        public Edge get(){
            Edge temp =head;
            if (head!=null) {
                head = head.next;
            }
            return temp;
        }

        public Edge get(int i) {
            Edge temp = head;
            for (int j = 0; j < i; j++) {
                temp=temp.next;
            }
            return temp;
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
    private static void printNeighbours(linkedList[] graph, int i) {
        for (int j = 0; j < graph[i].size; j++) {
            System.out.printf(graph[i].get().des+" ");
        }
    }
    private static void bfs(linkedList[] graph){
        boolean[] visited = new boolean[graph.length];
        queue q = new queue();
        q.enqueue(0);
        while (q.size!=0){
            int curr= q.dequeue();
            if (!visited[curr]){
                System.out.print(curr+" ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size; i++) {
                    Edge e = graph[curr].get();
                    if (e!=null) {
                        q.enqueue(e.des);
                    }
                }
            }
        }
    }
    public static void dfs(linkedList[] graph,int src,boolean[] visited){
//         = new boolean[graph.length];
        System.out.printf(src+" ");
        visited[src] = true;
        for (int i = 0; i < graph[src].size; i++) {
            Edge e = graph[src].get(i);
            if (e!=null){
                if (!visited[e.des]){
                    dfs(graph,e.des,visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        linkedList[] graph = new linkedList[7];
        createGraph(graph);
//        printNeighbours(graph,0);
        bfs(graph);
//        dfs(graph,0,new boolean[graph.length]);
    }

}
