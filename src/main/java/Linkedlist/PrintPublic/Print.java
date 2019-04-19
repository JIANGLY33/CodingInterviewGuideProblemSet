package Linkedlist.PrintPublic;

public class Print {
    public void printPublic(Node head1,Node head2) {
        while(head1 != null && head2 != null) {
           if(head1.getValue() < head2.getValue())head1 = head1.getNext();
           else if(head1.getValue() > head2.getValue())head2 = head2.getNext();
           else {
               System.out.print(head1.getValue() + " ");
           }
        }
        System.out.println();
    }
}

class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}