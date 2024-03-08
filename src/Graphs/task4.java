package Graphs;
import java.util.Scanner;

class Edge {
    int dest;
    int weight;
    Edge next;
    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
        this.next = null;
    }
}

class LinkedList {
    Edge head;
    public LinkedList() {
        this.head = null;
    }
    void insert(int dest, int weight) {
        Edge newEdge = new Edge(dest, weight);
        newEdge.next = head;
        head = newEdge;
    }
}
class MinHeap {
    int[] positions;
    Edge[] heap;
    int capacity;
    int size;

    MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        positions = new int[capacity];
        heap = new Edge[capacity];
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int leftChild(int i) {
        return 2 * i + 1;
    }

    int rightChild(int i) {
        return 2 * i + 2;
    }

    public void insert(Edge edge) {
        size++;
        int index = size - 1;
        heap[index] = edge;
        positions[edge.dest] = index;
        int i = index;
        while (i > 0 && heap[parent(i)].weight > heap[i].weight) {
            Edge temp = heap[parent(i)];
            heap[parent(i)] = heap[i];
            heap[i] = temp;
            positions[heap[i].dest] = i;
            positions[heap[parent(i)].dest] = parent(i);
            i = parent(i);
        }
    }

    Edge delete() {
        Edge min = heap[0];
        Edge l = heap[size - 1];
        heap[0] = l;
        positions[l.dest] = 0;
        size--;
        heapifyDown(0);
        return min;
    }

    void heapifyDown(int i) {
        int index = i;
        int left = leftChild(i);
        int right = rightChild(i);
        if (left < size && heap[left].weight < heap[index].weight) {
            index = left;
        }
        if (right < size && heap[right].weight < heap[index].weight) {
            index = right;
        }
        if (index != i) {
            Edge temp = heap[i];
            heap[i] = heap[index];
            heap[index] = temp;
            positions[heap[i].dest] = i;
            positions[heap[index].dest] = index;
            heapifyDown(index);
        }
    }

    boolean isEmpty() {
        return size == 0;
    }
}
class Graph {
    int V;
    LinkedList[] adj;
    Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
        }
    }

    void add(int src, int dest, int weight) {
        adj[src].insert(dest, weight);
        adj[dest].insert(src, weight);
    }
    public int primMST() {
        boolean[] inMST = new boolean[V];
        Edge[] parent = new Edge[V];
        int[] key = new int[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
        }
        MinHeap minHeap = new MinHeap(V);
        key[0] = 0;
        minHeap.insert(new Edge(0, 0));
        while (!minHeap.isEmpty()) {
            Edge minEdge = minHeap.delete();
            int u = minEdge.dest;
            inMST[u] = true;
            Edge edge = adj[u].head;
            while (edge != null) {
                int v = edge.dest;
                int weight = edge.weight;
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = new Edge(u, weight);
                    minHeap.insert(new Edge(v, weight));
                }
                edge = edge.next;
            }
        }
        int mstWeight = 0;
        for (int i = 1; i < V; i++) {
            mstWeight += key[i];
        }
        return mstWeight;
    }
}

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int V = scanner.nextInt();
        System.out.println("Enter the number of edges");
        int E = scanner.nextInt();
        Graph graph = new Graph(V);
        System.out.println("Enter edges");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.add(src, dest, weight);
        }
        int minSpanningTree = graph.primMST();
        System.out.println(minSpanningTree);
    }
}