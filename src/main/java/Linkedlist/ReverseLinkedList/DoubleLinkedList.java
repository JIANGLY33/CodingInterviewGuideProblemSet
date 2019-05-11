package Linkedlist.ReverseLinkedList;

public class DoubleLinkedList {
    public static DNode reverse(DNode head) {
        if(head == null || head.next == null)return head;
        DNode cur = head.next;
        head.next = null;
        while(cur != null) {
            cur.front = null;
            DNode temp = cur.next;
            cur.next = head;
            head.front = cur;
            head = cur;
            cur = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        DNode n1 = new DNode();
        DNode n2 = new DNode();
        DNode n3 = new DNode();
        DNode n4 = new DNode();
        DNode n5 = new DNode();
        n1.next = n2;
        n1.front = null;
        n2.front = n1;
        n2.next = n3;
        n3.front = n2;
        n3.next = n4;
        n4.front = n3;
        n4.next = n5;
        n5.front = n4;
        n5.next = null;
        n1.value = 1;
        n2.value = 2;
        n3.value = 3;
        n4.value = 4;
        n5.value = 5;
        DNode cur = n1;
        n1 = reverse(n1);
        while(n1 != null) {
            System.out.println(n1.value);
            n1 = n1.next;
        }
    }
}

class DNode {
    public int value;
    public DNode front;
    public DNode next;
}
