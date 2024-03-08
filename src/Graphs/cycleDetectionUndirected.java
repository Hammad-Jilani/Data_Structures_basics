package Graphs;

public class cycleDetectionUndirected {
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
    static boolean cycle(LinkedList[] graph,boolean[] visited,int curr,int parent){
        visited[curr]=true;
        for (int i = 0; i < graph[curr].size; i++) {
            Edge e = graph[curr].get();
            if (parent!=e.des && visited[e.des]){
                return true;
            }
            else if (!visited[e.des]){
               if(cycle(graph,visited,e.des,curr))
                   return true;
            }
        }
        return false;
    }
}
