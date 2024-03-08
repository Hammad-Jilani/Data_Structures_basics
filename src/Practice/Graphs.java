package Practice;

import java.util.Arrays;

public class Graphs {
    static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    static class queue{
        Node head;
        int size;
        public void enqueue(int value){
            Node node = new Node(value);
            if (head==null){
                head = node;
                size++;
                return;
            }
            Node temp = head;
            while (temp.next!=null){
                temp=temp.next;
            }
            size+=1;
            temp.next = node;
        }
        public int dequeue(){
            Node temp = head;
            if (head!=null){
                head = head.next;
            }
            size--;
            return temp.value;
        }
    }
    static class Edge{
        int src,des,weight;
        Edge next;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }

        public Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
    }
    static class LinkedList{
        Edge head;
        int size;
        public void add(Edge e){
            if (head==null){
                head= e;
                size++;
                return;
            }
            Edge temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            size++;
            temp.next = e;
        }
        public Edge get(){
            Edge temp = head;
            if (head!=null){
                head = head.next;
            }
            return temp;
        }
    }
    public static int prims(LinkedList[] graph){
        boolean[] inMST = new boolean[graph.length];
        int[] key = new int[graph.length];
        int[] parent = new int[graph.length];
        Arrays.fill(key,Integer.MAX_VALUE);

        key[0] = 0;
        parent[0] = -1;
        int totalWeight = 0;
        for (int i = 0; i < graph.length; i++) {
            int  u = minKey(key,inMST);
//            if (u!=-1){
                inMST[u] = true;
                Edge e = graph[u].get();
                while (e!=null){
                    int v = e.des;
                    if (!inMST[v] && e.weight<key[v]){
                        key[v] = e.weight;
                        parent[v] = u;
                    }
                    e = e.next;
                }
//            }
        }
        for (int i = 1; i < key.length; i++) {
            if (key[i]!=Integer.MAX_VALUE){
                totalWeight+=key[i];
            }
        }
        for (int i = 1; i < key.length; i++) {
            if (key[i]!=Integer.MAX_VALUE)
                System.out.println(parent[i]+"-"+i+" "+key[i]);
        }
        return totalWeight;
    }
    public static int minKey(int[] key,boolean[] inMST){
        int minIndex = 0,min=Integer.MAX_VALUE;
        for (int i = 0; i < key.length; i++) {
            if (!inMST[i] && min>key[i]){
                min=key[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
    public static void dfs(LinkedList[] graph,int src,boolean[] visited){
        visited[src] = true;
        System.out.printf(src+" ");
        for (int i = 0; i < graph[src].size; i++) {
            Edge e = graph[i].get();
            if (e!=null){
                if (!visited[e.des]){
                    dfs(graph,e.des,visited);
                }
            }
        }
    }
    public static int[] dijkstra(LinkedList[] graph,int src){
        int[] distance = new int[graph.length];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size; j++) {
                Edge e = graph[i].get();
                if (e != null) {
                    int u = e.src;
                    int v = e.des;
                    int weight = e.weight;
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                        distance[v] = distance[u] + weight;
                    }
                }
            }
        }
        return distance;
    }
    public static void bfs(LinkedList[] graph,int src){
        queue q = new queue();
        q.enqueue(0);
        boolean[] visited = new boolean[graph.length];
        while (q.size!=0){
            int curr = q.dequeue();
            if (!visited[curr]){
                System.out.printf(curr+" ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size; i++) {
                    Edge e = graph[curr].get();
                    q.enqueue(e.des);
                }
            }
        }
    }
    public static void main(String[] args) {
        LinkedList graph[] = new LinkedList[6];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList();
        }
//        graph[0].add(new Edge(0,1,1));
//        graph[0].add(new Edge(0,2,5));
//
//        graph[1].add(new Edge(1,2,2));
//        graph[1].add(new Edge(1,3,2));
//        graph[1].add(new Edge(1,4,1));
//
//        graph[2].add(new Edge(2,4,2));
//
//        graph[3].add(new Edge(3,4,3));
//        graph[3].add(new Edge(3,5,1));
//
//        graph[4].add(new Edge(4,5,2));

        graph[1].add(new Edge(1,0, 5));
        graph[1].add(new Edge(1,2, 3));
        graph[2].add(new Edge(2,1, 3));
        graph[0].add(new Edge(0,2, 1));
        graph[2].add(new Edge(2,0, 1));
//        dfs(graph,0,new boolean[graph.length]);
        System.out.println(prims(graph));
    }
}
