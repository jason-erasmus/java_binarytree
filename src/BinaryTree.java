/**
 * The class `Node` represents a node in a binary tree with integer data and
 * references to left and right child nodes.
 */
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

    public void addData(int data) { // method to insert new node of data in the binary tree
        nodeRoot = insert(nodeRoot, data);
    }

    public static Node insert(Node nodeRoot, int data) {
        if (nodeRoot == null) { // creates root node
            return new Node(data);
        }
        if (data < nodeRoot.data) { // if data is < than node goes left
            nodeRoot.left = insert(nodeRoot.left, data);
        } else if (data > nodeRoot.data) { // if data is > than node goes right
            nodeRoot.right = insert(nodeRoot.right, data);
        }
        return nodeRoot; // returns updated tree after data has been inserted
    }

    public boolean findData(int data) { // method to find data in the binary tree
        return search(nodeRoot, data);
    }

    public boolean search(Node nodeRoot, int data) {
        if (nodeRoot == null) { // checks that there is a root node
            return false;
        }
        if (nodeRoot.data == data) { // starts search at root node
            return true;
        } else if (data < nodeRoot.data) { // if data < than node go left
            return search(nodeRoot.left, data);
        } else { // if data > than node go right
            return search(nodeRoot.right, data);
        }
    }

    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();

        myTree.addData(55);
        myTree.addData(35);
        myTree.addData(20);
        myTree.addData(10);
        myTree.addData(60);
        myTree.addData(70);
        myTree.addData(40);

        System.out.println("Is the number 10 in the tree? " + myTree.findData(10));
        System.out.println("Is the number 70 in the tree? " + myTree.findData(70));
        System.out.println("Is the number 90 in the tree? " + myTree.findData(90));
    }
}
