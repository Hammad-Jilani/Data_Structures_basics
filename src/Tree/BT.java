package Tree;

public class BT {
    static class Stack{
        Node head;
        int size=0;
        public void push(Node node){
            if (head == null){
                head = node;
                size++;
                return;
            }
            node.next = head;
            head = node;
            size++;
        }
        public Node pop(){
            Node curr = head;
            head = head.next;
            size--;
            return curr;
        }
        public Node peek(){
            return head;
        }
    }

    static class Node{
        int value,height;
        Node left,right,next;
        public Node(int value){
            this.value = value;
            left=right=null;
        }
    }
    static class BinaryTree{
        int index=-1;
        public Node BuildTree(int[] array){
            index++;
            if (array[index]==-1){
                return null;
            }
            Node node = new Node(array[index]);
            node.left = BuildTree(array);
            node.right = BuildTree(array);
            node.height = Math.max(height(node.left),height(node.right))+1;
            return node;
        }

        private int height(Node root) {
            if (root==null){
                return -1;
            }
            return root.height;
        }

        public void InOrderIterative(Node root){
            if (root == null){
                return;
            }
            Stack s = new Stack();
            Node curr = root;
            while (curr!=null || s.size>0){
                while (curr!=null){
                    s.push(curr);
                    curr = curr.left;
                }
                curr = s.pop();
                System.out.printf(curr.value+" ");
                curr = curr.right;
            }
        }
        public void preOrderIterative(Node root){
            if (root==null){
                return;
            }
            Stack s = new Stack();
            s.push(root);
            while (s.size!=0){
                Node curr = s.peek();
                System.out.print(curr.value+" ");
                s.pop();
                if (curr.right!=null){
                    s.push(curr.right);
                }
                if (curr.left!=null){
                    s.push(curr.left);
                }
            }
        }
        public void inOrder(Node root){
            if (root==null){
                return;
            }
            inOrder(root.left);
            System.out.printf(root.value+" ");
            inOrder(root.right);
        }
        public void postOrder(Node root){
            if (root==null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.printf(root.value+" ");
        }
        public void preOrder(Node root){
            if (root==null){
                return;
            }
            System.out.printf(root.value+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public void levelOrder(Node root){
            int h = height(root);
            for (int i = 1; i <= h+1 ; i++) {
                printLevel(root,i);
            }
        }

        private void printLevel(Node root, int i) {
            if (root==null){
                return;
            }
            if (i==1){
                System.out.print(root.value+" ");
                return;
            }
            if (i>1){
                printLevel(root.left,i-1);
                printLevel(root.right,i-1);
            }
        }
        public boolean IdenticalTree(Node root1,Node root2){
            if (root1==null && root2==null){
                return true;
            }
            if (root1.value == root2.value){
                return IdenticalTree(root1.left,root2.left) && IdenticalTree(root1.right,root2.right);
            }
            else{
                return false;
            }
        }
        public Node mirror(Node root){
            if (root==null){
                return null;
            }
            Node left = mirror(root.left);
            Node right = mirror(root.right);

            root.right = left;
            root.left = right;
            return root;
        }
        public boolean SymmetricTree(Node root1,Node root2){
            if (root1==null && root2==null){
                return true;
            }
            if (root1.value == root2.value){
                return SymmetricTree(root1.right,root2.left) && SymmetricTree(root1.left,root2.right);
            }else{
                return false;
            }
        }
        public boolean sumChildren(Node root){
            if (root.left==null && root.right==null){
                return true;
            }
            if (root.left==null){
                root.left = new Node(0);
            }
            if (root.right==null){
                root.right = new Node(0);
            }
            if (root.value == root.left.value + root.right.value){
                return sumChildren(root.left) && sumChildren(root.right);
            }else{
                return false;
            }
        }
    }
    public static void main(String[] args) {
        int[] nodes1 = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root1 = bt.BuildTree(nodes1);
//        bt.inOrder(root1);
//        System.out.println();
//        bt.InOrderIterative(root1);
        bt.preOrder(root1);
        System.out.println();
        bt.preOrderIterative(root1);
    }
}
