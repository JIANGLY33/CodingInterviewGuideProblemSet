package Datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public class RBTreeDIY <T extends Comparable<T> >{
    private RBTreeNode<T> root;

    private AtomicLong size;

    public RBTreeDIY() {
        this.root = new RBTreeNode<T>();
        size = new AtomicLong(0);
    }

    public long getSize() {
        return size.get();
    }

    private RBTreeNode<T> getRoot() {
        return root.getLeft();
    }

    public T find(T value) {
        RBTreeNode<T> dataNode = getRoot();
        while(dataNode != null) {
            int cmp = dataNode.getValue().compareTo(value);
            if(cmp < 0) {
                dataNode = dataNode.getLeft();
            }else if(cmp > 0) {
                dataNode = dataNode.getRight();
            }
            else {
                return dataNode.getValue();
            }
        }
        return null;
    }

    /**
     * 向红黑树中添加一个新的节点，如果该节点对应的值存在于红黑树中，则不插入新节点并直接返回节点值
     * 若该节点的值不存在于红黑树中，则成功插入并返回null
     * @param value
     * @return
     */
    public T insert(T value) {
        RBTreeNode<T> newNode = new RBTreeNode<T>(value);
        newNode.setLeft(null);
        newNode.setRight(null);
        newNode.setRed(true);
        newNode.setParent(null);


        if(root.getLeft() == null) {  //红黑树中没有节点的情况
            root.setLeft(newNode);
            size.incrementAndGet();
            newNode.setRed(false);
        }else {
            RBTreeNode<T> parent = findParent(newNode);
            int cmp = value.compareTo(parent.getValue());
            if(cmp < 0) {
                parent.setLeft(newNode);
            }
            else if(cmp > 0){
                parent.setRight(newNode);
            }
            else {
                return value;
            }
            setParent(newNode,parent);

            insertFix(newNode);

            size.incrementAndGet();
        }
        return null;
    }

    public T remove(T value) {
        RBTreeNode<T> node = getRoot();
        RBTreeNode<T> parent = root;

        while(node != null) {
            int cmp = value.compareTo(node.getValue());

            if(cmp < 0) {
                parent = node;
                node = node.getLeft();
            }else if(cmp > 0) {
                parent = node;
                node = node.getRight();
            }else {
                if(node.getRight() != null) {   //被删除节点存在左子树时
                    RBTreeNode<T> min = removeMin(node.getRight());

                    RBTreeNode<T> fixNode = min.getRight() == null? min.getParent():min.getRight();
                    boolean isParent = fixNode == min.getParent();

                    min.setLeft(node.getLeft());
                    setParent(node.getLeft(),min);
                    if(parent.getLeft() == node) {
                        parent.setLeft(min);
                    }else {
                        parent.setRight(min);
                    }
                    setParent(min,parent);

                    boolean minIsBlack = min.isBlack();
                    min.setRed(true);

                    if(min != node.getRight()) {
                        min.setRight(node.getRight());
                        setParent(node.getRight(),min);
                    }
                    if(minIsBlack) {
                        deleteFix(min);
                    }
                }else {   //被删除节点存在左子树时
                    if(node == parent.getRight())parent.setRight(node.getLeft());
                    else parent.setLeft(node.getLeft());
                    setParent(node.getLeft(),parent);

                    if(node.isBlack() && root.getLeft() != null) {
                        deleteFix(node);
                    }
                }
                if(getRoot() != null) {
                    getRoot().setRed(false);
                    getRoot().setParent(null);
                }
                size.decrementAndGet();
                return node.getValue();
            }
        }
        return null;
    }

    private RBTreeNode<T> getSibling(RBTreeNode<T> node) {
        if(node == null)return node;
        RBTreeNode<T> parent = node.getParent();
        if(parent != null) {
            if(node == parent.getLeft())return parent.getRight();
            else return parent.getLeft();
        }
        return null;
    }

    private void deleteFix(RBTreeNode<T> node) {
        RBTreeNode<T> parent = node.getParent();
        RBTreeNode<T> cur = node;

        while(cur != getRoot()) {
            RBTreeNode<T> sibling = getSibling(node);
            boolean isSiblingRed = sibling.isRed();
            boolean isLeft = cur == parent.getLeft();
            boolean isParentRed = parent.isRed();

            if(isSiblingRed) {  //情况1
                if(isLeft) {
                    sibling.getLeft().setRed(true);
                    rotateLeft(parent);

                }else {
                    sibling.getRight().setRed(true);
                    rotateRight(parent);
                }
                sibling.setRed(false);
                break;
            } else {
                if(isLeft && isRed(sibling.getRight())) {  //情况3
                    rotateLeft(parent);
                    sibling.getRight().setRed(false);
                    break;
                } else if(!isLeft && isRed(sibling.getLeft())) {
                    rotateRight(parent);
                    sibling.getLeft().setRed(false);
                    break;
                }else if(isLeft && isRed(sibling.getLeft())) {  //情况4
                    rotateRight(sibling);
                }else if(!isLeft && isRed(sibling.getRight())) {
                    rotateLeft(sibling);
                }else {                  //情况2
                    if(isParentRed) {
                        parent.setRed(false);
                        sibling.setRed(true);
                        break;
                    }else {
                        sibling.setRed(true);
                    }
                }
            }
        }
    }

    private RBTreeNode<T> removeMin(RBTreeNode<T> node) {
        RBTreeNode<T> parent = node;
        RBTreeNode<T> child = node;
        while(child != null && child.getLeft() != null) {
            parent = child;
            child = child.getLeft();
        }
        if(child == parent)return child;

        parent.setLeft(child.getRight());
        setParent(child.getRight(),parent);
        return child;
    }

    private boolean isRed(RBTreeNode<T> node) {
        if(node == null)return false;
        return node.isRed();
    }
    /**
     * 在红黑树中查找形参节点父节点的位置，若形参已在红黑树中，则将其返回，否则返回它插入后父节点的位置
     * @param node
     * @return
     */
    private RBTreeNode<T> findParent(RBTreeNode<T> node) {
        RBTreeNode<T> parent = getRoot();
        RBTreeNode<T> child = parent;
        while(child != null) {
            int cmp = node.getValue().compareTo(child.getValue());
            if(cmp < 0 ){
                parent = child;
                child = child.getLeft();
            }else if(cmp > 0 ){
                parent = child;
                child = child.getRight();
            }else {
                return child;
            }
        }
        return parent;
    }

    private RBTreeNode<T> findUncle(RBTreeNode<T> node) {
        RBTreeNode<T> parent = node.getParent();
        RBTreeNode<T> grandParent = parent.getParent();

        if(grandParent == null)return null;
        if(grandParent.getLeft() == parent) {
            return grandParent.getRight();
        }else {
            return grandParent.getLeft();
        }
    }

    private void insertFix(RBTreeNode<T> node) {
        RBTreeNode<T> parent = node.getParent();

        while(parent != null && parent.isRed()) {
            RBTreeNode<T> uncle = findUncle(node);
            RBTreeNode<T> grandParent = parent.getParent();
            if(uncle == null || !isRed(uncle)) {
                if(parent == grandParent.getLeft()) {
                    boolean isRight = node == parent.getRight();

                    if(isRight) {
                        rotateLeft(parent);
                    }
                    rotateRight(grandParent);

                    if(isRight) {
                        node.setRed(false);
                        parent = null; //直接结束循环，parent和node间此时存在环
                    }else {
                        parent.setRed(false);
                    }
                    grandParent.setRed(true);
                }else {
                    boolean isRight = node == parent.getRight();

                    if(!isRight) {
                        rotateRight(parent);
                    }
                    rotateLeft(grandParent);
                    if(!isRight) {
                        node.setRed(false);
                        parent = null;
                    }else {
                        parent.setRed(false);
                    }
                    grandParent.setRed(true);
                }
            } else {
                parent.setRed(false);
                uncle.setRed(false);
                grandParent.setRed(true);
                node = grandParent;
                parent = node.getParent();
            }
        }
        getRoot().setRed(false);
        getRoot().setParent(null);
    }
    private void rotateLeft(RBTreeNode<T> node) {
        RBTreeNode<T> right = node.getRight();
        if(right == null) throw new RuntimeException("right node is null");

        RBTreeNode<T> parent = node.getParent();

        node.setRight(right.getLeft());
        setParent(right.getLeft(),node);

        right.setLeft(node);
        setParent(node,right);

        if(parent == null) {
            root.setLeft(right);
        }else {
            if(parent.getLeft() == node)parent.setLeft(right);
            else parent.setRight(right);
        }
        setParent(right,parent);
    }

    private void rotateRight(RBTreeNode<T> node) {
        RBTreeNode<T> left = node.getLeft();
        if(left == null) throw new RuntimeException("left node is null");

        RBTreeNode<T> parent = node.getParent();

        node.setLeft(left.getRight());
        setParent(left.getRight(),node);

        left.setLeft(node);
        setParent(node,left);

        if(parent == null) {
            root.setLeft(left);
        }else {
            if(parent.getLeft() == node)parent.setLeft(left);
            else parent.setRight(left);
        }
        setParent(left,parent);
    }

    private void setParent(RBTreeNode<T> node, RBTreeNode<T> parent) {
       if(node != null) {
           node.setParent(parent);
          if(parent == root)node.setParent(null);
       }
    }

    public void print() {
        RBTreeNode<T> root = getRoot();
        Queue<RBTreeNode<T>> queue = new LinkedList<>();
        if(root != null)queue.add(root);
        while(!queue.isEmpty()) {
            RBTreeNode<T> node = queue.poll();
            if(node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if(node.getRight() != null) {
                queue.add(node.getRight());
            }
            System.out.println(node);
        }
    }

    public static void main(String[] args) {
        RBTreeDIY<Integer> RBT = new RBTreeDIY<>();
        for(int i = 0; i < 10; i++) RBT.insert(i);
        RBT.print();
    }
}
