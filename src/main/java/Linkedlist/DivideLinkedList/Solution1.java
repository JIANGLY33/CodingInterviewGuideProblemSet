package Linkedlist.DivideLinkedList;

public class Solution1 {
    public static Node divide(Node head, int pivot) {
        if(head == null || head.next == null)return head;
        int i = 0;
        Node cur = head;
        while(cur != null) {
            i++;
            cur = cur.next;
        }
        cur = head;
        Node[] arr = new Node[i];
        i = 0;
        while(cur != null) {
            arr[i] = cur;
            i++;
            cur = cur.next;
        }
        arr = sortByPivot(arr,pivot);
        for(i = 1; i < arr.length; i++) {
            arr[i-1].next = arr[i];
        }
        arr[i-1].next = null;
        return arr[0];
//        Node cur = head.next;
//        Node nodeP = head;
//        nodeP.next = null;
//        Node middle = null;
//        head = nodeP;
//        while(cur != null) {
//            middle = cur.next;
//            if(cur.value < nodeP.value){
//                if(head == null){
//                    head = cur;
//                    head.next = nodeP;
//                }
//                else {
//                    cur.next = head.next;
//                    head.next = cur;
//                }
//            }
//            else {
//                cur.next = nodeP.next;
//                nodeP.next = cur;
//            }
//            if(nodeP.value == pivot)nodeP = cur;
//            cur = middle;
//        }
//        return head;
    }

    public static Node[] sortByPivot(Node[] arr, int pivot) {
        int index = 0;
        int big = arr.length;
        int small = -1;
        while(index != big) {
            if(arr[index].value < pivot) {
                swap(arr,++small,index++);
            }
            else if( arr[index].value == pivot) index++;
            else {
                swap(arr,--small,index);
            }
        }
        return arr;
    }

    public static void swap(Node[] arr, int a, int b) {
        Node temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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
        n2.value = 2;
        n3.value = 3;
        n4.value = 2;
        n5.value = 1;
        Node cur = divide(n1,3);
        while(cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }
}

class Node {
    public int value;
    public Node next;
}
