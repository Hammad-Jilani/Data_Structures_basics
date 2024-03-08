package Mid2Preparation;

public class KunalBST {
    class Node{
        int value;
        int height;
        Node right,left;
        public Node(int value){
            this.value = value;
        }
    }
    public Node root;
    public KunalBST(){

    }
    public int height(Node node){
        if (node==null){return -1;}
        return node.height;
    }

}
