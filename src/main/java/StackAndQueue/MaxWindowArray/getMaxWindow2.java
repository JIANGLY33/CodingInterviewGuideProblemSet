package StackAndQueue.MaxWindowArray;
import java.util.LinkedList;

/** 利用双端队列求解，时间复杂度为O(N)
 *  思路简述：遍历数组，将数组中的元素压入队列，同时对双端队列进行维护，保证双端队列的队首元素的下标大于
 *  当前数组元素下标减去窗口大小，队尾元素的下标在数组中对应的值大于当前元素。这样即可保证：每当有数组元素
 *  进入队列时，将队首元素存入结果数组中，该元素将是当前窗口中的最大元素。但需要注意的是：必须在数组的第w个
 *  元素（下标为w-1）进入队列后才能开始往结果数组中添加元素，因为直到第w个元素进入队列前，我们无法直到前w个
 *  元素究竟哪个才是最大元素。
 */
public class getMaxWindow2 {
    public static int[] getMaxWindow(int[] array, int w) {
        if(array == null || array.length < w)return null; //考虑两种特殊情况：数组为空或者数组长度小于窗口大小
        int[] result = new int[array.length-w+1];  //结果数组
        LinkedList<Integer> DEQueue = new LinkedList<>();  //双端队列，存储数组元素的下标
        for(int i = 0; i < array.length; i++) {
            while(!DEQueue.isEmpty() && array[DEQueue.peekLast()] < array[i] ) {
                DEQueue.pollLast();
            }
            DEQueue.add(i);
            if(DEQueue.peekFirst() == i-w)
                DEQueue.pollFirst();
            if(i >= w-1)result[i-w+1] = array[DEQueue.peekFirst()];//第w个元素进入队列，可以开始往结果数组中添加元素
        }
        return result;
    }
}
