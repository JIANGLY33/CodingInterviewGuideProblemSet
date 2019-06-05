package Linkedlist.CircleListInserion;

public class Solution {
    public static Node insert(Node head, int value) {
        Node newNode = new Node(value);
        if(head == null){
            newNode.next = newNode;
            return newNode;
        }
        Node cur = head.next;
        Node pre = head;
        while(cur != head) {
            if(value <= cur.value && value >= pre.value)break;  //由前后两个节点确认插入的位置
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = newNode;
        newNode.next = cur;
        return value < head.value ? newNode:head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(2);
        Node n2 = new Node(4);
        Node n3 = new Node(4);
        Node n4 = new Node(6);
        Node n5 = new Node(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n1;
        Node head = n1;
        head = insert(n1,5);
        while(head != n5) {
            System.out.println("value: " + head.value);
            head = head.next;
        }
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }
}