import StackAndQueue.getMinStack.MyStack1;
import StackAndQueue.getMinStack.MyStack2;
import org.junit.Test;

public class GetMinStackTest {

    @Test
    public void test1() {
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
