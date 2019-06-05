package Linkedlist.MergeTwoLists;

public class Solution1 {
    public static Node merge(Node node1, Node node2) {
       if(node1 == null || node2 == null)return node1 == null?node2:node1;
        Node head = null;
        Node cur = null;
        Node small = null;
        while(node1 != null && node2 != null) {
           small = node1.value < node2.value ? node1:node2;
           if(head == null) {
               head = small;
               cur = small;
           }
           else {
               cur.next = small;
               cur = cur.next;
           }
           if(node1.value < node2.value)node1 = node1.next;
           else node2 = node2.next;
        }
       if(node1 != null)cur.next = node1;
       else cur.next = node2;
       return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(2);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(2);
        Node n5 = new Node(2);
        n1.next = n2;
        n2.next = null;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        Node l1 = n1;
        Node l2 = n3;
        l1 = merge(l1,l2);
        while(l1 != null){
            System.out.print(l1.value + " ");
            l1 = l1.next;
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
