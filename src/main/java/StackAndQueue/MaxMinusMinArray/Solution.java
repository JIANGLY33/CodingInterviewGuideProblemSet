package StackAndQueue.MaxMinusMinArray;

import java.util.LinkedList;

/**
 * 重要切入点：array[i...j]满足条件，则它的子数组都满足条件，反之则包含array[i...j]的数组均不满足条件
 */
public class Solution {
        public static int getNumber(int[] array,int number) {
            LinkedList<Integer> max = new LinkedList<>();
            LinkedList<Integer> min = new LinkedList<>();
            int res = 0,i = 0,j = 0;
            while(i < array.length) {
                while(j < array.length) {
                    //随便选一个队列来判断队尾是否与j相同，若相同说明之前j压入过队列，不再重复压入
                    //例外是第一次循环的时候，队列尚且为空，故还需要对队列是否为空进行判断
                    if(max.isEmpty() || max.peekLast()!= j){
                        while(!max.isEmpty() && array[max.peekLast()] <= array[j]) {
                            max.pollLast();
                        }
                        max.addLast(j);
                        while(!min.isEmpty() && array[min.peekLast()] >= array[j]){
                            min.pollLast();
                        }
                        min.addLast(j);
                    }
                    if(array[max.peekFirst()] - array[min.peekFirst()] > number)break;
                    j++;
                }
                res += j-1-i+1;
                //计算为以i为首元素的满足条件的子元素数量后，i需要右移一位
                //此时若队列的队首元素是i，则需要将队首元素排出队列
                if(i == max.peekFirst())max.pollFirst();
                if(i == min.peekFirst())min.pollFirst();
                i++;
            }
            return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};
        System.out.println(getNumber(array,2));
    }
}
