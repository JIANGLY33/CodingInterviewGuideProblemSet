import StackAndQueue.HanoiProblem.Resolution1;
import StackAndQueue.HanoiProblem.Resolution2;
import org.junit.Test;

public class HanoiTest {
    @Test
    public void test() {
        Resolution1.resolve(2,"left","right");
        Resolution2.resolve(2);
    }
}
