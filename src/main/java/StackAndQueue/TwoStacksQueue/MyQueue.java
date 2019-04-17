package StackAndQueue.TwoStacksQueue;

import java.util.Stack;


/** 思路简述：用两个堆栈实现一个队列，我们可以自然而然地想到一个堆栈用于队尾元素入队列，一个堆栈用于队首元素出队列。
 *  为了后续表达方便，我们姑且把前者简称为队尾栈，后者简称为队首栈。有了这两个栈的概念后，本题最关键的地方在于寻找
 *  将队尾栈中的元素压入队首栈的要求和时机。队首栈和队尾栈各自的功能要求：一组确定的元素在进入队首栈后，它们在栈中
 *  的序列必须是和在队尾栈中的序列是相反的。（比如：在队尾栈中，元素自底向上分别为[A,B,C],则进入队首栈后，元素自底
 *  向上需为[C,B,A]）为了满足这一要求，我们在将队尾栈中元素压入队首栈时，必须保证队首栈为空，且必须一次性将队尾栈中
 *  的所有元素都压入队首栈中。至于队尾栈中元素压入队首栈的时机，诸如poll或peek这种需要从队首获取元素的方法，我们必
 *  须保证在队列非空的情况下，队首栈中一定有元素可以获取，因此需要在队首栈执行pop操作前将队尾栈中的所有元素倾倒入
 *  队首栈中。
 */
public class MyQueue {
    private Stack<Integer> pushStack; //作为队列的尾部，新插入的元素放在其中
    private Stack<Integer> pollStack; //作为队列的首部，元素从该栈离开队列

    public MyQueue() {
        pushStack = new Stack<>();
        pollStack = new Stack<>();
    }

    /** 将队尾栈中的元素全部倒入队首栈中，要求倒入前队首栈必须为空 **/
    private void pushToPoll() {
        if(pollStack.empty()){
            while(!pushStack.empty()){
                pollStack.push(pushStack.pop());
            }
        }

    }
    public int poll(){
        if(pushStack.empty() && pollStack.empty()){
            throw new RuntimeException("Queue is Empty!");
        }
        pushToPoll();  //在poll前将队尾栈中元素都倒入，避免队首栈元素为空（若队首栈不为空，这里不会执行任何操作）
        return pollStack.pop();
    }
    public void add(int x){
        pushStack.push(x);
        pushToPoll();  //这行代码去掉该队列依然可以正常工作
    }
    public int peek() {
        if(pushStack.empty() && pollStack.empty()){
            throw new RuntimeException("Queue is Empty!");
        }
        pushToPoll();
        return pollStack.pop();
    }
}
