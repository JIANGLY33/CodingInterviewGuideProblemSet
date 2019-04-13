package StackAndQueue.SortStackByStack;

import java.util.Stack;

public class StackSort {
    public static void sort(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();
        while(!s.empty()) {
            int cur = s.pop();
            if(temp.empty())temp.push(cur);
            else {
                while(!temp.empty() && cur > temp.peek())
                    s.push(temp.pop());
                temp.push(cur);
            }
        }
        while(!temp.empty())
            s.push(temp.pop());
    }
}
