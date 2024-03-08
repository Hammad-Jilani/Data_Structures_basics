package HeapDataStructure;
class minHeap{
    public void toMaxHeap(){
        maxHeap maxHeap = new maxHeap(size);
        for (int i = 0; i < size; i++) {
            maxHeap.insert(heap[i]);
        }
        sorting(maxHeap);
    }
    public void sorting(maxHeap maxHeap){
//        maxHeap = new maxHeap(size);
        for (int i = 0; i < size; i++) {
            System.out.printf(maxHeap.delete()+" ");
        }
    }
    private int[] heap;
    public int size;
    private int capacity;
    public minHeap(int capacity){
        this.size = 0;
        this.capacity = capacity;
        heap = new int[capacity];
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
    public void insert(int value){
        if (size == capacity){
            System.out.println("The heap is full");
            return;
        }
        heap[size] = value;
        size++;
        int currIndex = size - 1;
        while (currIndex > 0 && heap[currIndex] < heap[parent(currIndex)]){
            int temp = heap[currIndex];
            heap[currIndex] = heap[parent(currIndex)];
            heap[parent(currIndex)] = temp;
            currIndex = parent(currIndex);
        }
    }
    public int delete(){
        if (size == 0){
            System.out.println("The heap is empty");
            return -1;
        }
        if (size==1){
            size--;
            return heap[0];
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int curr = index;
        if (curr < size && heap[curr] > heap[left]){
            curr = left;
        }
        if (curr < size && heap[curr] > heap[right])
            curr = right;
        if (curr != index){
            int temp = heap[curr];
            heap[curr] = heap[index];
            heap[index] = temp;
            heapifyDown(curr);
        }
    }

}
class maxHeap{
    private int[] heap;
    private int capacity;
    public int size;
    public maxHeap(){}
    public maxHeap(int capacity){
        this.capacity = capacity;
        this.size =0;
        this.heap = new int[capacity];
    }
    private int parent(int index){
        return (index -1)/2;
    }
    private int leftIndex(int index){
        return (2 * index) + 1;
    }
    private int rightIndex(int index){
        return (2 * index) + 2;
    }
    public void insert(int value){
        if (size == capacity){
            System.out.println("The heap is full");
            return;
        }
        heap[size] = value;
        size++;
        int curr = size-1;
        while (curr > 0 && heap[curr] > heap[parent(curr)]){
            int temp = heap[curr];
            heap[curr] = heap[parent(curr)];
            heap[parent(curr)] = temp;
            curr = parent(curr);
        }
    }
    public int delete(){
        if (size == 0){
            System.out.println("The heap is empty");
            return -1;
        }
        if (size == 1){
            size--;
            return heap[0];
        }
        int max = heap[0];
        heap[0] = heap[size -1];
        size--;
        heapifyDown(0);
        return max;
    }

    private void heapifyDown(int index) {
        int left = leftIndex(index);
        int right = rightIndex(index);
        int curr = index;
        if (left>size){
            return;
        }
        if (right>size){
            return;
        }
        if (curr < size && heap[curr] < heap[left]) {
            curr = left;
        }
        if (curr < size && heap[curr] < heap[right]) {
            curr = right;
        }
        if (curr != index){
            if (heap[left]> heap[right])
                curr = left;
            else
                curr=right;
        }
        if (curr != index){
            int temp = heap[curr];
            heap[curr] = heap[index];
            heap[index] = temp;
            heapifyDown(curr);
        }
    }
}
public class Heap {
    public static void main(String[] args) {
        minHeap minHeap = new minHeap(9);
        int[] array = {7,1,6,2,5,9,10,2};
//        int[] array1 = {16,14,10,8,7,9,3,2,4};
        for (int i = 0; i < array.length; i++) {
            minHeap.insert(array[i]);
        }
        System.out.println(minHeap.delete());
        maxHeap maxHeap = new maxHeap(9);
        for (int i = 0; i < array.length; i++) {
            maxHeap.insert(array[i]);
        }
        System.out.println(maxHeap.delete());

    }
}

