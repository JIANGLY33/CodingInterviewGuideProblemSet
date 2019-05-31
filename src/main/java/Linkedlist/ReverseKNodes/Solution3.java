package Linkedlist.ReverseKNodes;

import java.util.Stack;

public class Solution3 {
    public static Node reverseKNodes(Node head, int k) {
        if(k < 2)return head;
        Stack<Node> s = new Stack<>();
        Node newHead = head;
        Node pre = null;  //下一组k个节点的前一个节点
        Node next = null; //当前节点的后一个节点
        Node cur = head;  //当前节点
        while(cur != null) {
            next = cur.next;
            s.push(cur);
            if(s.size() == k) {
                pre = resign(s,pre,next);
                newHead = pre == null? cur:newHead;
            }
            cur = next;
        }
        return newHead;
    }

    public static Node resign(Stack<Node> s, Node left, Node right) {
        Node cur = s.pop();
        if(left != null) {
            left.next = cur;
        }
        Node next = null;
        while(! s.empty()) {
            next = s.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;

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
