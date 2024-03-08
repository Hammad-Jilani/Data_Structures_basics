package Tree;

public class BST {
    static class Node{
        int value;
        Node left,right;
        public Node(int value){
            this.value = value;
        }
    }
    static class BinarySearchTree{
        public Node buildTree(Node root,int value){
            if (root==null){
                root= new Node(value);
                return root;
            }
            if (root.value>value){
                root.left = buildTree(root.left,value);
            }
            if (root.value<value){
                root.right = buildTree(root.right,value);
            }
            return root;
        }
        public void inOrder(Node root){
            if (root==null) {
                return;
            }
            inOrder(root.left);
            System.out.printf(root.value+" ");
            inOrder(root.right);
        }
        public Node delete(Node root,int value){
            if (root==null){
                return null;
            }
            if (root.value>value){
                root.left = delete(root.left,value);
            }
            if (root.value<value){
                root.right = delete(root.right,value);
            }else{
                if (root.left==null && root.right==null){
                    return null;
                }
                if (root.left==null){
                    return root.right;
                }
                if (root.right==null){
                    return root.left;
                }
                else{
                    Node inOrder = inOrderSuccessor(root.right,value);
                    root.value = inOrder.value;
                    root.right = delete(root.right,value);
                }
            }
            return root;
        }

        private Node inOrderSuccessor(Node right, int value) {
            while (right.left!=null){
                right = right.left;
            }
            return right;
        }
    }
    public static void main(String[] args) {
        int[] value = {45, 10, 7, 90, 12, 50, 13, 39, 57};
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < value.length; i++) {
            root = bst.buildTree(root,value[i]);
        }
        bst.inOrder(root);
    }
}
