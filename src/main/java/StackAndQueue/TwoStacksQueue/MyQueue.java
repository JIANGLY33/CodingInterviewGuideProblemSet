package StackAndQueue.TwoStacksQueue;

import java.util.Stack;

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
