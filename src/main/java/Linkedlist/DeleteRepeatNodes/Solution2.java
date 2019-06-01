package Linkedlist.DeleteRepeatNodes;

public class Solution2 {

    public static Node deleteRepeatNodes(Node head) {
        if(head == null)return null;
        Node cur = head;
        while(cur != null) {
            Node check = cur.next;
            Node pre = cur;
            while(check != null) {
                if(check.value == cur.value) {
                    pre.next = check.next;
                    check = pre.next;
                }else {
                    check = check.next;
                    pre = pre.next;
                }
            }
            cur  = cur.next;
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
        n3.value = 4;
        n4.value = 4;
        n5.value = 4;
        Node cur = n1;
        cur = deleteRepeatNodes(n1);
        while(cur != null) {
            System.out.println("value: " + cur.value);
            cur = cur.next;
        }
    }
}
