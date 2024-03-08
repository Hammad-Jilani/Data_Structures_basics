package Graphs;

public class task2 {
    static class Node{
        int des;
        int weight;
        Node next;
        public Node(int des, int weight) {
            this.des = des;
            this.weight = weight;
        }
    }
    static class linkedList{
        Node head;
        public linkedList(){
            this.head=null;
        }
        public void add(int des,int weight){
            Node node = new Node(des,weight);
            if (head==null){
                head=node;
                return;
            }
            node.next = head;
            head=node;
        }
    }
    static class Edge{
        char src,des;
        int weight;
        int srcIndex,desIndex;

        public Edge(char src, char des, int weight, int srcIndex, int desIndex) {
            this.src = src;
            this.des = des;
            this.weight = weight;
            this.srcIndex = srcIndex;
            this.desIndex = desIndex;
        }
    }
    static int[] dijkstraAlgorithm(Edge[] edges,int vertices,int edge,int source){
        linkedList[] graph = new linkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new linkedList();
        }
        for (int i = 0; i < vertices; i++) {
            int src = edges[i].srcIndex;
            int des = edges[i].desIndex;
            int weight = edges[i].weight;
            graph[src].add(des,weight);
        }
        int[] distance = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        for (int i = 0; i < vertices-1; i++) {
            for (int j = 0; j < edge; j++) {
                int u = edges[j].srcIndex;
                int v = edges[j].desIndex;
                int w = edges[j].weight;
                if (distance[u]!=Integer.MAX_VALUE && distance[u]+w<distance[v]){
                    distance[v]=distance[u]+w;
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        Edge[] edge = new Edge[9];
        edge[0] = new Edge('s','a',1,0,1);
        edge[1] = new Edge('s','b',5,0,2);
        edge[2] = new Edge('a','c',2,1,3);
        edge[3] = new Edge('a','b',2,1,2);
        edge[4] = new Edge('a','d',1,1,4);
        edge[5] = new Edge('b','d',2,2,4);
        edge[6] = new Edge('c','d',3,3,4);
        edge[7] = new Edge('c','e',1,3,5);
        edge[8] = new Edge('d','e',2,4,5);
        int[] distance = dijkstraAlgorithm(edge,6, edge.length,0);
        System.out.println(distance[5]);
    }
}
