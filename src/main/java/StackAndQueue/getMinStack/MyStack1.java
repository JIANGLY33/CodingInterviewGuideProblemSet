package StackAndQueue.getMinStack;

import java.util.Stack;

/** 思路简述：我们可以用一个类中封装两个栈来实现该需求。其中一个栈用于保存所有元素，而另一个栈则用于保存栈中的最小元素。
 *  为了后续表述方便，我们姑且把前者称为数据栈，后者称为最小值栈，封装这两个栈来实现所要求的需求的栈称为总栈。数据栈在
 *  总栈每次调用pop或push方法时也调用自己的pop或push方法即可，而最小值栈则需要一定的方法去维护，来保证该栈的栈顶元素是
 *  当前所有元素中的最小值。在本种实现方法中，维护最小值栈的方法是：每push一个新元素，比较新元素与栈顶元素的大小，若小
 *  于栈顶元素，则将该元素压入栈。而每pop一个元素，则要比较被pop元素是否与栈顶元素相等（因为栈顶元素是最小的，不可能出
 *  现被pop元素小于栈顶元素的情况），若相等则pop栈顶元素。根据以上的维护方法，我们可以保证最小值栈的栈顶元素始终是当前
 *  所有元素中的最小值，因此总栈的getMin方法只需调用最小值栈的peek方法即可实现。
 */
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
