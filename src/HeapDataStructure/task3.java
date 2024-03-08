package HeapDataStructure;

import java.util.Random;
import java.util.Scanner;
class ComputerTask{
    int priority;
    ComputerTask(int priority){
        this.priority = priority;
    }
}
public class task3 {
    public static void main(String[] args) {
        Random random = new Random(4001);
//        int num =
        System.out.println("Enter number of task");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        maxHeap maxHeap = new maxHeap(n);

        for (int i = 0; i <= n; i++) {
            int rand = random.nextInt(10);
            if (rand==0){
                i--;
                continue;
            }
            ComputerTask computerTask = new ComputerTask(rand);
            maxHeap.insert(computerTask.priority);
        }
        System.out.println();
        while (maxHeap.size!=0){
            System.out.print("Task with priority "+maxHeap.delete()+" served");
            System.out.println();
        }
    }
}
