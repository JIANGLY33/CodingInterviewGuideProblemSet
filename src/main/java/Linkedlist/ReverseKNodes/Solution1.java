package Linkedlist.ReverseKNodes;

import java.util.Stack;


//该解法存在问题，不适合所有情况
public class Solution1 {
    public static Node reverseKNodes(Node head, int k) {
        if(k <= 1 || head == null)return head;
        Stack<Node> s = new Stack<>();
        Node node1 = head;
        Node node2 = head;
        Node temp = null;
        head = null;
        while(node1 != null) {
            s.push(node1);
            node1 = node1.next;
            if(s.size() == k){
                while(!s.empty()) {
                    temp = s.pop();
                    temp.next = null;
                    if(head == null){
                        head = temp;
                    }else{
                        node2.next = temp;
                        node2 = node2.next;
                    }
                }
            }
        }
        while(!s.empty() && head != null) {
            temp = s.pop();
            temp.next = null;
            node2.next = temp;
            node2 = node2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n1.value = 1;
        n2.value = 2;
        n3.value = 3;
        n4.value = 4;
        n5.value = 5;
        n6.value = 6;
        Node l1 = n1;
        l1 = reverseKNodes(l1,7);
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
