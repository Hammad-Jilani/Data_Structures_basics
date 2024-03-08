package Stack_and_Queue;

public class CustomQueue {
    public int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;
    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public CustomQueue(int size){
        this.data = new int[size];
    }
    public void Insert(int value) throws Exception {
        if (isfull()){
            throw new Exception("The queue is full");
        }
        data[end++]=value;
    }
    private boolean isfull() {
        return end == data.length;
    }
    public int remove() throws Exception {
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        int remove = data[0];
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return remove;
    }

    public int front() throws Exception {
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }
    private boolean isEmpty() {
        return end==0;
    }
    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+"<-");
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        CustomQueue customQueue = new CustomQueue(5);
        customQueue.Insert(21);
        customQueue.Insert(1);
        customQueue.Insert(311);
        customQueue.Insert(678);
        customQueue.Insert(901);
        customQueue.display();
//        customQueue.Insert(21);
        System.out.println(customQueue.remove());
        customQueue.display();
    }
}
