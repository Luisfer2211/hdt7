public class Node {
    String key;
    String value;
    Node left, right;

    public Node(String item, String value) {
        key = item;
        this.value = value;
        left = right = null;
    }
}
