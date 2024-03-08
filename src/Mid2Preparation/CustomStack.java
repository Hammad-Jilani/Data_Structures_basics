package Mid2Preparation;
public class CustomStack {
    static class Stack{
        int[] data;
        public final static int DEFAULT_LENGTH = 10;
        int ptr=-1;
        public Stack(int size){
            this.data = new int[size];
        }
        public Stack(){
            this(DEFAULT_LENGTH);
        }
        public boolean push(int item) throws Exception {
            if (isFull()){
                throw new Exception("The stack is full");
            }
            ptr++;
            data[ptr] = item;
            return true;
        }

        public boolean isFull() {
            return ptr == data.length-1;
        }
        public int pop() throws Exception {
            if (isEmpty()){
                throw new Exception("The stack is already empty");
            }
            int remove = data[ptr];
            ptr--;
            return remove;
        }

        private boolean isEmpty() {
            return ptr==-1;
        }
        public int peek(){
            int peek = data[ptr];
            return peek;
        }
    }
    static class DynamicStack extends Stack{
        public DynamicStack(){
            super();
        }
        public DynamicStack(int size){
            super(size);
        }

        @Override
        public boolean push(int item) throws Exception {
            if (isFull()){
                int temp[] = new int[data.length+1];
                System.arraycopy(data,0,temp,0,data.length);
                data=temp;
            }
            return super.push(item);
        }
    }
    static class StackLink{
//        int size=0;
        Node head;
        public StackLink(){

        }
        public boolean push(int item){
            Node node = new Node(item);
            if (head == null){
                head=node;
                return true;
            }
            node.next=head;
            head = node;
            return true;
        }
        public int pop() throws Exception {
            if (head==null){
                throw new Exception("The stack is empty");
            }
            int remove = head.data;
            head = head.next;
            return remove;
        }
        class Node{
            int data;
            Node next;
            public  Node(int item){
                this.data = item;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        StackLink custom = new StackLink();
        custom.push(21);
        custom.push((91));
        custom.push(2);
        custom.push(2139);

        System.out.println(custom.pop());
        System.out.println(custom.pop());
        System.out.println(custom.pop());
        System.out.println(custom.pop());
    }
}
