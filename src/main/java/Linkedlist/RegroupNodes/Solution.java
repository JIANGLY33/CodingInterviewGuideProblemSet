package Linkedlist.RegroupNodes;

public class Solution {
    public static Node regroup(Node head) {
        if(head == null || head.next == null || head.next.next == null)return head;
        Node node1 = head;
        Node node2 = head;
        Node pre = null;
        while (node2.next != null && node2.next.next != null) {
            pre = node1;
            node1 = node1.next;
            node2 = node2.next.next;
        }
        if(node2.next == null){
            pre.next = null;
            node2 = node1;
        }
        else if(node2.next.next == null){
            node2 = node1.next;
            pre.next.next = null;
        }
        node1 = head;
        while(node1.next != null) {
            Node temp = node2.next;
            node2.next = node1.next;
            node1.next = node2;
            node1 = node2.next;
            node2 = temp;
        }
        node1.next = node2;
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        Node cur = regroup(n3);
        while(cur != null) {
            System.out.println(cur.value + " ");
            cur = cur.next;
        }
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }
}