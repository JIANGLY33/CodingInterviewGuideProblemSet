package StackAndQueue.getMinStack;

import java.util.Stack;

public class MyStack2 {
    private Stack<Integer> datastack;
    private Stack<Integer> minstack;

    public MyStack2() {
        datastack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }
    public int pop(){
        minstack.pop();
        return datastack.pop();
    }

    public void push(int x){
        datastack.push(x);
        if(minstack.empty() || minstack.peek() >= x)minstack.push(x);
        else
            minstack.push(minstack.peek());
    }
    public int getMin() {
        return minstack.peek();
    }
}
