package StackAndQueue.MonotonicStack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**题目：给定一个可能存在重复值的数组arr，找到每一个i位置左边和右边离i位置最近且值比
 *       arr[i]小的位置。返回所有位置相应的信息。
 */

public class Repeat {
    public static int[][] getNearest(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> s = new Stack<>();

        for(int i = 0; i < arr.length; i++ ) {
            List<Integer> pos = new LinkedList<>();
            while(!s.isEmpty() && arr[i] < arr[s.peek().get(0)]) {
                List<Integer> temp = s.pop();
                for(int x : temp) {
                    res[x][1] = i;
                    if(!s.isEmpty())res[x][0] = s.peek().get(s.peek().size()-1);
                    else res[x][0] = -1;
                }
            }
            if(s.isEmpty() || arr[i] > arr[s.peek().get(0)]){
                pos.add(i);
                s.push(pos);
            }
            else s.peek().add(i);
        }
        while(!s.isEmpty()) {
            List<Integer> temp = s.pop();
            for(int x : temp) {
                res[x][1] = -1;
                if(!s.isEmpty())res[x][0] = s.peek().get(s.peek().size()-1);
                else res[x][0] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {3,1,3,4,3,5,3,2,2};
        for(int[] x : getNearest(array)) {
            for(int y :x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
