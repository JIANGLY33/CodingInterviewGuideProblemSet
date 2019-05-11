package Linkedlist.DeleteMidNode;

public class Solution {
    /**
     *此题为一次遍历找出链表中间节点的变体，如果n1，n2同时从第一个节点出发，那么当n2到达终点（此处的终点并不一定
     * 是最后一个节点，n2无法再往后走即为到达终点，因此n2也可能在倒数第二个节点）时，n1恰好在链表中间节点处。
     * 本题要求删除中间节点，因此到n2抵达终点时，n1要在中间节点的前一个节点，故n2在开始的时候并非和n1在同一点出发
     * 而是n2先走了一步（n2的一步即两个节点）。
     */
    public static Node deleteMid(Node head) {
        if(head == null)return null;
        if(head.next == null)return head;
        if(head.next.next == null)return head.next;

        Node n1 = head;
        Node n2 = head.next.next;
        while(n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n1.next = n1.next.next;
        return head;
    }

    /**
     *先遍历链表得到链表长度，再计算出要删除的是第几个节点。我们用target表示要被删除的节点的前一个节点
     * 的序号。在计算被删除节点序号时我们需要利用Math.ceil(),但该函数的参数是double，而我们的参数大多是int，
     * 因此在传入后需要进行强制类型转换。
     */
    public static Node deleteAB(Node head, int a, int b) {
        int length = 0;
        Node cur = head;
        while(cur != null){
            cur = cur.next;
            length++;
        }
        int target = (int)Math.ceil((double)length*a /b-1);  //要删除节点的前一个节点的位置
        if(target <= 0)return head.next;
        cur = head;
        while(target > 1 ) {
            cur = cur.next;
            target--;
        }
        cur.next = cur.next.next;
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
        n1.value = 1;
        n2.value = 2;
        n3.value = 3;
        n4.value = 4;
        n5.value = 5;
        Node cur = n1;
//        deleteMid(n1);
        n1 = deleteAB(n1,2,4);
        while(n1 != null) {
            System.out.println(n1.value);
            n1 = n1.next;
        }
    }
}

class Node {
    public int value;
    public Node next;


}