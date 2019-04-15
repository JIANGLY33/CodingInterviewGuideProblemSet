package StackAndQueue.MaxWIndowArray;

import java.util.LinkedList;

/** 利用双端队列求解，时间复杂度为O(N)
 *
 */
public class getMaxWindow2 {
    public static int[] getMaxWindow(int[] array, int w) {
        if(array == null || array.length < w)return null; //考虑两种特殊情况：数组为空或者数组长度小于窗口大小
        int[] result = new int[array.length-w+1];
        LinkedList<Integer> DEQueue = new LinkedList<>();
        DEQueue.add(0);
        DEQueue.add(1);
        for(int i = 2; i < array.length; i++) {
            boolean addAlready = false;
            while(!DEQueue.isEmpty() && DEQueue.peekFirst() <= i-w){
                DEQueue.pollFirst();
            }
            while(array[DEQueue.peekLast()] < array[i] ) {
                DEQueue.pollLast();
                if(DEQueue.isEmpty()){
                    DEQueue.add(i);
                    result[i-2] = array[i];
                    addAlready = true;
                    break;
                }
            }
            if(!addAlready) {
                result[i-2] = array[DEQueue.peekFirst()];
                DEQueue.add(i);
            }
        }
        return result;
    }
}
