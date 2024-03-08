package Graphs;

import java.util.Arrays;

public class cycleDetectionDirectedGraph {
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
                head=e;
                size++;
                return;
            }
            Edge curr = head;
            while (curr.next!=null){
                curr = curr.next;
            }
            curr.next = e;
            size++;
        }
        public Edge get(){
            Edge e = head;
            head = head.next;
            return e;
        }
    }
    public static int[] dijkstra(LinkedList[] graph,int src){
        int[] distance = new int[graph.length];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;
        for (int i = 0; i < graph[src].size; i++) {
            for (int j = 0; j < graph[i].size; j++) {
                Edge e = graph[i].get();
                int u = e.src;
                int v = e.des;
                int weight = e.weight;
                if (distance[u]!=Integer.MAX_VALUE && distance[u] + weight<distance[v]){
                    distance[v] = weight+distance[u];
                }
            }
        }
        return distance;
    }
    public static boolean cycleDetection(LinkedList[] graph,int curr,boolean[] visited,boolean[] inStack ){
        visited[curr] = true;
        inStack[curr] = true;
        for (int i = 0; i < graph[curr].size; i++) {
            Edge  e = graph[curr].get();
            if (inStack[e.des]){
                return true;
            }else if(!visited[e.des]){
                if (cycleDetection(graph, e.des,visited,inStack))
                    return true;
            }
        }
        inStack[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        LinkedList[] graph = new LinkedList[4];
        for (int i = 0; i < 4; i++)
            graph[i] = new LinkedList();
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));
        System.out.printf(cycleDetection(graph,0,new boolean[graph.length],new boolean[graph.length])+" ");

    }
}
