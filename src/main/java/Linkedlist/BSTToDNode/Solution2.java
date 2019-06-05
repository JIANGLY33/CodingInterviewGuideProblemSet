package Linkedlist.BSTToDNode;


/**
 * 解题思路：自定义一个数据类型用以表示双链表的头节点和尾节点，并利用递归求解：递归函数接收一个节点，并分别将该节点的左右
 *          子树转为双向链表并得到两个自定义类型的返回值，接下来使左右子树返回的双链表和当前节点相连。连接完毕后左右子树返
 *          回的双链表和当前节点构成一个更大的双链表，将该双链表以我们自定义类型的形式返回。最终将递归得到包含整颗BST的双链
 *          表，从而问题得解。
 * 复杂度：时间复杂度为O(N)(根据递归函数发生的次数进行估算，因为要处理BST的所有N个节点，故时间复杂度为O(N)），空间复杂度为
 *          O(H)(H为二叉树的高度，总共有H层递归函数，故空间复杂度为O(H))
 * 注意点：在让左右子树返回的双链表连向当前节点时，我们需要先判断左子树双链表的尾节点是否为null以及右子树双链表的首节点是否
 *         为null，若为null则无法连接，因为我们无法给null中的字段赋值。但是即便它们为null，我们也依然可以让当前节点连向它们，
 *         因为当前节点的last指针或next指针的值为null是完全合理的。
 *         递归函数在返回更大的双链表时我们要注意双链表端点的选择，如果左子树返回的双链表的首节点为null，则说明左子树为空，
 *         故没有生成双链表，此时更大的双链表的首节点就应该是当前节点；同理若右子树返回的双链表的尾节点为null，则说明右子树
 *         为空没有生成双链表，此时更大的双链表的尾节点也应该是当前节点。
 */
public class Solution2 {
    public static Node translate(Node root) {
        return process(root).start;
    }

    public static ReturnType process(Node head) {
        if(head == null )return new ReturnType(null,null);
        ReturnType leftNodes = process(head.left);
        ReturnType rightNodes = process(head.right);
        if(leftNodes.end != null) {
            leftNodes.end.right = head;
        }
        head.left = leftNodes.end;
        head.right = rightNodes.start;
        if(rightNodes.start != null) {
            rightNodes.start.left = head;
        }
        return new ReturnType(leftNodes.start != null ? leftNodes.start:head,
                              rightNodes.end != null ? rightNodes.end:head);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        n6.left = n4;
        n6.right = n7;
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;
        n7.right = n9;
        n9.left = n8;
        Node cur = translate(null);
        while(cur != null) {
            System.out.println(cur);
            cur = cur.right;
        }
    }
}


class ReturnType {
    Node start;
    Node end;

    public ReturnType(Node start, Node end) {
        this.start = start;
        this.end = end;
    }
}