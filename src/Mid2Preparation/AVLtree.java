package Mid2Preparation;

class AVLTree{
    public Node1 Insert(Node1 root ,int value){
        if (root == null){
            root = new Node1(value);
            return root;
        } else if (root.value>value) {
            root.left = Insert(root.left,value);
        } else {
            root.right = Insert(root.right,value);
        }
        root.height = Math.max(height(root.left), height(root.right))+1;
        return rotate(root);
    }
    public int height(Node1 root){
        if (root==null){
            return -1;
        }
        return root.height;
    }
    private Node1 rotate(Node1 root) {
        if (height(root.left)-height(root.right) > 1){
//            left heavy
            if (height(root.left.left) - height(root.left.right) > 0){
//                left left
                return rightRotate(root);
            }
            if (height(root.left.left) - height(root.left.right) < 0){
//                left right
                root.left=leftRotate(root.left);
                return rightRotate(root);
            }
        }

        if (height(root.left)-height(root.right) < -1){
//            right heavy
            if (height(root.right.left) - height(root.right.right) < 0){
//                right right
                return leftRotate(root);

             }
            if (height(root.right.left) - height(root.right.right) > 0){
//                left right
                root.right=rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }
    private Node1 rightRotate(Node1 p) {
        Node1 c = p.left;
        Node1 t2 = c.right;

        c.right = p;
        p.left = t2;
        p.height = Math.max(height(p.left),height(p.right)+1);
        c.height = Math.max(height(c.left),height(c.right)+1);
        return c;
    }

    private Node1 leftRotate(Node1 c) {
        Node1 p=c.right;
        Node1 t = p.left;

        p.left=c;
        c.right=t;
        p.height = Math.max(height(p.left),height(p.right)+1);
        c.height = Math.max(height(c.left),height(c.right)+1);
        return p;
    }
}
class Node1{
    int value;
    Node1 left;
    Node1 right;
    int height=0;
    public Node1(int value){
        this.value = value;
    }
}
public class AVLtree {
    public static void main(String[] args) {
        AVLtree tree = new AVLtree();

    }
}
