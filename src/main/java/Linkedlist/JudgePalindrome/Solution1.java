package Linkedlist.JudgePalindrome;


import java.util.Stack;

//时间复杂度为O(N),空间复杂度为O(N)的解法，利用了栈结构
public class Solution1 {

    public static boolean judge(Node head) {
        if(head == null || head.next == null)return true;
        Stack<Node> stack = new Stack<>();
        boolean res = true;
        Node cur = head;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while(!stack.empty()) {
            if(stack.pop().value != cur.value )res = false;
            cur = cur.next;
        }
        return res;
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
        n4.value = 2;
        n5.value = 1;
        Node cur = n1;
        System.out.println(judge(cur));
    }
}


class Node {
    public int value;
    public Node next;
}
