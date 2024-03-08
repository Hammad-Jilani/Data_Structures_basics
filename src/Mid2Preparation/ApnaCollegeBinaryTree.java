package Mid2Preparation;

public class ApnaCollegeBinaryTree {
    static class Node{
        int data;
        Node left,right;
        public Node(int item){
            this.data = item;
            this.left = this.right = null;
        }
    }
    static class binaryTree{
        static int index = -1;
        public Node buildTree(int[] node){
            index++;
            if (node[index] == -1){
                return null;
            }
            Node node1 = new Node(node[index]);
            node1.left = buildTree(node);
            node1.right = buildTree(node);
            return node1;
        }
        public void preorder(Node node){
            if (node==null){
                return;
            }
            System.out.print(node.data+" ");
            preorder(node.left);
            preorder(node.right);
        }
        public void inorder(Node node){
            if (node==null){
                return;
            }
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
        public void postOrder(Node node){
            if (node == null){
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data+" ");
        }
        public int CountNode(Node root){
            if (root==null){
                return 0;
            }
            return CountNode(root.left)+CountNode(root.right)+1;
        }
        public int SumNode(Node node){
            if (node==null){
                return 0;
            }
            return SumNode(node.left)+SumNode(node.right)+node.data;
        }
        public int height(Node node){
            if (node==null){
                return 0;
            }
            int leftHeight = height(node.left);
            int rightHeight= height(node.right);
            int myHeight = Math.max(leftHeight,rightHeight)+1;
            return myHeight;
        }
        public int Diameter(Node root){
            if (root==null){
                return 0;
            }
            System.out.println(root.data);
            int LeftSide = Diameter(root.left);
            int RightSide = Diameter(root.right);
            int withRoot = height(root.left) + height(root.right)+1;

            return Math.max(withRoot,Math.max(LeftSide,RightSide));
        }
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
//        int[] nodes = {1,2,4,-1,-1,5,-1,-1};
        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        tree.preorder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        System.out.println(tree.CountNode(root));
        System.out.println("Sum of the nodes "+tree.SumNode(root));
        System.out.println("Height "+tree.height(root));
        System.out.println(tree.Diameter(root));
    }
}
