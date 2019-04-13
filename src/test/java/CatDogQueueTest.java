import StackAndQueue.CatDogQueue.Cat;
import StackAndQueue.CatDogQueue.Dog;
import StackAndQueue.CatDogQueue.MyQueue1;
import StackAndQueue.CatDogQueue.MyQueue2;
import org.junit.Test;

public class CatDogQueueTest {
    @Test
    public void test() {
      //  MyQueue1 q = new MyQueue1();
        MyQueue2 q = new MyQueue2();
        for(int i = 0; i < 3; i++){
            Dog dog = new Dog();
            Cat cat = new Cat();
            q.add(dog);
            q.add(cat);
        }
//        for(int i = 0; i < 6; i++) {
//            System.out.println(q.pollAll());
//        }
        System.out.println(q.pollCat());
        System.out.println(q.pollDog());
        System.out.println(q.pollDog());
        System.out.println(q.pollAll());
        System.out.println(q.isCatEmpty());
        System.out.println(q.isDogEmpty());
        System.out.println(q.isEmpty());
        System.out.println(q.pollAll());
        System.out.println(q.isDogEmpty());
        System.out.println(q.pollAll());
        System.out.println(q.isCatEmpty());
        System.out.println(q.isEmpty());
    }
}
