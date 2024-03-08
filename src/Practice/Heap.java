package Practice;
public class Heap {
    static class minHeap{
        private int[] heap;
        int size;
        int capacity;
        public minHeap(int capacity){
            this.size=0;
            this.capacity=capacity;
            heap = new int[capacity];
        }
        public void add(int value){
            if (size==capacity){
                System.out.println("The heap is full");
                return;
            }
            heap[size] = value;
            size++;
            int currIndex = size-1;
            while (currIndex>0 && heap[parent(currIndex)]>heap[currIndex]){
                int temp = heap[currIndex];
                heap[currIndex] = heap[parent(currIndex)];
                heap[parent(currIndex)] = temp;
                currIndex = parent(currIndex);
            }
        }

        private int leftChild(int index){
            return (2*index)+1;
        }
        private int rightChild(int index){
            return (2*index)+2;
        }
        private int parent(int index){
            return (index-1)/2;
        }
        public int extract(){
            if (size==0){
                System.out.println("The heap is empty");
                return -1;
            }
            int min = heap[0];
            heap[0] = heap[size-1];
            size--;
            heapify(0);
            return min;
        }

        private void heapify(int index) {
            int left = leftChild(index);
            int right = rightChild(index);
            int currIndex = index;
            if (right>size){
                return;
            }
            if (left>size){
                return;
            }
            if (heap[currIndex]>heap[left]){
                currIndex=left;
            }
            if (heap[currIndex]>heap[right]){
                currIndex=right;
            }
            if (currIndex!=index){
                int temp = heap[index];
                heap[index] = heap[currIndex];
                heap[currIndex] = temp;
                heapify(currIndex);
            }
        }
    }
    public static void main(String[] args) {
        int array[]= {7,1,6,2,5,9,10,2};
        minHeap min = new minHeap(array.length);
        for (int i = 0; i < min.capacity; i++) {
            min.add(array[i]);
        }
        System.out.println(min.extract());
        System.out.println(min.extract());
    }
}
