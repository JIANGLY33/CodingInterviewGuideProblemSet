package Linkedlist.DeleteCertainNode;


import java.util.Stack;

/**
 * 解题思路：遍历链表，将值不等于给定值的节点压入堆栈，遍历完毕后从堆栈依次弹出节点，并用头插法得到结果链表
 * 复杂度：时间复杂度为O(N),空间复杂度也为O(N)
 */
public class Solution1 {
    public static Node deleteNodes(Node head, int value) {
        Stack<Node> nodes = new Stack<>();
        while(head != null) {
            if(head.value != value)nodes.push(head);
            head = head.next;
        }
        while(! nodes.isEmpty()) {
            Node temp = nodes.pop();
            if(head == null){
                head = temp;
                head.next = null;
            }
            else {
                temp.next = head;
                head = temp;
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
        n1.value = 1;
        n2.value = 4;
        n3.value = 4;
        n4.value = 6;
        n5.value = 4;
        Node head = n1;
        head = deleteNodes(n1,4);
        while(head != null) {
            System.out.println("value: " + head.value);
            head = head.next;
        }
    }
}


class Node {
    public int value;
    public Node next;
}
