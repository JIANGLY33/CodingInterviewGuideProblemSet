package Linkedlist.ReverseLinkedList;

public class LinkedList {
    public static Node reverse(Node head) {
        if(head == null || head.next == null)return head;
        Node cur = head.next;
        head.next = null;
        while(cur != null ) {
            Node temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        n1.value = 1;
        n2.value = 2;
        n3.value = 3;
        n4.value = 4;
        n5.value = 5;
        Node cur = n1;
        n1 = reverse(n1);

        while(n1 != null) {
            System.out.println(n1.value);
            n1 = n1.next;
        }
    }
}

class Node{
    public int value;
    public Node  next;
}
