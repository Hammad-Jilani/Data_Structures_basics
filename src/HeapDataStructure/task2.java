package HeapDataStructure;

public class task2 {

    public static void main(String[] args) {
        int[] array = {35,33,42,10,14,19,27,44,26,31};
        minHeap minHeap = new minHeap(array.length);
        for (int i = 0; i < array.length; i++) {
            minHeap.insert(array[i]);
        }
        System.out.println(minHeap.delete());
        minHeap.toMaxHeap();
    }
}
