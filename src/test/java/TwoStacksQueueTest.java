import StackAndQueue.TwoStacksQueue.MyQueue;
import org.junit.Test;

public class TwoStacksQueueTest {
    @Test
    public void test() {
        MyQueue q = new MyQueue();
        for(int i = 0; i < 2; i++) {
            q.add(i);
        }
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
