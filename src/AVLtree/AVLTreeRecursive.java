package AVLtree;

import org.w3c.dom.Node;

public class AVLTreeRecursive <T extends Comparable<T>>{
    public class Node{
        public int bf;

        // The value/data contained within the node.
        public T value;

        // The height of this node in the tree.
        public int height;

        // The left and the right children of this node.
        public Node left, right;

        public Node(T value) {
            this.value = value;
        }

    }

    public Node root;

    // Tracks the number of nodes inside the tree.
    private int nodeCount = 0;

    // The height of a rooted tree is the number of edges between the tree's
    // root and its furthest leaf. This means that a tree containing a single
    // node has a height of 0.
    public int height() {
        if (root == null) return 0;
        return root.height;
    }

    // Returns the number of nodes in the tree.
    public int size() {
        return nodeCount;
    }

    // Returns whether or not the tree is empty.
    public boolean isEmpty() {
        return size() == 0;
    }

    // Return true/false depending on whether a value exists in the tree.
    public boolean contains(T value) {
        return contains(root, value);
    }

    // Recursive contains helper method.
    private boolean contains(Node node, T value) {
        if (node == null) return false;

        // Compare current value to the value in the node.
        int cmp = value.compareTo(node.value);

        // Dig into left subtree.
        if (cmp < 0) return contains(node.left, value);

        // Dig into right subtree.
        if (cmp > 0) return contains(node.right, value);

        // Found value in tree.
        return true;
    }

    // Insert/add a value to the AVL tree. The value must not be null, O(log(n))
    public boolean insert(T value) {
        if (value == null) return false;
        if (!contains(root, value)) {
            root = insert(root, value);
            nodeCount++;
            return true;
        }
        return false;
    }

    // Inserts a value inside the AVL tree.
    private Node insert(Node node, T value) {
        // Base case.
        if (node == null) return new Node(value);

        // Compare current value to the value in the node.
        int cmp = value.compareTo(node.value);

        // Insert node in left subtree.
        if (cmp < 0) {
            node.left = insert(node.left, value);

            // Insert node in right subtree.
        } else {
            node.right = insert(node.right, value);
        }

        // Update balance factor and height values.
        update(node);

        // Re-balance tree.
        return balance(node);
    }

    // Update a node's height and balance factor.
    private void update(Node node) {
        int leftNodeHeight = (node.left == null) ? -1 : node.left.height;
        int rightNodeHeight = (node.right == null) ? -1 : node.right.height;

        // Update this node's height.
        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);

        // Update balance factor.
        node.bf = rightNodeHeight - leftNodeHeight;
    }

    // Re-balance a node if its balance factor is +2 or -2.
    private Node balance(Node node) {
        // Left heavy subtree.
        if (node.bf == -2) {

            // Left-Left case.
            if (node.left.bf <= 0) {
                return leftLeftCase(node);

                // Left-Right case.
            } else {
                return leftRightCase(node);
            }

            // Right heavy subtree needs balancing.
        } else if (node.bf == +2) {

            // Right-Right case.
            if (node.right.bf >= 0) {
                return rightRightCase(node);

                // Right-Left case.
            } else {
                return rightLeftCase(node);
            }
        }

        // Node either has a balance factor of 0, +1 or -1 which is fine.
        return node;
    }

    private Node leftLeftCase(Node node) {
        return rightRotation(node);
    }

    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return leftLeftCase(node);
    }

    private Node rightRightCase(Node node) {
        return leftRotation(node);
    }

    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return rightRightCase(node);
    }

    private Node leftRotation(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        update(node);
        update(newParent);
        return newParent;
    }

    private Node rightRotation(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        update(node);
        update(newParent);
        return newParent;
    }

    // Remove a value from this binary tree if it exists, O(log(n))
    public boolean remove(T elem) {
        if (elem == null) return false;

        if (contains(root, elem)) {
            root = remove(root, elem);
            nodeCount--;
            return true;
        }

        return false;
    }

    // Removes a value from the AVL tree.
    private Node remove(Node node, T elem) {
        if (node == null) return null;

        int cmp = elem.compareTo(node.value);

        // Dig into left subtree, the value we're looking
        // for is smaller than the current value.
        if (cmp < 0) {
            node.left = remove(node.left, elem);

            // Dig into right subtree, the value we're looking
            // for is greater than the current value.
        } else if (cmp > 0) {
            node.right = remove(node.right, elem);

            // Found the node we wish to remove.
        } else {

            // This is the case with only a right subtree or no subtree at all.
            // In this situation just swap the node we wish to remove
            // with its right child.
            if (node.left == null) {
                return node.right;

                // This is the case with only a left subtree or
                // no subtree at all. In this situation just
                // swap the node we wish to remove with its left child.
            } else if (node.right == null) {
                return node.left;

                // When removing a node from a binary tree with two links the
                // successor of the node being removed can either be the largest
                // value in the left subtree or the smallest value in the right
                // subtree. As a heuristic, I will remove from the subtree with
                // the greatest hieght in hopes that this may help with balancing.
            } else {

                // Choose to remove from left subtree
                if (node.left.height > node.right.height) {

                    // Swap the value of the successor into the node.
                    T successorValue = findMax(node.left);
                    node.value = successorValue;

                    // Find the largest node in the left subtree.
                    node.left = remove(node.left, successorValue);

                } else {

                    // Swap the value of the successor into the node.
                    T successorValue = findMin(node.right);
                    node.value = successorValue;

                    // Go into the right subtree and remove the leftmost node we
                    // found and swapped data with. This prevents us from having
                    // two nodes in our tree with the same value.
                    node.right = remove(node.right, successorValue);
                }
            }
        }

        // Update balance factor and height values.
        update(node);

        // Re-balance tree.
        return balance(node);
    }

    // Helper method to find the leftmost node (which has the smallest value)
    private T findMin(Node node) {
        while (node.left != null) node = node.left;
        return node.value;
    }

    // Helper method to find the rightmost node (which has the largest value)
    private T findMax(Node node) {
        while (node.right != null) node = node.right;
        return node.value;
    }
    void pri(){
        Node n=root;
        print(root);
    }

public void print(Node n){
        if(n==null)return;
        print(n.left);
    System.out.println(n.value);
    print(n.right);
}
    public static void main(String[] args) {
        AVLTreeRecursive<Integer>a=new AVLTreeRecursive<>();
        a.insert(5);
        a.insert(7);
        a.insert(4);
        a.insert(3);
        a.insert(2);
        a.insert(1);
        a.pri();
    }
}
