package StackAndQueue.MonotonicStack;

import java.util.Stack;

/**题目：给定一个不含有重复值的数组arr，找到每一个i位置左边和右边离i位置最近且值比
 *       arr[i]小的位置。返回所有位置相应的信息。
 */
public class NoRepeat {
    public static int[][] getNearest(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[][] res = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++) {
            while(!s.isEmpty() && arr[i] < arr[s.peek()]) {
                int temp = s.pop();
                res[temp][1] = i;
                if(!s.isEmpty())res[temp][0] = s.peek();
                else {
                    res[temp][0] = -1;
                }
            }
                s.push(i);
        }
        while(!s.isEmpty()){
            int temp = s.pop();
            res[temp][1] = -1;
            if(!s.isEmpty())res[temp][0] = s.peek();
            else {
                res[temp][0] = -1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] array = {3,4,1,5,6,2,7};
        for(int[] x : getNearest(array)) {
            for(int y :x) {
                System.out.print(y);
            }
            System.out.println();
        }
    }
}
