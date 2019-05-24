package Linkedlist.DivideLinkedList;

public class Solution2 {
    public static Node divide(Node head, int pivot) {
        Node sH = null;
        Node sR = null;
        Node eH = null;
        Node eR = null;
        Node bH = null;
        Node bR = null;
        Node next = null;
        while(head != null) {
            next = head.next;
            head.next = null;
            if(head.value < pivot) {
                if(sH == null) {
                    sH = head;
                    sR = head;
                }
                else {
                    sR.next = head;
                    sR = head;
                }
            }
            else if(head.value == pivot) {
                if(eH == null) {
                    eH = head;
                    eR = head;
                }
                else {
                    eR.next = head;
                    eR = head;
                }
            }
            else {
                if(bH == null) {
                    bH = head;
                    bR = head;
                }
                else {
                    bR.next = head;
                    bR = head;
                }
            }
            head = next;
        }
        if(sR != null){
            sR.next = eH;
            eR = eR == null ? sR:eR; //若不存在相等链表，则让相等链表的尾节点等于小于链表的尾节点
        }
        if(eR != null) eR.next = bH; //若eR为null，则说明相等链表和小于链表均为空

        return sH != null ? sH : eH != null ? eH:bH;
    }
}
