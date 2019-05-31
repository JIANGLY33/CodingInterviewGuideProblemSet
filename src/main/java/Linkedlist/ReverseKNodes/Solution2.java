package Linkedlist.ReverseKNodes;

public class Solution2 {
    public static Node reverseKNodes(Node head, int k) {
        if(k < 2 )return head;
        Node cur = head;
        Node start = null;
        Node  pre = null;
        Node next = null;
        int count = 1;
        while(cur != null) {
            next = cur.next;
            if(count == k) {
                start = pre == null ? head:pre.next;
                head = pre == null ? cur:head;
                resign(pre,start,cur,next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    public static void resign(Node left, Node start, Node end, Node right) {
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while(cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if(left != null) {
            left.next = end;
        }
        start.next = right;
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
        Node l1 = n1;
        l1 = reverseKNodes(l1,2);
        while(l1 != null){
            System.out.print(l1.value);
            l1 = l1.next;
        }
        System.out.println();
    }
}
