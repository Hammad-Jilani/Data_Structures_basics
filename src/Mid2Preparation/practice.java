package Mid2Preparation;

import java.util.Arrays;

class Node{
    int value;
    Node right,left;
    public Node(int value){
        this.value = value;
    }
}
class binaryTree{
    public static int index=-1;
    public Node Insert(int[] nodes){
        index++;
        if (nodes[index]==-1){
            return null;
        }
        Node root = new Node(nodes[index]);
        root.left = Insert(nodes);
        root.right = Insert(nodes);
        return root;
    }
    public int height(Node root){
        if (root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
}
public class practice {
    public static int[] Radix(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max){
                max=array[i];
            }
        }
        for (int i = 1; max/i>0; i=i*10) {
            Count(array,i);
        }
        return array;
    }

    private static void Count(int[] array, int i) {
        int temp[] = new int[10];
        int result[] = new int[array.length];
        Arrays.fill(temp,0);
        for (int j = 0; j < array.length; j++) {
            temp[(array[j]/i)%10]++;
        }
        for (int j = 1; j <temp.length ; j++) {
            temp[j] =  temp[j] + temp[j-1];
        }
        for (int j = array.length-1; j>=0; j--) {
            result[temp[(array[j]/i)%10]-1]=array[j];
            temp[array[j]/i%10]--;
        }
        for (int j = 0; j < array.length ; j++) {
            array[j]=result[j];
        }
    }

    public static void main(String[] args) {

    }
}
