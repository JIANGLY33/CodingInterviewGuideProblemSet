package Linkedlist.JudgePalindrome;

//相比前两种方案，进一步减少了空间复杂度。空间复杂度为O(1)

/**
 * 思路简述：先用得到链表的中间节点，再创捷一个新节点，以新节点为头节点逆置后半部分链表并记录链表长度。再从原链表和逆置
 *           链表的头节点开始同步遍历，一边遍历一边互相比较两个链表中的值是否相等，遍历的节点个数等于先前记录的后半部分
 *           链表的长度，若存在不相等的值则原链表并非回文。
 */
public class Solution3 {
    public static boolean judge(Node head) {
        if(head == null || head.next == null)return true;
        if(head.next.next == null){
            if(head.next.value == head.value)return true;
            else return false;
        }
        Node node1 = head;
        Node node2 = head;
        while(node1.next != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        node2 = node1.next;
        node1.next = null;   //这一步至关重要，后续的两次遍历都以这一步设置的null作为判断是否结束的标准
        Node node3 = null;
        while(node2 != null){
            node3 = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = node3;
        }
        boolean res =true;
        node3 = node1;  //用node3保存最后一个节点
        node2 = head;
        while(node1 != null && node2 != null) {
            if(node2.value != node1.value){
                res = false;
                break;
            }
            node2 = node2.next;
            node1 = node1.next;
        }
        node1 = node3.next;
        node3.next = null;
        while(node1 != null) {    //把先前逆置的后半部分恢复回来
            node2 = node1.next;
            node1.next = node3;
            node3 = node1;
            node1 = node2;
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
        n2.value = 3;
        n3.value = 3;
        n4.value = 2;
        n5.value = 1;
        Node cur = n1;
        System.out.println(judge(cur));
    }
}
