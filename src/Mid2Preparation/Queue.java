package Mid2Preparation;

public class Queue {
    static class CustomQueue{
        int[] data;
        public final static int DEFAULT_SIZE=10;
        int size = 0;

        public CustomQueue(int size) {
            this.data = new int[size];
        }
        public CustomQueue(){
            this(DEFAULT_SIZE);
        }
        public boolean Insert(int item) throws Exception {
            if (isFull()){
                throw new Exception("The queue is full");
            }
            data[size++] = item;
            return true;
        }

        private boolean isFull() {
            return size == data.length;
        }
        public int remove() throws Exception {
            if (isEmpty()){
                throw new Exception("The queue is empty");
            }
            int remove = data[0];
            for (int i = 1; i < size; i++) {
                data[i-1] = data[i];
            }
            size--;
            return remove;
        }
        public boolean isEmpty(){
            return size==0;
        }
    }
    static class CircularQueue{
        int data[];
        public final static int DEFAULT_SIZE=10;
        int front=0;
        int end=0;
        int size = 0;

        public CircularQueue(int size) {
            this.data = new int[size];
        }
        public CircularQueue(){
            this(DEFAULT_SIZE);
        }
        public void Insert(int item) throws Exception {
            if (isFull()){
                throw new Exception("The queue is full");
            }
            data[end++] = item;
            size++;
            end = end % data.length;
        }

        private boolean isFull() {
            return size == data.length;
        }
        public int remove() throws Exception {
            if (isEmpty()){
                throw new Exception("The queue is empty");
            }
            int remove = data[front++];
            front = front % data.length;
            size--;
            return remove;
        }
        public void display(){
            int i = front;
            do{
                System.out.print(data[i]+" ");
                i++;
                i = i % data.length;
            }while (i!=end);
        }
        private boolean isEmpty() {
            return size == 0;
        }
    }
    public static void main(String[] args) throws Exception {
        CircularQueue customQueue = new CircularQueue(3);
        customQueue.Insert(21);
        customQueue.Insert(3129);
        customQueue.Insert(99);

        System.out.println(customQueue.remove());
        System.out.println(customQueue.remove());
        System.out.println(customQueue.remove());
    }
}
