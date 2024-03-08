package Tree;

public class AVLTree {
    static class Node{
        int value,height;
        Node left,right;
        public Node(int value){
            this.value=value;
        }
    }
    static class AVL{
        public int height(Node root){
            if (root==null){
                return -1;
            }
            return root.height;
        }
        public Node buildTree(Node root,int value){
            if (root==null){
                root = new Node(value);
                return root;
            }
            if (root.value>value){
                root.left = buildTree(root.left,value);
            }
            if (root.value<value){
                root.right = buildTree(root.right,value);
            }
            root.height = Math.max(height(root.left),height(root.right))+1;
            return rotate(root);
        }

        private Node rotate(Node root) {
            if (height(root.left) - height(root.right) > 1){
//                left heavy
                if (height(root.left.left) - height(root.left.right) > 0){
//                    left left
                    return rightRotate(root);
                }if (height(root.left.left) - height(root.left.right) < 0){
//                    left right
                    root.left = leftRotate(root.left);
                    return rightRotate(root);
                }
            }
            if (height(root.left) - height(root.right) < -1){
//                right heavy
                if (height(root.right.left) - height(root.right.right) < 0 ){
                    return leftRotate(root);
                }if (height(root.right.left) - height(root.right.right) > 0){
                    root.right = rightRotate(root.right);
                    return leftRotate(root);
                }
            }
            return root;
        }
        private Node leftRotate(Node c) {
            Node p = c.right;
            Node t2 = p.left;
            p.left = c;
            c.right = t2;
            p.height = Math.max(height(p.left),height(p.right)+1);
            c.height = Math.max(height(c.left),height(c.right)+1);
            return p;
        }
        private Node rightRotate(Node p) {
            Node c = p.left;
            Node t2 = c.right;
            c.right = p;
            p.left = t2;
            p.height= Math.max(height(p.left),height(p.right)+1);
            c.height = Math.max(height(c.left),height(c.right)+1);
            return c;
        }
    }
    public static void main(String[] args) {

    }
}
