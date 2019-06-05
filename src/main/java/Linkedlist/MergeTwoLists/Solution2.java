package Linkedlist.MergeTwoLists;

public class Solution2 {
    public static Node merge(Node node1, Node node2) {
        if(node1 == null || node2 == null)return node1 == null?node1:node2;
        Node head = node1.value < node2.value ? node1:node2;
        Node cur1 = node1 == head ? node1:node2;
        Node cur2 = node1 == head ? node2:node1;
        Node pre = null;
        Node next = null;
        while(cur1 != null && cur2 != null ){
            if(cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            }
            else {
                next = cur2.next;
                cur2.next = cur1;
                pre.next = cur2;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2:cur1;
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(2);
        Node n5 = new Node(4);
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
