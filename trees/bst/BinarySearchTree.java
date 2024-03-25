package trees.bst;

class BinarySearchTree {

    static class node {
        int value;
        node left;
        node right;
    }

    //function to create a new node with a provided value;
    static node newNode(int item) {
        node temp = new node();
        temp.value = item;
        temp.left = temp.right = null;
        return temp;
    }

    //function to insert a new node with given value into the tree.
    static node insert(node root, int value) {
        if (root == null) {
            return newNode(value);
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    //Inorder traversal of the binary tree.
    static void inorder(node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);
    }

    //Preorder traversal of the tree
    static void preorder(node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preorder(root.left);
        preorder(root.right);
    }

    //Postorder traversal of the tree
    static void postorder(node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.value);
    }

    //Get the height of the BST
    static int height(node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = height(root.left);
        int rightDepth = height(root.right);
        if (leftDepth > rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }

    //Print nodes at given level
    static void printGivenLevel(node root, int level) {
        if (root == null) {
            return;
        }
        //Means gradual reduction till I get to 1, then print at that level,
        //else continue to traverse and reducing the level value
        if (level == 1) {
            System.out.println(root.value);
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    //level order traversal, print values level by level
    static void levelOrder(node root) {
        int height = height(root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    //function to print leaf nodes from left to right
    static void printAllLeafNodes(node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.println(root.value);
        }
        if (root.left != null) {
            printAllLeafNodes(root.left);
        }
        if (root.right != null) {
            printAllLeafNodes(root.right);
        }
    }

    //Print all non null nodes
    static void printNonNullNodes(node root) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            System.out.println(root.value);
        }

        if (root.left != null) {
            printNonNullNodes(root.left);
        }
        if (root.right != null) {
            printNonNullNodes(root.right);
        }
    }

    //Print right view of BST
    static void printRightViewNodes(node root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        if(root.right != null){
            printRightViewNodes(root.right);
        };
    }

    //function to return the minimum value node
    static node minValueNode(node root){
        node current = root;

        while(current.right != null && current.left != null){
            current = current.left;
        }
        return current;
    }

    //function that deletes the key and returns the new root.
    static node deleteNode(node root){
        //TODO: impl delete node algos
        return root;
    }


    // Driver Code
    public static void main(String[] args) {

        /* Let us create following BST
                50
             /     \
            30      70
           /  \    /  \
         20   40  60   80
     */
        node root = null;

        // inserting value 50
        root = insert(root, 50);

        // inserting value 30
        insert(root, 30);

        // inserting value 20
        insert(root, 20);

        // inserting value 40
        insert(root, 40);

        // inserting value 70
        insert(root, 70);

        // inserting value 60
        insert(root, 60);

        // inserting value 80
        insert(root, 80);

        // print the BST
        System.out.println(minValueNode(root).value);
    }


}
