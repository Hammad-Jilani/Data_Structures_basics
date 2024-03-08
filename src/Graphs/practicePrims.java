package Graphs;

import java.util.Arrays;

public class practicePrims {
    static class Edge{
        int src,des,weightage;
        Edge next;

        public Edge(int src, int des,int weightage) {
            this.src = src;
            this.des = des;
            this.weightage = weightage;
        }
    }
    static class LinkedList{
        Edge head;
        int size;
        public void add(Edge e){
            if (head ==null){
                head=e;
                size+=1;
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
            if (head!=null) {
                head = head.next;
            }
            return temp;
        }
    }
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
        public void enqueue(Node node){
            if (head ==null){
                head=node;
                size+=1;
                return;
            }
            Node temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            size++;
            temp.next = node;
        }
        public Node dequeue(){
            Node temp = head;
            if (head!=null) {
                head = head.next;
            }
            size--;
            return temp;
        }
    }
    static void bfs(LinkedList[] graph,int src){
        boolean[] visited = new boolean[graph.length];
        queue q = new queue();
        q.enqueue(new Node(0));
        while (q.size!=0){
            int curr = q.dequeue().value;
            if (!visited[curr]){
                visited[curr] = true;
                System.out.printf(curr+" ");
                for (int i = 0; i < graph[curr].size; i++) {
                    Edge e = graph[curr].get();
                    q.enqueue(new Node(e.des));
                }
            }
        }
    }
    static int[] dijkstraAlgorithm(LinkedList[] graph,int S){
        int[] distance = new int[graph.length];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[S] = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size; j++) {
                Edge temp = graph[i].get();
                if (distance[temp.src]!=Integer.MAX_VALUE && distance[temp.src]+temp.weightage<distance[temp.des]){
                    distance[temp.des]=distance[temp.src]+ temp.weightage;
                }
            }
        }
        return distance;
    }
    public static int prims(LinkedList[] graph){
        boolean[] inMST = new boolean[graph.length];
        int[] key = new int[graph.length];
        int[] parent = new int[graph.length];
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0] = 0;
        int totalWeight = 0;
        parent[0] = -1;
        for (int i = 0; i < graph.length; i++) {
            int u = MinKey(key,inMST);
            if(u!=-1) {
                inMST[u] = true;
                Edge temp = graph[u].head;
                while (temp != null) {
                    int v = temp.des;
                    if (!inMST[v] && key[v] > temp.weightage) {
                        parent[v] = u;
                        key[v] = temp.weightage;
                    }
                    temp = temp.next;
                }
            }
        }
        for (int i = 1; i < graph.length; i++) {
            if (key[i]==Integer.MAX_VALUE){
                continue;
            }
            totalWeight+=key[i];
        }
        for (int i = 1; i < graph.length ; i++) {
            if (key[i]==Integer.MAX_VALUE){
                continue;
            }
            System.out.println(parent[i]+"-"+i+" "+key[i]);
        }
        return totalWeight;
    }

    private static int MinKey(int[] key, boolean[] inMST) {
        int min=Integer.MAX_VALUE,minIndex = -1;
        for (int i = 0; i < key.length; i++) {
            if (!inMST[i] && key[i]<min){
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void dfs(LinkedList[] graph,boolean[] visited,int src){
        System.out.printf(src+" ");
        visited[src] = true;
        for (int i = 0; i < graph[src].size; i++) {
            Edge e = graph[src].get();
            if (!visited[e.des]){
                dfs(graph,visited,e.des);
            }
        }
    }
    public static void main(String[] args) {
        LinkedList graph[] = new LinkedList[6];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList();
        }
        graph[1].add(new Edge(1,0, 5));
        graph[1].add(new Edge(1,2, 3));
        graph[2].add(new Edge(2,1, 3));
        graph[0].add(new Edge(0,2, 1));
        graph[2].add(new Edge(2,0, 1));
        System.out.println(prims(graph));
    }
}
