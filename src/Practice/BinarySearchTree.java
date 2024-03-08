package Practice;

public class BinarySearchTree {
    static class Node{
        int value,height;
        Node left,right;

        public Node(int value) {
            this.value = value;
//            this.height = height;
        }
    }
    static class BinaryTree{
        public Node buildBST(int value,Node root){
            if (root==null){
                Node node = new Node(value);
                root = node;
                return root;
            }
            if (value> root.value){
                root.right = buildBST(value,root.right);
            } else if (value< root.value) {
                root.left = buildBST(value,root.left);
            }
            root.height = Math.max(height(root.left),height(root.right))+1;
            return rotate(root);
        }

        private Node rotate(Node root) {
            if (height(root.left)-height(root.right)>1){
                if (height(root.left.left) - height(root.left.right)>0){
                    return RotateRight(root);
                }
                if (height(root.left.left) - height(root.left.right)<0){
                    root.left = RotateLeft(root.left);
                    return RotateRight(root);
                }
            }
            if (height(root.left)-height(root.right) < -1){
                if (height(root.right.left)-height(root.right.right) < 0){
                    return RotateLeft(root);
                }
                if (height(root.right.left)-height(root.right.right) > 0){
                    root.right = RotateRight(root.right);
                    return RotateLeft(root);
                }
            }
            return root;
        }

        private Node RotateLeft(Node c) {
            Node p = c.right;
            Node t = p.left;
            p.left = c;
            c.right = t;
            p.height = Math.max(height(p.left),height(p.right))+1;
            c.height = Math.max(height(c.left),height(c.right))+1;
            return p;
        }

        private Node RotateRight(Node p) {
            Node c = p.left;
            Node t = c.right;
            c.right = p;
            p.left = t;
            p.height = Math.max(height(p.left),height(p.right))+1;
            c.height = Math.max(height(c.left),height(c.right))+1;
            return c;
        }

        private int height(Node left) {
            if (left==null){
                return -1;
            }
            return left.height;
        }

        public void inOrder(Node root){
            if (root==null){
                return;
            }
            inOrder(root.left);
            System.out.printf(root.value+" ");
            inOrder(root.right);
        }
        public Node delete(int value,Node root){
            if (root==null){
                return null;
            }
            if (value>root.value){
                root.right = delete(value,root.right);
            }else if (value<root.value){
                root.left = delete(value,root.left);
            }else{
                if (root.left == null && root.right == null){
                    return null;
                }
                if (root.right==null){
                    return root.left;
                }
                if (root.left==null){
                    return root.right;
                }
                else{
                    Node inOrderSuccessor = successor(root.right);
                    root.value = inOrderSuccessor.value;
                    root.right = delete(root.value, root.right);
                }
            }
            return root;
        }
        private Node successor(Node root){
            if (root!=null){
                root = root.left;
            }
            return root;
        }
    }
    public static void main(String[] args) {
        int[] value = {45, 10, 7, 90, 12, 50, 13, 39, 57};
        BinaryTree bt1 = new BinaryTree();
        Node root=null;
        for (int i = 0; i < value.length; i++) {
             root= bt1.buildBST(value[i],root);
        }
        bt1.inOrder(root);
        System.out.println();
//        root = bt1.delete(50,root);
//        bt1.inOrder(root);
    }
}

