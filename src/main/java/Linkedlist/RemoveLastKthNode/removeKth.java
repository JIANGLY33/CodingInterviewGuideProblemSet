package Linkedlist.RemoveLastKthNode;

/** 题目：分别实现两个函数，一个可以删除单链表中倒数第K个节点，另一个可以删除双链表中
 *  倒数第K个节点。
 */

public class removeKth {
    public Node removeKthNode(Node head,int k) {
        if(head == null || k < 1)return head;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            k--;
        }
        if(k > 0)return head;
        else if(k == 0)return head.next;
        else {
            temp = head;
            while(++k != 0) { //如果这里是K++的话，当k=0时，temp将会是第N-k+1个节点
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return head;
    }

    public DNode removeKthDNode(DNode head, int k) {
        if(head == null || k < 1)return head;
        DNode temp = head;
        while(temp != null) {
            temp = temp.rear;
            k--;
        }
        if(k > 0)return head;
        else if(k == 0)return head.rear;
        else {
            temp = head;
            while(++k != 0) { //如果这里是K++的话，当k=0时，temp将会是第N-k+1个节点
                temp = temp.rear;
            }
            //temp.rear.rear.head = temp;  如果temp.rear.rear为null则这种方式失效
            if(temp.rear.rear != null)temp.rear.rear.head = temp;
            temp.rear = temp.rear.rear;
        }
        return head;
    }
}

class Node{
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }
}

class DNode {
    public int value;
    public DNode head;
    public DNode rear;

    public DNode(int value) {
        this.value = value;
        head = null;
        rear = null;
    }
}