package Linkedlist.DeleteCertainNode;

import java.util.Stack;

/**
 * 与解法一思路并无二致，是书中给出的实现，代码更加简洁
 */
public class Solution3 {
    public static Node deleteNodes(Node head, int value) {
        Stack<Node > nodes = new Stack<>();
        while(head != null) {
            if(head.value != value) nodes.push(head);
            head = head.next;
        }
        while(!nodes.empty()) {
            nodes.peek().next = head;
            head = nodes.pop();
        }
        return head;
    }
}
