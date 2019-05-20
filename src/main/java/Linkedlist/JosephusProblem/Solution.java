package Linkedlist.JosephusProblem;

public class Solution {
    //常规解法，时间复杂度为O(N²)
    public static Node solution1(Node head, int num) {
        //头节点为空或只有一个节点或num<1时直接返回头节点
        if(head == null || head.next == head || num < 1)return head;
        //若num为1返回最后一个节点
        if(num == 1) {
            Node temp = head;
            while(temp.next != head) {
                temp = temp.next;
            }
            temp.next = temp;
            return temp;
        }

        while(head.next != head) {
            //得到报到数的前一个节点
            for(int i = 1; i < num-1; i++) {
                head = head.next;
            }
            //报到数的节点退出
            head.next = head.next.next;
            //下一个节点开始报数
            head = head.next;
        }
        return head;
    }


    //时间复杂度为O(N)的解法，用递推关系式根据环长度和要报的数直接计算出结果
    public static Node soulution2(Node head, int num) {
        if(head == null || head.next == head || num <1)return head;
        Node cur = head;
        int length = 0;
        while(cur != null) {
            length++;
            cur = cur.next;
        }
        int res = getLive(length,num);
        while(--res != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    //新老编号的递推关系式：老编号 = （新编号 + 报数-1）%编号数+1
    public static int getLive(int i , int num ) {
        if(i == 1)return i;
        else return (getLive(i-1,num)+ num -1)% i + 1;
    }
    public static void main(String[] args) {
        Node head = new Node(1,null);
        Node node1 = new Node(2,null);
        Node node2 = new Node(3,null);
        Node node3 = new Node(4,null);
        Node node4 = new Node(5,null);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = head;
        head = solution1(head,6);
        System.out.println(head.value);
    }
}

class Node {
    public int value;
    public Node next;

    public Node() {
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}