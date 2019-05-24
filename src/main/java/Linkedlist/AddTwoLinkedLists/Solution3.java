package Linkedlist.AddTwoLinkedLists;

public class Solution3 {
    public static Node add(Node head1, Node head2) {
       head1 = reverse(head1);
       head2 = reverse(head2);
       Node res = null;
       int carry = 0;
       while(head1 != null || head2 != null) {
           int temp = 0;
           if(head1 != null) {
               temp += head1.value;
               head1 = head1.next;
           }
           if(head2 != null) {
               temp += head2.value;
               head2 = head2.next;
           }
           temp += carry;
           if(temp >= 10) {
               carry = 1;
               temp %= 10;
           }
           else {
               carry = 0;
           }
           Node newNode = new Node();
           newNode.value = temp;
           newNode.next = res;
           res = newNode;
       }
       if(carry == 1) {
           Node newNode = new Node();
           newNode.value = carry;
           newNode.next = res;
           res = newNode;
       }
       return res;
    }

    public static Node reverse(Node head) {
        if(head == null || head.next == null)return head;
        Node cur = head.next;
        head.next = null;
        Node next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
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
        n1.value = 5;
        n2.value = 5;
        n4.value = 5;
        n5.value = 5;
        Node l1 = n1;
        Node l2 = n3;
        l1 = add(l1,l2);
        while(l1 != null){
            System.out.print(l1.value);
            l1 = l1.next;
        }
        System.out.println();
    }
}
