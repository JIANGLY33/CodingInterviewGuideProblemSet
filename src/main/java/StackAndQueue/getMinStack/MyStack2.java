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

    public static void main(String[] args) {
        MyStack1 s1 = new MyStack1();
        MyStack2 s2 = new MyStack2();
        for(int i = 0; i < 10; i++){
            s1.push(i);
            s2.push(i);
        }

        System.out.println(s1.getMin());
        System.out.println(s2.getMin());
    }
}
