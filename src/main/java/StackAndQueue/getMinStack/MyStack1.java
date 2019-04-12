package StackAndQueue.getMinStack;

import java.util.Stack;

public class MyStack1 {
    private Stack<Integer> datastack;
    private Stack<Integer> minstack;

    public MyStack1() {
        datastack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }

    public int pop(){
        int num = datastack.pop();
        if(num == minstack.peek())
            minstack.pop();
        return num;
    }

    public void push(int x){
        datastack.push(x);
        if(minstack.empty())minstack.push(x);
        else if(x <= minstack.peek())minstack.push(x);
    }

    public int getMin() {
        return minstack.peek();
    }
}
