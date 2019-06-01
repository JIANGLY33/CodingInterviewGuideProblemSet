package Linkedlist.DeleteRepeatNodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution1 {
    public static Node deleteRepeatNodes(Node head) {
        if(head == null)return head;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.value);
        Node cur = head.next;
        Node pre = head;
        while(cur != null) {
            if(set.contains(cur.value)) {
                pre.next = cur.next;
                cur = pre.next;
            }else {
                set.add(cur.value);
                cur = cur.next;
                pre = pre.next;
            }
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
        n1.value = 4;
        n2.value = 4;
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

class Node {
    public int value;
    public Node next;
}
