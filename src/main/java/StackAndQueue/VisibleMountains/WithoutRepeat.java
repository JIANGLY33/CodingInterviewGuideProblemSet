package StackAndQueue.VisibleMountains;

import java.util.Stack;

public class WithoutRepeat {
    public static int record(int[] array) {
        Stack<Record> stack = new Stack<>();
        int maxIndex = 0,res = 0,amount = 0; //maxIndex存储数组最大值下标，res存储返回结果，amount表示堆栈中存储的不同值的个数
        //先遍历数组找出最大值的索引
        for(int i = 1; i < array.length; i++) {
            maxIndex = array[maxIndex] < array[i] ? i : maxIndex;
        }
        int index = maxIndex == array.length-1 ? 0:maxIndex + 1; //index是第二次遍历数组的游标，初始位置为maxIndex的右侧
        stack.push(new Record(array[maxIndex],1));   //先将最大值对应的记录压入栈中
        amount++;  //栈中不同值的个数加一
        while(index != maxIndex) {  //循环的终点是游标与最大值下标重合
            //构造自底向上递减单调栈
            while(!stack.empty() && stack.peek().value < array[index]) {
                Record temp = stack.pop();
                amount--;
                res += temp.calBetween();
            }
            if(stack.peek().value == array[index])stack.peek().times++;
            else {
                stack.push(new Record(array[index],1));
                amount++;
            }
            index = (index == array.length-1)? 0:index+1;
        }
        while(!stack.empty()) {
            Record temp = stack.pop();
            if(amount > 2) {
                res += temp.calBetween();
            }
            else if(amount == 2) {
                res += temp.calAbove();
            }
            else {
                res += temp.calBelow();
            }
            amount--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1,3,2,4,7,9,6,8};
        int[] array2 = new int[]{1,2,2,4,7,4,3,1};
        System.out.println(record(array1));//测试无重复数字的数组
        System.out.println(record(array2));//测试存在重复数字的数组
    }
}

class Record {
    public int value;
    public int times;
    Record(int value, int times) {
        this.value = value;
        this.times = times;
    }

    /**针对当前所要计算可见山峰对的山峰两侧均有更高山峰，一侧有更高山峰或者没有更高山峰这三种情况
     * 提出以下三种计算方法
     * （注：仅计算“小找大”的可见山峰对，如：高度分别为2，3的相邻山峰，我们在计算2的可见山峰对数量时
     * 将这对山峰纳入考虑范围，而在计算3的可见山峰对数量时不再考虑）
     */
    //当前山峰左右都有更高山峰时的可见山峰对数量:2*该山峰数 + C(山峰数,2)
    public int calBetween() {
        return 2*times + times * (times-1) /2;
    }
    //当前山峰仅有一侧存在更高山峰时的可见山峰对数量:山峰数 + C(山峰数,2)
    public int calAbove() {
        return times + times * (times-1)/2;
    }
    //当前山峰是最高山峰时的可见山峰对数量:山峰数 + C(山峰数,2)
    public int calBelow() {
        return times * (times-1)/2;
    }
}
