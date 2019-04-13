import org.junit.Test;

import java.util.Stack;

import static StackAndQueue.RecursionReverseStack.ReverseStack.reverseStack;

public class ReverseStackTest {
    @Test
    public void test() {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < 10; i++)s.push(i);
        reverseStack(s);
        for(int i = 0; i < 10; i++) System.out.println(s.pop());
    }
}
