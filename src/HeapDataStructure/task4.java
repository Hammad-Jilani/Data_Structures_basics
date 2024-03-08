package HeapDataStructure;

import java.util.ArrayList;
class minHeap1{
//    public void toMaxHeap(){
//        maxHeap maxHeap = new maxHeap(size);
//        for (int i = 0; i < size; i++) {
//            maxHeap.insert(heap[i]);
//        }
//        sorting(maxHeap);
//    }
//    public void sorting(maxHeap maxHeap){
////        maxHeap = new maxHeap(size);
//        for (int i = 0; i < size; i++) {
//            System.out.printf(maxHeap.delete()+" ");
//        }
//    }
    private Node[] heap;
    public int size;
    private int capacity;
    public minHeap1(int capacity){
        this.size = 0;
        this.capacity = capacity;
        heap = new Node[capacity];
    }
    private int parent(int index){
        return (index-1)/2;
    }
    private int leftChild(int index){
        return 2 * index + 1;
    }
    private int rightChild(int index){
        return 2 * index + 2;
    }
    public void insert(Node value){
        if (size == capacity){
            System.out.println("The heap is full");
            return;
        }
        heap[size]= value;
        size++;
        int currIndex = size - 1;
        while (currIndex > 0 && heap[currIndex].frequency < heap[parent(currIndex)].frequency){
            Node temp = heap[currIndex];
            heap[currIndex] = heap[parent(currIndex)];
            heap[parent(currIndex)] = temp;
            currIndex = parent(currIndex);
        }
    }
    public Node delete(){
        if (size == 0){
            System.out.println("The heap is empty");
            return null;
        }
        if (size==1){
            size--;
            return heap[0];
        }
        Node min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int curr = index;
        if (curr < size && heap[curr].frequency > heap[left].frequency){
            curr = left;
        }
        if (curr < size && heap[curr].frequency > heap[right].frequency)
            curr = right;
        if (curr != index){
            Node temp = heap[curr];
            heap[curr] = heap[index];
            heap[index] = temp;
            heapifyDown(curr);
        }
    }

}
class Node{
    int frequency;
    Node left;
    Node right;
    char aChar;
    public Node(int frequency,char aChar){
        this.frequency = frequency;
        this.aChar = aChar;
    }
    public void display(){
        System.out.println(frequency+" "+aChar);
    }
}
public class task4 {

    static class Huffman{

    }
    static int frequency(char c,String string){
        int f = 0;
        for (int i = 0; i < string.length(); i++) {
            if (c==string.charAt(i))
                f++;
        }
        return f;
    }
    public static void main(String[] args) {
        String string = "BSE-3B";
        ArrayList<Node> nodes = new ArrayList<Node>();
        int count=0;
        String copy="";
        for (int i = 0; i < string.length(); i++) {
            boolean duplicate = false;
            for (int j = i+1; j <string.length() ; j++) {
                if (string.charAt(i) == string.charAt(j)){
                    duplicate = true;
                    break;
                }
            }
            if (duplicate){
                continue;
            }
            else{
                Node node = new Node(frequency(string.charAt(i),string),string.charAt(i));
                nodes.add(node);
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).display();
        }
        minHeap1 min = new minHeap1(nodes.size());
        for (int i = 0; i < nodes.size(); i++) {
            min.insert(nodes.get(i));
        }
        
    }
}
