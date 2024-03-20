public class BinaryTree {
    Node root;

    void insert(String key, String value) {
        root = insertRec(root, key, value);
    }

    Node insertRec(Node root, String key, String value) {
        if (root == null) {
            root = new Node(key, value);
            return root;
        }
        if (key.compareToIgnoreCase(root.key) < 0)
            root.left = insertRec(root.left, key, value);
        else if (key.compareToIgnoreCase(root.key) > 0)
            root.right = insertRec(root.right, key, value);
        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("(" + root.key + ", " + root.value + ")");
            inorderRec(root.right);
        }
    }

    String search(String key) {
        return searchRec(root, key);
    }

    String searchRec(Node root, String key) {
        if (root == null || root.key.equalsIgnoreCase(key))
            return root != null ? root.value : "*" + key + "*";
        if (root.key.compareToIgnoreCase(key) > 0)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }
}
