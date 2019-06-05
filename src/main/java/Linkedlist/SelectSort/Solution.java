package Linkedlist.SelectSort;

public class Solution {

    public static Node sort(Node head) {
        if(head == null)return head;
        Node newHead = null;  //表示要返回的头节点
        Node cur = head;        //表示待排序部分的第一个节点
        Node tail = null;       //表示已排好序部分的最后一个节点
        Node preSmall = null;        //表示待排序部分最小值的前一个节点
        while(cur != null) {
            Node small = cur;
            preSmall = getSmallestPreNode(cur);
            if(preSmall != null) {
                small = preSmall.next;
                preSmall.next = small.next;
            }
            if(tail == null) {
                newHead = small;
            }else {
                tail.next = small;
            }
            cur = small == cur ? cur.next:cur;
            tail = small;
        }
        return newHead;
    }

    public static Node getSmallestPreNode(Node head) {
        if(head == null)return head;
        Node cur = head.next;
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        while(cur != null) {
            if(cur.value < small.value) {
                smallPre = pre;
                small = cur;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return smallPre;
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(4);
        Node n3 = new Node(4);
        Node n4 = new Node(6);
        Node n5 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        Node head = n1;
        head = sort(n1);
        while(head != null) {
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
    }
}