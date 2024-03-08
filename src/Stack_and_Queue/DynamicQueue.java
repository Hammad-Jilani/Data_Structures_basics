package Stack_and_Queue;

public class DynamicQueue extends circularQueue{
    public DynamicQueue(int size){
        super(size);
    }
    @Override
    public boolean enqueue(int item) {
        if (this.isfull()) {
            int[] temp = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front+i)% data.length];
            }
            front = 0;
            end = data.length;
            data=temp;
        }
        return super.enqueue(item);
    }
}
