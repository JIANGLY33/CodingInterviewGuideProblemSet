package Linkedlist.AddTwoLinkedLists;

import java.util.Stack;

public class Solution2 {
    public static Node add(Node head1, Node head2) {
        Stack<Integer> h1 = new Stack<>();
        Stack<Integer> h2 = new Stack<>();
        Node cur = head1;
        while(cur != null) {
            h1.push(cur.value);
            cur = cur.next;
        }
        cur = head2;
        while(cur != null) {
            h2.push(cur.value);
            cur = cur.next;
        }
        int carry = 0;
        Node res = null;
        while(!h1.empty() || !h2.empty()) {
            int temp = 0;
            if(!h1.empty())temp += h1.pop();
            if(!h2.empty())temp += h2.pop();
            temp += carry;
            if(temp >= 10) {
                carry = 1;
                temp %= 10;
            }
            else carry = 0;
            Node newNode = new Node();
            newNode.value = temp;
            newNode.next = res;
            res = newNode;
        }
        if(carry == 1) {
            Node newNode = new Node();
            newNode.value = carry;
            newNode.next = res;
            res = newNode;
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
        n1.value = 5;
        n2.value = 5;
        n3.value = 4;
        n4.value = 5;
        n5.value = 5;
        Node l1 = n1;
        Node l2 = n1;
        l1 = add(l1,l2);
        while(l1 != null){
            System.out.print(l1.value);
            l1 = l1.next;
        }
        System.out.println();
    }
}
