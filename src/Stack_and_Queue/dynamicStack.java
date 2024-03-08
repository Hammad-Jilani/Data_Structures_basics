package Stack_and_Queue;

public class dynamicStack extends CustomStack {
    public dynamicStack(){
        super();
    }

    public dynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int value) throws Exception {
        if (this.isFull()){
            int[] temp = new int[data.length * 2];
            System.arraycopy(data,0,temp,0,data.length);
            data=temp;
        }
        return super.push(value);
    }
}
