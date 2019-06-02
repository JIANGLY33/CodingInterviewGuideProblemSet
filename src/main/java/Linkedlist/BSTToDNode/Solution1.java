package Linkedlist.BSTToDNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 解题思路：先利用递归中序遍历将节点依次放入队列中，再从队列中依次弹出节点组合成双向链表
 * 复杂度：时间复杂度为O(N),空间复杂度为O(N)
 * 注意点：需要单独考虑传入的BST为空的情况，若BST为空则队列也为空，此时我们若对队列进行操作便会出现异常
 */
public class Solution1 {
    public static Node translate(Node root) {
        Queue<Node> nodes = new LinkedList<>();
        inOrderToQueue(root,nodes);
        if(nodes.isEmpty())return root;
        root = nodes.poll();
        Node cur = null;
        Node pre = root;
        pre.left = null;   //头节点的last指针为null
        while(! nodes.isEmpty()) {
            cur = nodes.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;  //尾节点的next指针为null
        return root;
    }

    public static void inOrderToQueue(Node root, Queue queue) {
        if(root != null) {
            inOrderToQueue(root.left, queue);
            queue.add(root);
            inOrderToQueue(root.right, queue);
        }
    }

    //测试用例
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
        Node cur = translate(n6);
        while(cur != null) {
            System.out.println(cur);
            cur = cur.right;
        }
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        String res = "value:" + this.value + ",left value: ";
        res += left != null ? left.value:"null";
        res += ",right value: ";
        res += right != null ? right.value:"null";
        return res;
    }
}
