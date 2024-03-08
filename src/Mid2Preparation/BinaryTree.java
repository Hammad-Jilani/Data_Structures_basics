package Mid2Preparation;

import java.util.Scanner;

public class BinaryTree {
    private Node root;
    public BinaryTree(){

    }
    public void populate(Scanner sc){
        System.out.println("Enter the root node : ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc,root);
    }
    private void populate(Scanner sc,Node node){
        System.out.println("Do you want to enter left of "+node.data);
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.println("Enter the value at the left node of value "+node.data);
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc,node.left);
        }

        System.out.println("Do you want to enter right of "+node.data);
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.println("Enter the value at the right node of value "+node.data);
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc,node.right);
        }

    }
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int value){
            this.data = value;
        }
    }

}
