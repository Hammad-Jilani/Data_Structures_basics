package Stack_and_Queue;

public class CustomStack {
    public int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int ptr = -1;
    public boolean push(int value) throws Exception{
        if (isFull()){
            throw new Exception("stack is full");
        }
        ptr++;
        data[ptr] = value;
        return true;
    }
    public boolean isFull() {
        return ptr == data.length-1;
    }
    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("Stack is empty,therefore cannot pop");
        }
        int remove = data[ptr];
        ptr--;
        return  remove;
    }
    private boolean isEmpty(){
        return ptr == -1;
    }
    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("cannot peek as stack is empty");
        }
        return data[ptr];
    }
    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size){
        data = new int[size];
    }
}
