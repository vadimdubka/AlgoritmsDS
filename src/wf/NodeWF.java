package wf;

/*Task from java sert. WF*/
class NodeWF {
    private NodeWF leftChild, rightChild;
    
    public NodeWF(NodeWF leftChild, NodeWF rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    public NodeWF getLeftChild() {
        return this.leftChild;
    }
    
    public NodeWF getRightChild() {
        return this.rightChild;
    }
    
    public int height() {
        NodeWF leftNode    = getLeftChild();
        NodeWF rightNode   = getRightChild();
        int    leftHeight  = 0;
        int    rightHeight = 0;
        if (leftNode != null) {
            leftHeight = leftNode.height() + 1;
        }
        if (rightNode != null) {
            rightHeight = rightNode.height() + 1;
        }
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
    
    public static void main(String[] args) {
        NodeWF leaf1 = new NodeWF(null, null);
        NodeWF leaf2 = new NodeWF(null, null);
        NodeWF node  = new NodeWF(leaf1, null);
        NodeWF root  = new NodeWF(node, leaf2);
        
        System.out.println(root.height());
    }
}