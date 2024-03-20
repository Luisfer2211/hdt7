import java.util.*;
import java.io.*;

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
