import java.util.*;
import java.io.*;

class Node {
    String key;
    String value;
    Node left, right;

    public Node(String item, String value) {
        key = item;
        this.value = value;
        left = right = null;
    }
}

class BinaryTree {
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

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BinaryTree tree = new BinaryTree();

        Scanner diccionario = new Scanner(new File("diccionario.txt"));
        while (diccionario.hasNext()) {
            String[] words = diccionario.nextLine().replaceAll("[()]", "").split(", ");
            tree.insert(words[0], words[1]);
        }
        diccionario.close();

        tree.inorder();

        Scanner texto = new Scanner(new File("texto.txt"));
        while (texto.hasNext()) {
            String word = texto.next();
            System.out.print(tree.search(word) + " ");
        }
        texto.close();
    }
}
