package Linkedlist.ReversePartialLinkedList;

public class Solution {
    public static Node reverse(Node head,int from, int to) {
         Node node = head;
         Node fpre = null;
         Node brear = null;
         int length = 0;
         while(node != null) {
             length++;
             fpre = length == from - 1 ? node : fpre;
             brear = length == to + 1 ? node : brear;
             node = node.next;
         }
         if(from < 1 || from > to || to > length)return head;
         node = fpre == null ? head:fpre.next;
         Node node2 = node.next;
         node.next =  brear;
         Node temp = null;
         while(node2 != brear) {
             temp = node2.next;
             node2.next= node;
             node = node2;
             node2 = temp;
         }
         if(fpre != null) {
             fpre.next = node;
             return head;
         }
         return node;
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
        n1 = reverse(n1,2,4);
        while(n1 != null) {
            System.out.println(n1.value);
            n1 = n1.next;
        }
    }
}

class Node {
    public int value;
    public Node next;
}
