package Linkedlist.IntersectNode;

public class Solution {

    public static Node getIntersectNode(Node head1, Node head2) {
        if(head1 == null || head2 == null)return null;
        Node circleN1 = judgeAndGetCircleNode(head1);
        Node circleN2 = judgeAndGetCircleNode(head2);
        //两个入环节点均不为null，说明两个单链表均有环
        if(circleN1 != null && circleN2 != null){
            return getIntersectNodeWithCircle(head1,circleN1,head2,circleN2);
        }
        // 两个入环节点均为null，说明两个单链表均无环
        else if(circleN1 == null && circleN2 == null) {
            return getIntersectNodeWithoutCircle(head1,head2);
        }
        else return null;  //一个单链表有环，另一个单链表无环说明两个单链表一定不相交
    }

    public static  Node judgeAndGetCircleNode(Node head) {
        if(head.next == null || head.next.next == null)return null;
        Node n1 = head.next;
        Node n2 = head.next.next;
        while(n1 != n2) {
            if(n2.next == null || n2.next.next == null)return null;
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while(n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static Node getIntersectNodeWithCircle(Node head1, Node circleNode1, Node head2, Node circleNode2) {
        //当入环节点相同时，说明相交节点在入环节点之前或者入环节点即为相交节点
        if(circleNode1 == circleNode2) {
            Node temp1 = head1;
            Node temp2 = head2;
            int n = 0;
            while(temp1 != circleNode1) {
                n++;
                temp1 = temp1.next;
            }
            while(temp1 != circleNode2) {
                n--;
                temp2 = temp2.next;
            }
            temp1 = n > 0 ? head1:head2;
            temp2 = temp1 == head1 ? head2:head1;
            n = Math.abs(n);
            while(n != 0) {
                temp1 = temp1.next;
                n--;
            }
            while(temp1 != temp2) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return temp1;
        }
        //入环节点不相同则说明相交节点在环内或者两个单链表不相交
        else {
            Node check = circleNode1.next;
            while (check != circleNode1) {
                if (check == circleNode2) return check;
                check = check.next;
            }
            return null;
        }
    }

    public static Node getIntersectNodeWithoutCircle(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        int length1 = 1, length2 = 1;
        while(temp1.next != null) {
            length1++;
            temp1 = temp1.next;
        }
        while(temp2.next != null) {
            length2++;
            temp2 = temp2.next;
        }
        if(temp1 == temp2) {
            int cmp = length1 - length2;
            temp1 = head1;
            temp2 = head2;
            if(cmp > 0) {
                for(int i = cmp; i != 0; i--) {
                    temp1 = temp1.next;
                }
            }
            else{
                for(int i = cmp; i != 0; i++) {
                    temp2 = temp2.next;
                }
            }
            while(temp1 != temp2) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return temp1;
        }
        else return null;
    }


    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        Node n6 = new Node();
        Node n7 = new Node();
        Node n8 = new Node();
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;
        n6.next = n7;
        n7.next = n8;
        n8.next = n5;
        n1.value = 1;
        n2.value = 2;
        n3.value = 3;
        n4.value = 4;
        n5.value = 5;
        n6.value = 6;
        n7.value = 7;
        n8.value = 8;
        Node l1 = getIntersectNode(n1,n6);
        System.out.println(l1);
    }
}


class Node {
    public int value;
    public Node next;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next.value + ", " + next.hashCode() +
                '}';
    }
}