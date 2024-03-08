package Practice;

public class BT {
    static class Node{
        int value,height;
        Node left,right;
        Node(int value){
            this.value = value;
        }
    }
    static class Tree {
        int index = -1;
        public Node builtTree(int[] array) {
            index++;
            if (array[index] == -1) {
                return null;
            }
            Node node = new Node(array[index]);
            node.left = builtTree(array );
            node.right = builtTree(array);
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            return node;
        }

        private int height(Node root) {
            if (root == null) {
                return -1;
            }
            return root.height;
        }

        public void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.printf(root.value + " ");
            inOrder(root.right);
        }

        public void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.printf(root.value + " ");
        }

        public void levelOrder(Node root) {
            int h = root.height;
            for (int i = 1; i <= h; i++) {
                printLevel(root, h);
            }
        }

        private void printLevel(Node root, int h) {
            if (root == null) {
                return;
            }
            if (h == 1) {
                System.out.printf(root.value + " ");
            }
            if (h > 1) {
                printLevel(root.left, h - 1);
                printLevel(root.right, h - 1);
            }
        }
        public boolean identical(Node root1,Node root2){
            if (root1==null && root2==null){
                return true;
            }
            if (root1.value == root2.value){
                return identical(root1.right,root2.right) && identical(root1.left,root2.left);
            }
            else{
                return false;
            }
        }
        public boolean symmetric(Node root1,Node root2){
            if (root1==null && root2==null){
                return true;
            }
            else if(root1.value == root2.value){
                return symmetric(root1.right,root2.left) && symmetric(root1.left,root2.right);
            }else{
                return false;
            }
        }
        public boolean sumChild(Node root){
            if (root.left==null && root.right==null) {
                return true;
            }
            if (root.value == root.left.value+root.right.value){
                return sumChild(root.left) && sumChild(root.right);
            }
            else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Tree t1 = new Tree();
        Tree t2 = new Tree();
        int[] nodes1 = {1,2,3,-1,-1,4,-1,-1,2,4,-1,-1,3,-1,-1};
        Node root1 = null;
        root1 = t1.builtTree(nodes1);
        System.out.println(t1.symmetric(root1,root1));
    }
}
