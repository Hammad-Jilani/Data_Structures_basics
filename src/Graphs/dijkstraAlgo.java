package Graphs;

import java.util.Arrays;

public class dijkstraAlgo {
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
         public void enqueue(Node node){
             if (head==null){
                 head = node;
                 size++;
                 return;
             }
             Node temp = head;
             while (temp.next!=null){
                 temp=temp.next;
             }
             size++;
             temp.next = node;
         }
         public int dequeue(){
             size--;
             Node temp = head;
             head= head.next;
             return temp.value;
         }
     }
     static class Edge{
         int src,des,weight;
         char s,d;
         Edge next;


         public Edge(int src, int des, int weight, char s, char d) {
             this.src = src;
             this.des = des;
             this.weight = weight;
             this.s = s;
             this.d = d;
         }
     }
     static class linkedList{
         Edge head;
         int size;
         int start =0;
         public void add(Edge e){
             if (head==null){
                 head = e;
                 size++;
                 return;
             }
             Edge temp = head;
             while (temp.next!=null){
                 temp = temp.next;
             }
             temp.next = e;
             size++;
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
             for (int j = 0; j < i-1; j++) {
                 temp=temp.next;
             }
             return temp;
         }
     }

     public static void createGraph(linkedList[] graph){
         for (int i = 0; i < graph.length; i++) {
             graph[i] = new linkedList();
         }
         graph[0].add(new Edge(0,1,1,'s','a'));
         graph[0].add(new Edge(0,2,5,'s','b'));

         graph[1].add(new Edge(1,2,2,'a','b'));
         graph[1].add(new Edge(1,3,2,'a','c'));
         graph[1].add(new Edge(1,4,1,'a','d'));

         graph[2].add(new Edge(2,4,2,'b','d'));

         graph[3].add(new Edge(3,4,3,'c','d'));
         graph[3].add(new Edge(3,5,1,'c','e'));

         graph[4].add(new Edge(4,5,2,'d','e'));

//         graph[5].add(new Edge(5,5,0));
//         graph[0].add(new Edge(0,1,5));
//         graph[0].add(new Edge(0,2,1));
//
//         graph[1].add(new Edge(1,0,5));
//         graph[1].add(new Edge(1,2,3));
//
//         graph[2].add(new Edge(2,0,1));
//         graph[2].add(new Edge(2,1,3));
     }
     public static void neighbour(linkedList[] graph,int src){
         for (int i = 0; i < graph[src].size; i++) {
             System.out.printf(graph[src].get().des+" ");
         }
     }
     static void bfs(linkedList[] graph){
         Queue q = new Queue();
         boolean[] visited = new boolean[graph.length];
         q.enqueue(new Node(0));
         while (q.size!=0){
             int curr = q.dequeue();
             if (!visited[curr]){
                 System.out.printf(curr+" ");
                 visited[curr] = true;
                 for (int i = 0; i < graph[curr].size; i++) {
                     Edge e = graph[curr].get();
                     q.enqueue(new Node(e.des));
                 }
             }
         }
     }
     public static int[] dijkstra(linkedList[] graph,int S,int edge,int vertices){
         int[] distance = new int[graph.length];
         boolean[] visited = new boolean[graph.length];
         Arrays.fill(distance, Integer.MAX_VALUE);
         distance[S] = 0;
         for (int i = 0; i < graph.length; i++) {
             for (int j = 0; j < graph[i].size; j++) {
                 Edge e = graph[i].get();
                 visited[e.src] =true;
                 if (e!=null) {
                     int u = e.src;
                     int v = e.des;
                     int weight = e.weight;
                     if (!visited[e.des] && distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                         distance[v] = distance[u] + weight;
                     }
                 }
             }
         }
         return distance;
     }

    public static void main(String[] args) {
        linkedList[] graph = new linkedList[6];
        createGraph(graph);
        int[] result = dijkstra(graph,0,9, graph.length);
        for (int i = 0; i < result.length; i++) {
            System.out.printf(result[i]+" ");
        }
    }
}
