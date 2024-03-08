package Graphs;

class q5 {
    static class Node {
        int src;
        int des;
        int weight;
        Node next;
        Node(int src,int d, int w) {
            this.src = src;
            des = d;
            weight = w;
            next = null;
        }
    }
    static class LinkedList {
        Node head;
        LinkedList() {
            head = null;
        }
        void add(int src,int d, int w) {
            Node node = new Node(src,d, w);
            node.next = head;
            head = node;
        }
    }
    public static int[] dijkstra(int[][] edges, int vertices, int edge, int S) {
        LinkedList[] graph = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i) {
            graph[i] = new LinkedList();
        }
        for (int i = 0; i < edge; ++i) {
            int src = edges[i][0];
            int des = edges[i][1];
            int weight = edges[i][2];
            graph[src].add(src,des, weight);
        }
        int[] distances = new int[vertices];
        for (int i = 0; i < vertices; ++i) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[S] = 0;
        for (int i = 0; i < vertices - 1; ++i) {
            for (int j = 0; j < edge; ++j) {
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                if (distances[u] != Integer.MAX_VALUE && distances[u]+w<distances[v]) {
                    distances[v] = distances[u] + w;
                }
            }
        }
        for (int i = 0; i < edge; ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            if (distances[u]!=Integer.MAX_VALUE && distances[u] + weight<distances[v]) {
                return new int[]{-1};
            }
        }
        for (int i = 0; i < vertices; ++i) {
            if (distances[i] == Integer.MAX_VALUE) {
                distances[i] = (int) Math.pow(10, 8);
            }
        }
        return distances;
    }
    public static void main(String[] args) {
        int[][] E = {{0, 1, 5}, {1, 0, 3}, {1, 2, -1}, {2, 0, 1}};
//        int[][] E = {{0,1,1},{0,2,5},{1,2,2},{1,3,2},{1,4,1},{2,4,2},{3,4,3},{3,5,1},{4,5,2}};
        int S = 2;
        int V = 3;
        int numEdges = E.length;
        int[] result = dijkstra(E, V, numEdges, S);
        for (int i = 0; i < V; ++i) {
            System.out.println(i+" " + result[i]);
        }
    }
}
