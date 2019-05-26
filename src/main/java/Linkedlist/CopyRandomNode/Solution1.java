package Linkedlist.CopyRandomNode;

import java.util.HashMap;
import java.util.Map;

//利用哈希表完成，时间复杂度和空间复杂度均为O(N)
public class Solution1 {
    public static Node copy(Node head) {
        Map<Node,Node> nodes = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            Node newNode = new Node(cur.value);
            nodes.put(cur,newNode);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            Node temp = nodes.get(cur);
            temp.next = nodes.get(cur.next);
            temp.random = nodes.get(cur.random);
            cur = cur.next;
        }
        return nodes.get(head);
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

class Node {
    int value;
    Node next;
    Node random;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String res = "value: " + value;
        if(next!=null) res += (",next: " + next.hashCode() + ",next-value: " + next.value);
        else res += (",next: null" );
        if(random!=null) res += (",random: " + random.hashCode()+ ",random-value: " + random.value);
        else res += (",random: null" );
        return res;
    }
}
