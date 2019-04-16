import StackAndQueue.MaxWindowArray.getMaxWindow1;
import StackAndQueue.MaxWindowArray.getMaxWindow2;
import org.junit.Test;

public class MaxWindowArrayTest {
    @Test
    public void test() {
        for(int x :getMaxWindow1.getMaxWindow(new int[]{4,3,5,4,3,3,6,7,4,3,2,6,7,8,9},3)) {
            System.out.print(x + " ");
        }
        System.out.println(" ");
        for(int x : getMaxWindow2.getMaxWindow(new int[]{4,3,5,4,3,3,6,7,4,3,2,6,7,8,9},3)) {
            System.out.print(x + " ");
        }
    }
}
