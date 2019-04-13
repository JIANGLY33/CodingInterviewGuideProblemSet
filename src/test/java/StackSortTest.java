import StackAndQueue.SortStackByStack.StackSort;
import org.junit.Test;

import java.util.Stack;

public class StackSortTest {
    @Test
    public void Test() {
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 10; i > 0; i--) {
            s.push(i);
        }
        StackSort.sort(s);
        for(int i = 0; i < 10; i++) {
            System.out.println(s.pop());
        }
    }
}
