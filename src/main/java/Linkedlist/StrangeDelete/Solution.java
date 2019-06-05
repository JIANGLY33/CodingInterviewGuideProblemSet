package Linkedlist.StrangeDelete;

public class Solution {
    public static void delete(Node node) {
        if(node == null )return;
        Node next = node.next;
        if(next == null) {
            throw  new RuntimeException("Delete failed!");
        }
        node.value = next.value;
        node.next = next.next;
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
}
