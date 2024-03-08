package Graphs;

import java.util.Arrays;

public class primsAlgorithm {
    static class Edge {
        int src, dest, weight;
        Edge next;

        public Edge(int src, int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
            this.src = src;
            this.next = null;
        }
    }
    static class LinkedList {
        Edge head;
        public LinkedList() {
            this.head = null;
        }
        public void add(Edge newNode) {
            newNode.next = head;
            head = newNode;
        }
    }
    public static int primMST(LinkedList[] adj) {
        int V = adj.length;
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] inMST = new boolean[V];
        int totalWeight = 0;
        Arrays.fill(key,Integer.MAX_VALUE);
        Arrays.fill(inMST,false);
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, inMST);
            inMST[u] = true;
            Edge temp = adj[u].head;
            while (temp != null) {
                int v = temp.dest;
                int weight = temp.weight;
                if (!inMST[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                }
                temp = temp.next;
            }
        }
        for (int i = 1; i < V; i++) {
            if (key[i]==Integer.MAX_VALUE){
                continue;
            }
            totalWeight += key[i];
        }
        // Printing edges of MST
        System.out.println("Edges of MST:");
        for (int i = 1; i < V; i++) {
            if (key[i]==Integer.MAX_VALUE){
                continue;
            }
            System.out.println(parent[i] + " - " + i + "\tWeight: " + key[i]);
        }
        return totalWeight;
    }

    private static int minKey(int[] key, boolean[] inMST) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < key.length; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        LinkedList[] graph = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new LinkedList();
        }
//        graph[0].add(new Edge(0,1, 5));
        graph[1].add(new Edge(1,0, 5));
        graph[1].add(new Edge(1,2, 3));
        graph[2].add(new Edge(2,1, 3));
        graph[0].add(new Edge(0,2, 1));
        graph[2].add(new Edge(2,0, 1));

        int sumOfWeights = primMST(graph);
        System.out.println("Sum of weights in MST: " + sumOfWeights);
    }
}

