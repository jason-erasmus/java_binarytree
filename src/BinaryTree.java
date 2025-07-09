class Node {
    int data;
    Node left;
    Node right;

    Node(int num) {
        data = num;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    Node nodeRoot = null; // creating data type and pointer

    public void addData(int data) {
        nodeRoot = insert(nodeRoot, data);
    }

    public static Node insert(Node nodeRoot, int data) {
        if (nodeRoot == null) {
            return new Node(data);
        }
        if (data < nodeRoot.data) {
            nodeRoot.left = insert(nodeRoot.left, data);
        } else if (data > nodeRoot.data) {
            nodeRoot.right = insert(nodeRoot.right, data);
        }
        return nodeRoot; // returns updated tree
    }

    public boolean findData(int data) {
        return search(nodeRoot, data);
    }

    public boolean search(Node nodeRoot, int data) {
        if (nodeRoot == null) {
            return false;
        }
        if (nodeRoot.data == data) {
            return true;
        } else if (data < nodeRoot.data) {
            return search(nodeRoot.left, data);
        } else {
            return search(nodeRoot.right, data);
        }
    }

    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();

        myTree.addData(50);
        myTree.addData(60);
        myTree.addData(75);
        myTree.addData(20);
        myTree.addData(10);
        myTree.addData(30);
        myTree.addData(40);

        System.out.println("Is number 75 in the tree? " + myTree.findData(75));
    }
}
