package Linkedlist.CopyRandomNode;


//利用多个变量配合链表的灵活性解题，时间复杂度为O(N),空间复杂度为O(1)
public class Solution2 {
    public static Node copy(Node head) {
        if(head == null || head.next == null)return head;
        Node cur = head;
        while(cur != null) {
            Node newNode = new Node(cur.value);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        cur = head;
        Node next = cur.next;
        while(next != null) {
            next.random = cur.random.next;
            cur = next.next;
            next = cur.next;
        }
        Node res = head.next;
        next = head.next;
        cur = head;
        while(next != null) {
            cur.next = next.next;
            cur = cur.next;
            next = cur.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        n1.random = n3;
        n2.random = null;
        n3.random = n4;
        n4.random = n5;
        n5.random = n1;
        Node l1 = n1;
        while(l1 != null) {
            System.out.println(l1);
            l1 = l1.next;
        }
        Node l2 = copy(n1);
        while(l2 != null) {
            System.out.println(l2);
            l2 = l2.next;
        }

    }
}
