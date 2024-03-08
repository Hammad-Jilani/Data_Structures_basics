package Stack_and_Queue;

public class MainCustomStack {
    public static void main(String[] args) throws Exception {
        dynamicStack customStack = new dynamicStack(4);
        customStack.push(32);
        customStack.push(98);
        customStack.push(31);
        customStack.push(76);
        customStack.push(8);

        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }
}
