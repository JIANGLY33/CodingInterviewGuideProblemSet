package Linkedlist.JudgePalindrome;

import java.util.Stack;

//相比第一种解法减少了需要入栈的元素个数，仅将一半节点压入栈中，然后与另一半节点进行比较
public class Solution2 {
    public static boolean judge(Node head) {
        if(head == null || head.next == null)return true;
        if(head.next.next == null){
            if(head.next == head)return true;
            else return false;
        }
        Node node1 = head;
        Node node2 = head;
        Stack<Node> stack = new Stack<>();
        while(node2.next != null && node2.next.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        //node2.next == null说明有奇数个节点， node2.next.next == null说明节点个数为偶数个
        int halfLength = 0;
        node1 = node1.next;
        while(node1 != null) {
            stack.push(node1);
            halfLength++;
            node1 = node1.next;
        }
        boolean flag = true;
        node1 = head;
        while(halfLength-- != 0) {
            if(stack.pop().value != node1.value) {
                flag = false;
            }
            node1 = node1.next;
        }
        return flag;
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

