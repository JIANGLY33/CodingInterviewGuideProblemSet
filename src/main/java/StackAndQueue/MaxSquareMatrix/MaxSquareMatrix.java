package StackAndQueue.MaxSquareMatrix;

import java.util.Stack;

/**单调栈特点：
 * 1.栈中存储元素为数组索引
 * 2.栈顶元素底下的元素是数组中最靠近栈顶元素但是在数组中对应的值小于栈顶元素在数组中对应的值的元素（假设栈是自底向上递增栈）
 */

public class MaxSquareMatrix {
    public static int calculate(int[][] matrix) {
        Stack<Integer> stack = new Stack<>();
        int[] array = new int[matrix[0].length];
        int[] result = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1)array[j]++;
                else array[j] = 0;
                while(!stack.empty()&&array[stack.peek()] >= array[j]) {
                    int temp = stack.pop();
                    int k = stack.isEmpty()?-1:stack.peek();
                    int area = (j-k-1)*array[temp];  //向左最远到k+1位置，向右最远到j-1位置，面积为（j-1-k-1+1）*高度
                    if(area > result[j])result[temp] = area;
                }
                stack.push(j);
            }
            while(!stack.empty()) {
                int temp = stack.pop();
                int k = stack.isEmpty()?-1:stack.peek();
                int area = (k+1)*array[temp];
                if(area > result[temp])result[temp] = area;
            }
        }
        int max = 0;
        for (int j : result) {
            if(j > max)max = j;
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        int[][] array2 = new int[][]{{1,0,1,1},{1,1,1,1},{1,1,1,0},{1,1,1,1},{1,1,1,1}};
        System.out.println("max square matrix's area is " + calculate(array2));
    }
}
