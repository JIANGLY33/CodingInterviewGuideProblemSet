package Linkedlist.DeleteCertainNode;

/**
 * 解题思路：遍历链表直接删去链表中值与给定值相同的节点
 * 复杂度：时间复杂度为O(N),空间复杂度为O(1)
 * 注意点：要区分两种情况进行处理：1.要删除的值与头节点的值相等  2.要删除的值与非头节点的值相等
 */
public class Solution2 {
    public static Node deleteNodes(Node head, int value) {
        while(head != null && head.value == value) {
            head = head.next;
        }
        if(head == null)return head;
        Node cur = head.next;
        Node pre = head;
        while(cur != null) {
            if(cur.value == value) {
                pre.next = cur.next;
            }else {
                pre = pre.next;
            }
            cur = cur.next;
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
        n1.value = 4;
        n2.value = 4;
        n3.value = 2;
        n4.value = 4;
        n5.value = 4;
        Node cur = n1;
         cur = deleteNodes(cur,4);
        while(cur != null) {
            System.out.println("value: " + cur.value);
            cur = cur.next;
        }
    }
}
