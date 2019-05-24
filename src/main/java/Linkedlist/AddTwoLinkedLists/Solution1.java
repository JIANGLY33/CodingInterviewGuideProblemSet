package Linkedlist.AddTwoLinkedLists;

public class Solution1 {
    public static Node add(Node head1,Node head2) {
        Integer h1 = 0;
        Integer h2 = 0;
        while(head1 != null) {
            h1 *= 10;
            h1 += head1.value;
            head1 = head1.next;
        }
        while(head2 != null) {
            h2 *= 10;
            h2 += head2.value;
            head2 = head2.next;
        }
        h1 += h2;
        Node res = null;
        while(h1 != 0) {
            int x = h1 % 10;
            Node rear = new Node();
            rear.value = x;
            rear.next = null;
            h1 /= 10;
            if(res == null){
                res = rear;
            }
            else {
                rear.next = res;
                res = rear;
            }
        }
        return res;
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
        n1.value = 5;
        n2.value = 5;
        n3.value = 5;
        n4.value = 5;
        n5.value = 5;
        Node l1 = n1;
        Node l2 = n1;
        l1 = add(l1,l2);
        while(l1 != null){
            System.out.print(l1.value);
            l1 = l1.next;
        }
        System.out.println();
    }
}

class Node {
    public int value;
    public Node next;
}
