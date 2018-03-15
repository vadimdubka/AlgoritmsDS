package wf;
/*https://www.testdome.com/d/java-interview-questions/4 #3*/
class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
        int currValue = root.value;
        if (currValue == value) {
            return true;
        } else {
            if (currValue > value) {
                root = root.left;
            } else {
                root = root.right;
            }
            if (root == null) {
                return false;
            } else {
                return contains(root, value);
            }
        }
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);
        
        System.out.println(contains(n2, 3));
    }
}