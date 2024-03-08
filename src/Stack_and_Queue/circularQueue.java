package Stack_and_Queue;

public class circularQueue {
    public int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;
    int front =0;
    int size= 0;
    public circularQueue(){
        this(DEFAULT_SIZE);
    }
    public circularQueue(int size){
        this.data = new int[size];
    }

    public boolean isfull() {
        return size == data.length;
    }
    private boolean isEmpty(){
        return size==0;
    }
    public boolean enqueue(int item){
        if (isfull()){
            return false;
        }
        data[end++] = item;
        size++;
        end = end % data.length;
        return true;
    }
    public int dequeue() throws Exception {
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        int remove = data[front++];
        front = front % data.length;
        size--;
        return remove;
    }

    public int front() throws Exception {
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[front];
    }
    public void display(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        do {
            System.out.printf(data[i] +"-> ");
            i++;
            i %= data.length;
        }while (i!=end);
        System.out.println("End");
    }

    public static void main(String[] args) throws Exception {
        circularQueue circularQueue = new circularQueue(7);
        circularQueue.enqueue(13);
        circularQueue.enqueue(7);
        circularQueue.enqueue(4);
        circularQueue.enqueue(1);
        circularQueue.enqueue(6);
        circularQueue.enqueue(8);
        circularQueue.enqueue(10);

        circularQueue.display();
        System.out.println();
        for (int i = 0; i < 7; i++) {
            System.out.print(circularQueue.dequeue()+"->");
        }
        System.out.println("END");
    }
}
